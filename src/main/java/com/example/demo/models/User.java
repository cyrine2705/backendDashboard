package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User implements UserDetails {

@Id
private String id;

private String lastName;
private String firstName;
private String email;
@JsonFormat(pattern="yyyy-MM-dd")
private Date birthDate;
private String adress;
private int cin;
private int phoneNumber1;
private int phoneNumber2;
private String image;
private String password;
private int nbConge;

private Role role;
private String situation;
private String sexe;
private int nbEnfants;
private boolean present;

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime startTime;
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime endTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime entryTime;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime exitingTime;
	private String resetToken;
	private String deviceToken;
	private Date resetTokenExpiration;


	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getId() {
	return id;
}
public void setId( String  id) {
	this.id = id;
}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public int getCin() {
	return cin;
}
public void setCin(int cin) {
	this.cin = cin;
}

	public int getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(int phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public int getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(int phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

public int getNbConge() {
	return nbConge;
}
public void setNbConge(int nbConge) {
	this.nbConge = nbConge;
}

public String getSituation() {
	return situation;
}
public void setSituation(String situation) {
	this.situation = situation;
}
public int getNbEnfants() {
	return nbEnfants;
}
public void setNbEnfants(int nbEnfants) {
	this.nbEnfants = nbEnfants;
}


	public LocalDateTime getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(LocalDateTime entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDateTime getExitingTime() {
		return exitingTime;
	}

	public void setExitingTime(LocalDateTime exitingTime) {
		this.exitingTime = exitingTime;
	}

	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Date getResetTokenExpiration() {
		return resetTokenExpiration;
	}

	public void setResetTokenExpiration(Date resetTokenExpiration) {
		this.resetTokenExpiration = resetTokenExpiration;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", lastName='" + lastName + '\'' +
				", firstName='" + firstName + '\'' +
				", email='" + email + '\'' +
				", birthDate=" + birthDate +
				", adress='" + adress + '\'' +
				", cin=" + cin +
				", phoneNumber1=" + phoneNumber1 +
				", phoneNumber2=" + phoneNumber2 +
				", image='" + image + '\'' +
				", password='" + password + '\'' +
				", nbConge=" + nbConge +
				", role=" + role +
				", situation='" + situation + '\'' +
				", sexe='" + sexe + '\'' +
				", nbEnfants=" + nbEnfants +
				", present=" + present +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", entryTime='" + entryTime + '\'' +
				", exitingTime='" + exitingTime + '\'' +
				", resetToken='" + resetToken + '\'' +
				", deviceToken='" + deviceToken + '\'' +
				", resetTokenExpiration=" + resetTokenExpiration +
				'}';
	}
}
