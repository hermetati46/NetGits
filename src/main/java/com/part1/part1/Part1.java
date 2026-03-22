/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.part1.part1;

import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login auth = new Login();

        System.out.println("--- REGISTRATION ---");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        System.out.print("Enter Username: ");
        String user = input.nextLine();
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = input.nextLine();

        // Register and display status
        String regStatus = auth.registerUser(user, pass, fName, lName, phone);
        System.out.println(regStatus);

        // Only proceed to login if registration was successful (based on message content)
        if (regStatus.contains("successfully captured")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter Username: ");
            String loginUser = input.nextLine();
            System.out.print("Enter Password: ");
            String loginPass = input.nextLine();

            boolean loginResult = auth.loginUser(loginUser, loginPass);
            System.out.println(auth.returnLoginStatus(loginResult));
        }
    }
}