/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.part1.part1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    Login login = new Login();

    @Test
    public void testUsernameCorrect() {
        // Test Data from Image 5/6: "kyl_1"
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrect() {
        // Test Data from Image 5/6: "kyle!!!!!!"
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }

    @Test
    public void testPasswordComplexitySuccess() {
        // Test Data from Image 6: "Ch&&sec@ke99!"
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordComplexityFailure() {
        // Test Data from Image 6: "password"
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testRegistrationMessaging() {
        // Testing the exact strings required by the rubric in Image 6
        String success = login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe", "+27838968976");
        assertTrue(success.contains("Username successfully captured."));
        assertTrue(success.contains("Password successfully captured."));

        String failUser = login.registerUser("kyle!!!!!!", "Ch&&sec@ke99!", "John", "Doe", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", failUser);
    }
}