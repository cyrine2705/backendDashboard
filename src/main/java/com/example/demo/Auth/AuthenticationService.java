package com.example.demo.Auth;

import com.example.demo.Token.Token;
import com.example.demo.Token.TokenRepository;
import com.example.demo.Token.TokenType;
import com.example.demo.config.JwtService;
import com.example.demo.email.EmailSender;
import com.example.demo.models.Employe;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.EmployeRespository;
import com.example.demo.repositories.HRRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final EmployeRespository repository;

    private final HRRespository HRrepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailSender emailSender;
    private static final long TOKEN_EXPIRATION_TIME = 24 * 60 * 60 * 1000;

    public static String generatePassword() {
        int length = 10;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            password.append(chars.charAt(index));
        }
        return password.toString();
    }

    public AuthenticationResponse registerEmploye(RegisterRequest request) {

if( !repository.findByEmail(request.getEmail()).isEmpty()){

    throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists.");
}
        var generatedPassword = generatePassword();
        var user = Employe.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .adress(request.getAdress())
                .cin(request.getCin())
                .password(passwordEncoder.encode(generatedPassword))
                .phoneNumber1(request.getPhoneNumber1())
                .phoneNumber2(request.getPhoneNumber2())
                .image(request.getImage())
                .sexe(request.getSexe())
                .situation(request.getSituation())
                .nbEnfants(request.getNbEnfants())
                .nbConge(request.getNbConge())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .role(Role.EMPLOYE)
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
      String link = generatedPassword ;
        emailSender.send(
              request.getEmail(),
                buildEmail(request.getFirstName(), link));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse registerHR(RegisterRequest request) {

        if( !HRrepository.findByEmail(request.getEmail()).isEmpty()){

            throw new IllegalArgumentException("User with email " + request.getEmail() + " already exists.");
        }
        var generatedPasswordHR = generatePassword();
        var user = Employe.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .birthDate(request.getBirthDate())
                .adress(request.getAdress())
                .cin(request.getCin())
                .password(passwordEncoder.encode(generatedPasswordHR))
                .phoneNumber1(request.getPhoneNumber1())
                .phoneNumber2(request.getPhoneNumber2())
                .image(request.getImage())
                .sexe(request.getSexe())
                .situation(request.getSituation())
                .nbEnfants(request.getNbEnfants())
                .nbConge(request.getNbConge())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .role(Role.RH)
                .build();
        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        saveUserToken(savedUser, jwtToken);
        String link = generatedPasswordHR ;
        emailSender.send(
                request.getEmail(),
                buildEmail(request.getFirstName(), link));
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    ));

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email or password");
        }
        var user = repository.findByEmail(request.getEmail())
                .map(u -> {
                    try {
                        var jwtToken = jwtService.generateToken(u);
                        saveUserToken(u, jwtToken);
                        return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
                    } catch (AccessDeniedException e) {
                        throw new AccessDeniedException("Access is denied");
                    }
                })
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return user;
    }




    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void resetPassword(String email) throws Exception {
        User user = repository.findByEmail(email).get();

        if (user == null) {
            throw new Exception("User not found");
        }

        String token = UUID.randomUUID().toString();
        user.setResetToken(token);
        user.setResetTokenExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME));
        repository.save(user);

        String resetPasswordLink = "http://localhost:4200/#/reset-password?token=" + token;
        emailSender.sendResetPasswordEmail(email, resetPasswordLink);
    }
    public void resetPasswordWithToken(String token, String newPassword) throws Exception {
        User user = repository.findByResetToken(token);
        System.out.println("thiiiiiiiis"+user);

        if (user == null) {
            throw new Exception("Invalid token");
        }

        if (user.getResetTokenExpiration().before(new Date())) {
            throw new Exception("Token has expired");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null);
        user.setResetTokenExpiration(null);
        repository.save(user);
    }


    private String buildEmail(String name, String link) {
        return "Hello " + name + " ,<br> This is your password on bee app :  " + link +" .<br> You can change it later";
    }
}
