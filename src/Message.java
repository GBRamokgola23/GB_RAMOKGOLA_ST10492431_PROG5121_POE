package quickchat; 

import java.util.Random;

public class Message {
    public String messageID;
    public String recipient;
    public String messageText;
    public String messageHash;
    public static int totalMessages = 0;
    public static String allMessages = "";

    public Message(String id, String recipient, String text, String hash) {
        this.messageID = id;
        this.recipient = recipient;
        this.messageText = text;
        this.messageHash = hash;
    }

    // Generate 10 digit ID
    public String checkMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    // Check recipient - must start with +27 and <=13 chars
    public boolean checkRecipientCell(String cell) {
        if (cell.length() <= 13 && cell.startsWith("+")) {
            return true;
        } else {
            return false;
        }
    }

    // Create hash
    public String createMessageHash(String id, int count, String message) {
        String[] words = message.split(" ");
        String first = words[0];
        String last = words[words.length - 1];
        String hash = id.substring(0,2) + ":" + count + ":" + first + last;
        return hash.toUpperCase();
    }

    // Send, store, disregard
    public String sentMessage(int choice) {
        if (choice == 1) {
            totalMessages++;
            allMessages += "\n" + messageHash + "\n" + recipient + "\n" + messageText;
            return "Message successfully sent.";
        } else if (choice == 2) {
            return "Press 0 to delete message.";
        } else if (choice == 3) {
            return "Message successfully stored.";
        } else {
            return "Invalid choice.";
        }
    }

    public static String printMessages() {
        return allMessages;
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }
}