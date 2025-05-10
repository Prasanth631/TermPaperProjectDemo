package com.example.login;

import java.util.regex.*;

public class LoginService {

    public boolean validateLogin(String username, String email, String mobile, String password, String dob) {
        return isValidUsername(username) &&
               isValidEmail(email) &&
               isValidMobile(mobile) &&
               isValidPassword(password) &&
               isValidDOB(dob);
    }

    private boolean isValidUsername(String username) {
        return username != null && username.length() >= 3;
    }

    private boolean isValidEmail(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$");
    }

    private boolean isValidMobile(String mobile) {
        return mobile != null && mobile.matches("^\\d{10}$");
    }

    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    private boolean isValidDOB(String dob) {
        return dob != null && dob.matches("^\\d{4}-\\d{2}-\\d{2}$"); // Format: YYYY-MM-DD
    }
}
