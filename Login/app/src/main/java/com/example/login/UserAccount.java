package com.example.login;

public class UserAccount {
    private String emailId;
    private String password;
    private String idToken;

    public UserAccount() {}

    public String getIdToken() { return idToken; }

    public void setIdToken(String idToken) { this.idToken = idToken; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getEmailId() { return emailId; }

    public void setEmailId(String emailId) { this.emailId = emailId; }
}
