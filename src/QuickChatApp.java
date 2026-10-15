package quickchat; 

import javax.swing.JOptionPane;

public class QuickChatApp {
    public static void main(String[] args) {

        // Part 1 - Registration and Login
        Registration reg = new Registration();
        Login login = new Login();

        String username = JOptionPane.showInputDialog("Enter username (must have _ and max 5 chars):");
        String password = JOptionPane.showInputDialog("Enter password (8 chars, Capital, number, special):");
        String cell = JOptionPane.showInputDialog("Enter cell with +27:");

        String regResult = reg.registerUser(username, password, cell);
        JOptionPane.showMessageDialog(null, regResult);

        // If registration failed, stop
        if (!regResult.contains("successfully")) {
            return;
        }

        String loginUsername = JOptionPane.showInputDialog("LOGIN - Enter username:");
        String loginPassword = JOptionPane.showInputDialog("LOGIN - Enter password:");

        boolean logged = login.loginUser(loginUsername, loginPassword);
        String status = login.returnLoginStatus(logged);
        JOptionPane.showMessageDialog(null, status);

        if (!logged) {
            return;
        }

        // Part 2 - QuickChat
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat!");

        int totalToSend = Integer.parseInt(JOptionPane.showInputDialog("How many messages you want to send?"));

        for (int i = 1; i <= totalToSend; i++) {
            Message msgObj = new Message("", "", "", "");

            String id = msgObj.checkMessageID();
            String recipient = JOptionPane.showInputDialog("Message " + i + " - Enter recipient (+27... max 13):");

            if (!msgObj.checkRecipientCell(recipient)) {
                JOptionPane.showMessageDialog(null, "Cell phone number is incorrectly formatted or does not contain international code.");
                i--; // try again
                continue;
            }

            String text = JOptionPane.showInputDialog("Enter message (max 250 chars):");
            if (text.length() > 250) {
                JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by " + (text.length() - 250) + ", please reduce size.");
                i--;
                continue;
            }

            String hash = msgObj.createMessageHash(id, i, text);
            Message finalMsg = new Message(id, recipient, text, hash);

            String choiceStr = JOptionPane.showInputDialog("Choose:\n1) Send Message\n2) Disregard\n3) Store Message");
            int choice = Integer.parseInt(choiceStr);

            String result = finalMsg.sentMessage(choice);
            JOptionPane.showMessageDialog(null, result + "\nID: " + id + "\nHash: " + hash);
        }

        JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages() + "\n" + Message.printMessages());
    }
}