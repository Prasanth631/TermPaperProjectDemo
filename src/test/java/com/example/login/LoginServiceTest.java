package com.example.login;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceTest {

    LoginService service = new LoginService();

    @Test
    public void testValidLogin() {
        assertTrue(service.validateLogin("john", "john@example.com", "9876543210", "secure123", "1995-08-15"));
    }

    @Test
    public void testInvalidEmail() {
        assertFalse(service.validateLogin("john", "wrongemail", "9876543210", "secure123", "1995-08-15"));
    }

    @Test
    public void testInvalidMobile() {
        assertFalse(service.validateLogin("john", "john@example.com", "123", "secure123", "1995-08-15"));
    }
}
