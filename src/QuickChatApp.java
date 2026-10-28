
package javapoe.gomolemo.ramokgola.st10492431;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class QuickChatApp {
    public static void main(String[] args) {
        // test data for Part 3
        Message.loadTestData();
        Message.saveToJSON(); // messages.json
        
        Login login = new Login();
        Registration reg = new Registration();
        
        // Part 1
        String username = JOptionPane.showInputDialog("Enter username to login:");
        String password = JOptionPane.showInputDialog("Enter password:");
        
        String option;
        do {
            option = JOptionPane.showInputDialog(null,
                    "QuickChat Part 3 - Choose option:\n" +
                    "1) Display all senders and recipients\n" +
                    "2) Display longest sent message\n" +
                    "3) Search for message ID\n" +
                    "4) Search messages by recipient\n" +
                    "5) Delete message by hash\n" +
                    "6) Display full report\n" +
                    "7) Quit\n" +
                    "Enter number:");
            
            if(option == null) break;
            
            switch(option) {
                case "1":
                    StringBuilder sr = new StringBuilder("Sent Messages:\n");
                    for(Message m : Message.sentMessages) {
                        sr.append("Sender: ").append(m.getSender()).append(" -> Recipient: ").append(m.getRecipient()).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sr.toString());
                    break;
                    
                case "2":
                    String longest = Message.getLongestMessage();
                    JOptionPane.showMessageDialog(null, "Longest message: \n" + longest);
                    break;
                    
                case "3":
                    String id = JOptionPane.showInputDialog("Enter Message ID to search (e.g. ID002):");
                    Message found = Message.searchByMessageID(id);
                    if(found != null) {
                        JOptionPane.showMessageDialog(null, "Found:\nRecipient: "+found.getRecipient()+"\nMessage: "+found.getMessageText());
                    } else {
                        JOptionPane.showMessageDialog(null, "Message ID not found");
                    }
                    break;
                    
                case "4":
                    String rec = JOptionPane.showInputDialog("Enter recipient number to search:");
                    ArrayList<Message> list = Message.searchByRecipient(rec);
                    if(list.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No messages for recipient");
                    } else {
                        StringBuilder b = new StringBuilder();
                        for(Message m : list) b.append(m.getMessageText()).append("\n---\n");
                        JOptionPane.showMessageDialog(null, "Messages for "+rec+":\n"+b.toString());
                    }
                    break;
                    
                case "5":
                    String hash = JOptionPane.showInputDialog("Enter hash to delete (e.g. ID002:1:WhereTime.):");
                    String result = Message.deleteByHash(hash);
                    Message.saveToJSON();
                    JOptionPane.showMessageDialog(null, result);
                    break;
                    
                case "6":
                    JOptionPane.showMessageDialog(null, Message.displayReport());
                    break;
                    
                case "7":
                    JOptionPane.showMessageDialog(null, "Total messages: " + Message.sentMessages.size() + "\nQuitting - messages.json saved!");
                    break;
            }
        } while(!option.equals("7"));
    }
}