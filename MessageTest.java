package quickchat; 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageIDLength() {
        Message m = new Message("", "", "", "");
        String id = m.checkMessageID();
        assertEquals(10, id.length(), "Message ID must be 10 digits");
    }

    @Test
    public void testValidRecipient() {
        Message m = new Message("", "", "", "");
        assertTrue(m.checkRecipientCell("+27821234567"));
    }

    @Test
    public void testInvalidRecipient() {
        Message m = new Message("", "", "", "");
        assertFalse(m.checkRecipientCell("0821234567"));
    }

    @Test
    public void testMessageHash() {
        Message m = new Message("", "", "", "");
        String hash = m.createMessageHash("12XXXXXX34", 0, "Hi Mike");
        assertTrue(hash.contains("HI MIKE") || hash.contains("HIMIKE"));
    }
}