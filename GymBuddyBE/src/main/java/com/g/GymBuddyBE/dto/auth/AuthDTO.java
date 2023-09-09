package com.g.GymBuddyBE.dto.auth;

public class AuthDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
