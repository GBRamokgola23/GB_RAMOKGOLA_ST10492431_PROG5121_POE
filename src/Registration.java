package javapoe.gomolemo.ramokgola.st10492431;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== REGISTRATION ===");
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        System.out.print("Enter Cellphone Number (e.g. +27838968976): ");
        String cellNumber = scanner.nextLine();

        Login user = new Login(username, password, cellNumber);

        // Check registration
        if (!user.checkUserName()) {
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            return;
        }
        if (!user.checkPasswordComplexity()) {
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            return;
        }
        if (!user.checkCellPhoneNumber()) {
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            return;
        }

        System.out.println("You have successfully registered!");

        // === LOGIN WITH 3 ATTEMPTS ===
        boolean loggedIn = false;
        int attempt = 1;
        
        while (attempt <= 3 && !loggedIn) {
            System.out.println("\n=== LOGIN - Attempt " + attempt + " of 3 ===");
            System.out.print("Enter Username: ");
            String loginUsername = scanner.nextLine();
            System.out.print("Enter Password: ");
            String loginPassword = scanner.nextLine();

         if (user.loginUser(loginUsername, loginPassword)) {
            loggedIn = true;
            System.out.println(user.returnLoginStatus(true));
        } else {
            System.out.println(user.returnLoginStatus(false));
            if (attempt < 3) {
                System.out.println("Attempt " + attempt + " of 3 failed, try again");
            }
            attempt++;
        }   
        }

        if (!loggedIn) {
            System.out.println("Registration failed - fix errors above to login");
            scanner.close();
            return;
        }

        // === PART 2 - QUICKCHAT STARTS HERE - THIS WAS MISSING ===
        System.out.println("\n=== Welcome to QuickChat ===");
        Message msgObj = new Message();

        System.out.print("How many messages do you want to send? ");
        int numMessages = 0;
        try {
            numMessages = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            numMessages = 1;
        }

        int totalSent = 0;

        for (int i = 0; i < numMessages; i++) {
            System.out.println("\n--- Message " + (i + 1) + " ---");
            
            String messageID = msgObj.checkMessageID();
            System.out.println("Message ID generated: " + messageID);

            System.out.print("Enter recipient number (must include + and be max 13 chars e.g. +27838968976): ");
            String recipient = scanner.nextLine();

            while (!msgObj.checkRecipientCell(recipient)) {
                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.");
                System.out.print("Enter recipient again: ");
                recipient = scanner.nextLine();
            }

            System.out.print("Enter your message (max 250 characters): ");
            String messageText = scanner.nextLine();

            while (messageText.length() > 250) {
                System.out.println("Please enter a message of less than 250 characters");
                System.out.print("Enter message again: ");
                messageText = scanner.nextLine();
            }

            String hash = msgObj.createMessageHash(messageID, i, messageText);

            System.out.println("\n1. Send Message");
            System.out.println("2. Disregard Message");
            System.out.println("3. Store Message");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            System.out.println("\n======== MESSAGE DETAILS ========");
            System.out.println("Message ID: " + messageID);
            System.out.println("Message Hash: " + hash);
            System.out.println("Recipient: " + recipient);
            System.out.println("Message: " + messageText);
            System.out.println(msgObj.sentMessage(choice));
            System.out.println("===================================");

            if (choice == 1) {
                totalSent++;
            }
        }

        System.out.println("\nTotal messages sent: " + totalSent);
        System.out.println("QuickChat completed. Goodbye!");
        scanner.close();
    }
}