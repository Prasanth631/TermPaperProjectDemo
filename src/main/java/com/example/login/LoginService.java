package com.example.login;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Service class for login validation
 */
public class LoginService {

    /**
     * Validates all login credentials
     */
    public boolean validateLogin(String username, String email, String mobile, String password, String dob) {
        return isValidUsername(username) &&
               isValidEmail(email) &&
               isValidMobile(mobile) &&
               isValidPassword(password) &&
               isValidDOB(dob);
    }

    /**
     * Validates username (at least 3 characters)
     */
    public boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    /**
     * Validates email format
     */
    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    /**
     * Validates mobile number (10 digits)
     */
    public boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("^\\d{10}$");
    }

    /**
     * Validates password (at least 8 characters with at least one digit, 
     * one lowercase, one uppercase, and one special character)
     */
    public boolean isValidPassword(String password) {
        return password != null && 
               password.length() >= 8 && 
               password.matches(".*\\d.*") && // at least one digit
               password.matches(".*[a-z].*") && // at least one lowercase
               password.matches(".*[A-Z].*") && // at least one uppercase
               password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?].*"); // at least one special char
    }

    /**
     * Validates date of birth (format: YYYY-MM-DD)
     */
    public boolean isValidDOB(String dob) {
        if (dob == null) return false;
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(dob, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}