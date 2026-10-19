package javapoe.gomolemo.ramokgola.st10492431;

import java.util.Random;

public class Message {
    
    public String checkMessageID() {
        Random rand = new Random();
        long num = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(num).substring(0, 10);
    }
    
    public boolean checkRecipientCell(String recipient) {
        return recipient.startsWith("+") && recipient.length() <= 13 && recipient.length() >= 10;
    }
    
    public String createMessageHash(String id, int count, String message) {
        String[] words = message.trim().split(" ");
        String first = words[0];
        String last = words[words.length - 1];
        return id.substring(0,2) + ":" + count + ":" + first.toUpperCase() + last.toUpperCase();
    }
    
    public String sentMessage(int option) {
        if(option == 1) return "Message successfully sent.";
        if(option == 2) return "Press 0 to delete message.";
        return "Message successfully stored.";
    }
}