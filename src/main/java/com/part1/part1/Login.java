/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.part1.part1;

import java.util.regex.Pattern;

public class Login {
    // Campos para armazenar as informações do usuário
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Verifica se o nome de usuário contém underline e tem no máximo 5 caracteres
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Verifica a complexidade da senha
    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpecial = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE).matcher(password).find();
        
        return password.length() >= 8 && hasCap && hasNum && hasSpecial;
    }

    // Verifica o formato do número de celular (+27...)
    public boolean checkCellPhoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() == 12 && phone.substring(1).matches("\\d+");
    }

    // Lógica de registro retornando as mensagens formatadas do enunciado
    public String registerUser(String username, String password, String firstName, String lastName, String phone) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phone;

        return "Username successfully captured.\nPassword successfully captured.";
    }

    // Verificação de login
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return enteredUsername.equals(this.username) && enteredPassword.equals(this.password);
    }

    // Retorna mensagem de status do login
    public String returnLoginStatus(boolean loggedIn) {
        if (loggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}