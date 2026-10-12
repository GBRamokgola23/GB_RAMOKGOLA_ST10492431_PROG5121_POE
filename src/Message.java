package javapoe.gomolemo.ramokgola;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

public class Message {
    private String messageID;
    private String recipient;
    private String messageText;
    private String messageHash;
    private static List<Message> sentMessages = new ArrayList<>();
    private static int totalMessagesSent = 0;

    public Message(String recipient, String messageText) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageHash = createMessageHash();
    }

    public String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    public boolean checkRecipientCell() {
        return recipient!= null && recipient.startsWith("+") && recipient.length() <= 13 && recipient.matches("\\+\\d+");
    }

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) {
            return messageID.substring(0, 2) + ":0:NONE";
        }
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();
        return messageID.substring(0, 2) + ":" + totalMessagesSent + ":" + firstWord + lastWord;
    }

    public String SentMessage() {
        if (!checkRecipientCell()) {
            return "Cell phone number is incorrectly formatted or does not contain an international code.";
        }
        if (messageText.length() > 250) {
            return "Please enter a message of less than 250 characters. Excess: " + (messageText.length() - 250);
        }
        String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
        int choice = JOptionPane.showOptionDialog(null, "Choose what to do with the message:", "QuickChat",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            sentMessages.add(this);
            totalMessagesSent++;
            this.messageHash = createMessageHash();
            return "Message successfully sent.";
        } else if (choice == 2) {
            storeMessage();
            return "Message successfully stored.";
        } else {
            return "Press 0 to delete message.";
        }
    }

    public void storeMessage() {
        JSONObject obj = new JSONObject();
        obj.put("messageID", messageID);
        obj.put("recipient", recipient);
        obj.put("message", messageText);
        obj.put("hash", messageHash);

        JSONArray arr = new JSONArray();
        arr.put(obj);

        try (FileWriter file = new FileWriter("storedMessages.json", true)) {
            file.write(arr.toString(4));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage());
        }
    }

    public static String printMessages() {
        StringBuilder sb = new StringBuilder();
        for (Message m : sentMessages) {
            sb.append("MessageID: ").append(m.messageID).append("\n");
            sb.append("MessageHash: ").append(m.messageHash).append("\n");
            sb.append("Recipient: ").append(m.recipient).append("\n");
            sb.append("Message: ").append(m.messageText).append("\n\n");
        }
        return sb.toString();
    }

    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
}