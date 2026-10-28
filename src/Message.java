package javapoe.gomolemo.ramokgola.st10492431;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Message {
    private String messageID;
    private String messageHash;
    private String recipient;
    private String messageText;
    private String sender;
    
    public static ArrayList<Message> sentMessages = new ArrayList<>();
    
    public Message(String messageID, String recipient, String messageText, String sender) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.messageText = messageText;
        this.sender = sender;
        this.messageHash = createMessageHash();
    }
    
    public Message() {}
    
    // Getters
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getSender() { return sender; }
    
    private String createMessageHash() {
        if (messageID == null || messageID.length() < 2) return "00:0:HASH";
        String firstTwo = messageID.substring(0, 2);
        String[] words = messageText != null ? messageText.split(" ") : new String[]{"A","B"};
        String firstWord = words.length > 0 ? words[0] : "A";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        return (firstTwo + ":" + sentMessages.size() + ":" + firstWord + lastWord).toUpperCase();
    }
    
    // PART 3 - Load test data from assignment
    public static void loadTestData() {
        sentMessages.clear();
        sentMessages.add(new Message("ID001", "+27834557896", "Did you get the cake?", "Rachel"));
        sentMessages.add(new Message("ID002", "+27838884567", "Where are you? You are late! I have asked you to be on time.", "Mike"));
        sentMessages.add(new Message("ID003", "+27834484567", "Yohoo, I am at your gate.", "Rachel"));
        sentMessages.add(new Message("ID004", "0838884567", "It is dinner time !", "Ruth"));
        sentMessages.add(new Message("ID005", "+27838884567", "Ok, I am leaving without you.", "Mike"));
        
        // Re-create hashes correctly
        for(int i=0; i<sentMessages.size(); i++) {
            Message m = sentMessages.get(i);
            String[] w = m.messageText.split(" ");
            String hash = m.messageID.substring(0,2) + ":" + i + ":" + w[0] + (w.length>1?w[w.length-1]:w[0]);
            m.messageHash = hash.toUpperCase();
        }
    }
    
    public static String getLongestMessage() {
        if(sentMessages.isEmpty()) return "";
        Message longest = sentMessages.get(0);
        for(Message m : sentMessages) {
            if(m.messageText.length() > longest.messageText.length()) longest = m;
        }
        return longest.messageText;
    }
    
    public static Message searchByMessageID(String id) {
        for(Message m : sentMessages) {
            if(m.messageID.equals(id)) return m;
        }
        return null;
    }
    
    public static ArrayList<Message> searchByRecipient(String recipient) {
        ArrayList<Message> result = new ArrayList<>();
        for(Message m : sentMessages) {
            if(m.recipient.contains(recipient) || recipient.contains(m.recipient)) result.add(m);
        }
        return result;
    }
    
    public static String deleteByHash(String hash) {
        for(int i=0; i<sentMessages.size(); i++) {
            if(sentMessages.get(i).messageHash.equalsIgnoreCase(hash)) {
                String removed = sentMessages.get(i).messageText;
                sentMessages.remove(i);
                return "Message \"" + removed + "\" successfully deleted.";
            }
        }
        return "Message hash not found.";
    }
    
    public static String displayReport() {
        if(sentMessages.isEmpty()) return "No messages sent.";
        StringBuilder sb = new StringBuilder();
        for(Message m : sentMessages) {
            sb.append("Hash: ").append(m.messageHash)
              .append("\nRecipient: ").append(m.recipient)
              .append("\nMessage: ").append(m.messageText)
              .append("\n---\n");
        }
        return sb.toString();
    }
    
    // For JSON - simple manual write
    public static void saveToJSON() {
        try(FileWriter w = new FileWriter("messages.json")) {
            w.write("[\n");
            for(int i=0;i<sentMessages.size();i++) {
                Message m = sentMessages.get(i);
                w.write("  {\"id\":\""+m.messageID+"\", \"hash\":\""+m.messageHash+"\", \"recipient\":\""+m.recipient+"\", \"message\":\""+m.messageText.replace("\"","'")+"\", \"sender\":\""+m.sender+"\"}");
                if(i<sentMessages.size()-1) w.write(",");
                w.write("\n");
            }
            w.write("]");
        } catch(IOException e) { e.printStackTrace(); }
    }
    
    // Old Part 2 methods (keep for compatibility)
    public boolean checkRecipientCell() {
        return recipient != null && recipient.length() <= 10 && recipient.startsWith("+");
    }
}