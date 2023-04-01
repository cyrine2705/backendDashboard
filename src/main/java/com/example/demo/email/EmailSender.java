package com.example.demo.email;

public interface EmailSender {
    void send(String to, String email);
    void sendResetPasswordEmail(String to, String email);
}
