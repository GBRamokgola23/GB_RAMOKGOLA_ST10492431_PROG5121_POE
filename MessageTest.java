package javapoe.gomolemo.ramokgola;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckRecipientCell_Valid() {
        Message msg = new Message("+27831234567", "Hi there");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Invalid_NoPlus() {
        Message msg = new Message("0831234567", "Hi there");
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCell_Invalid_TooLong() {
        Message msg = new Message("+27831234567890", "Hi");
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testCreateMessageHash_Format() {
        Message msg = new Message("+27831234567", "Hello World");
        String hash = msg.createMessageHash();
        assertTrue(hash.contains(":"));
        assertTrue(hash.contains("HELLO"));
        assertTrue(hash.contains("WORLD"));
    }

    @Test
    public void testMessageLength_Valid() {
        String shortMsg = "A".repeat(100);
        Message msg = new Message("+27831234567", shortMsg);
        assertTrue(msg.getMessageText().length() <= 250);
    }

    @Test
    public void testMessageID_Length() {
        Message msg = new Message("+27831234567", "Test");
        assertEquals(10, msg.getMessageID().length());
    }

    @Test
    public void testReturnTotalMessages() {
        int before = Message.returnTotalMessagess();
        assertTrue(before >= 0);
    }
}