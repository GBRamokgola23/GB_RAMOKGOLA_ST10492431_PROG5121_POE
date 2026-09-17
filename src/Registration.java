//
  PROG5121 - POE Part 1
 Student: G B Ramokgola - ST10492431
  
  DEVELOPMENT NOTE: This project was fully coded and tested in NetBeans IDE.
  This GitHub repository (GB_RAMOKGOLA_ST10492431_PROG5121_POE) is a copy
 created solely to fulfill the POE requirement for GitHub submission.
  Original NetBeans project functionality remains unchanged.
 //
package javapoe.gomolemo.ramokgola.st10492431;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Cellphone Number (e.g. +27838968976): ");
        String cellNumber = scanner.nextLine();

        Login user = new Login(username, password, cellNumber);

        if (!user.checkUserName()) {
            System.out.println("Username incorrectly formatted - must contain underscore and max 5 chars");
        } else {
            System.out.println("Username successfully captured.");
        }

        if (!user.checkPasswordComplexity()) {
            System.out.println("Password incorrectly formatted");
        } else {
            System.out.println("Password successfully captured.");
        }

        if (!user.checkCellPhoneNumber()) {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code");
        } else {
            System.out.println("Cell number successfully added.");
        }

        String regStatus = user.registerUser();
        System.out.println(regStatus);


        switch (regStatus) {
            case "User registered successfully.":
                System.out.println("\n=== LOGIN ===");
              
                for (int attempt = 1; attempt <= 3; attempt++) {
                    System.out.print("Enter Username to login: ");
                    String loginUsername = scanner.nextLine();
                    System.out.print("Enter Password to login: ");
                    String loginPassword = scanner.nextLine();

                    boolean loggedIn = user.loginUser(loginUsername, loginPassword);
                    String msg = user.returnLoginStatus(loggedIn);

                    
                    switch (attempt) {
                        case 1:
                        case 2:
                        case 3:
                            System.out.println(msg);
                            break;
                        default:
                            break;
                    }

                    if (loggedIn) {
                        break;
                    } else if (attempt < 3) {
                        System.out.println("Attempt " + attempt + " of 3 failed, try again");
                    }
                }
                break;
            default:
                System.out.println("Registration failed - fix errors above to login");
                break;
        }

        scanner.close();
    }
}