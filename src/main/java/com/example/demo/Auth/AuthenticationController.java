package com.example.demo.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register/employe")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerEmploye(request));
    }
    @PostMapping("/register/hr")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.registerHR(request));
    }
    @PostMapping("/authenticate")
    public AuthenticationResponse authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return service.authenticate(request);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody RegisterRequest request) throws Exception {
        service.resetPassword(request.getEmail());
        return ResponseEntity.ok().build();
    }


    @PostMapping("/reset-password/{token}")
    public ResponseEntity<?> resetPasswordWithToken(@PathVariable String token, @RequestBody  RegisterRequest request) throws Exception {
       service.resetPasswordWithToken(token, request.getPassword());
        return ResponseEntity.ok().build();
    }

}
