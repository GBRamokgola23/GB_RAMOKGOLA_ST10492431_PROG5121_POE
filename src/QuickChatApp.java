package javapoe.gomolemo.ramokgola;

import javax.swing.JOptionPane;

public class QuickChatApp {
    public static void main(String[] args) {
        Registration reg = new Registration();
        Login loginObj = new Login();

        // --- PART 1: Registration (uses your existing Registration.java) ---
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat - Please Register");

        String username = JOptionPane.showInputDialog("Enter Username (must contain _ and <=5 chars):");
        String password = JOptionPane.showInputDialog("Enter Password (8 chars, capital, number, special):");
        String cell = JOptionPane.showInputDialog("Enter Cellphone (+27...):");

        String regResult = reg.registerUser(username, password, cell);
        JOptionPane.showMessageDialog(null, regResult);

        // If registration failed, stop
        if (!regResult.toLowerCase().contains("successfully")) {
            JOptionPane.showMessageDialog(null, "Registration failed. Please restart the app.");
            return;
        }

        // --- PART 1: Login ---
        String loginUsername = JOptionPane.showInputDialog("LOGIN - Enter Username:");
        String loginPassword = JOptionPane.showInputDialog("LOGIN - Enter Password:");

        boolean loggedIn = loginObj.loginUser(loginUsername, loginPassword);
        JOptionPane.showMessageDialog(null, loginObj.returnLoginStatus(loggedIn));

        if (!loggedIn) {
            return; // Stop if login fails
        }

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        // --- PART 2: QuickChat Menu Loop ---
        while (true) {
            String menu = JOptionPane.showInputDialog(null,
                "QuickChat Menu:\n1) Send Messages\n2) Show recently sent messages\n3) Quit",
                "QuickChat",
                JOptionPane.QUESTION_MESSAGE);

            if (menu == null || menu.equals("3")) {
                JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessagess() + "\nGoodbye!");
                System.exit(0);
            }

            if (menu.equals("1")) {
                String numStr = JOptionPane.showInputDialog("How many messages do you want to send?");
                int num = Integer.parseInt(numStr);

                for (int i = 0; i < num; i++) {
                    String recipient = JOptionPane.showInputDialog("Enter recipient number (with international code e.g. +27830000000):");
                    String text = JOptionPane.showInputDialog("Enter your message (max 250 chars):");

                    Message msg = new Message(recipient, text);
                    String result = msg.SentMessage();
                    JOptionPane.showMessageDialog(null, result);

                    if (result.equals("Message successfully sent.")) {
                        JOptionPane.showMessageDialog(null,
                            "--- MESSAGE DETAILS ---\n" +
                            "MessageID: " + msg.getMessageID() + "\n" +
                            "MessageHash: " + msg.getMessageHash() + "\n" +
                            "Recipient: " + msg.getRecipient() + "\n" +
                            "Message: " + msg.getMessageText()
                        );
                    }
                }
            } else if (menu.equals("2")) {
                String allMessages = Message.printMessages();
                if (allMessages.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No messages sent yet - Coming Soon feature shows empty.");
                } else {
                    JOptionPane.showMessageDialog(null, "--- SENT MESSAGES ---\n\n" + allMessages);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2 or 3.");
            }
        }
    }
}