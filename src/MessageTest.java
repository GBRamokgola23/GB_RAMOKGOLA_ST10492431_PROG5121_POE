package javapoe.gomolemo.ramokgola.st10492431;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class MessageTest {

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        Message.loadTestData();
        assertEquals(5, Message.sentMessages.size());
        assertEquals("Did you get the cake?", Message.sentMessages.get(0).getMessageText());
        System.out.println("PASS - Array correctly populated with 5 messages");
    }

    @Test
    public void testDisplayReport() {
        Message.loadTestData();
        String report = Message.displayReport();
        assertTrue(report.contains("Did you get the cake?"));
        assertTrue(report.contains("+27834557896"));
        assertNotNull(report);
        System.out.println("PASS - Display Report:\n" + report);
    }

    @Test
    public void testLongestMessage() {
        Message.loadTestData();
        String longest = Message.getLongestMessage();
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest);
        System.out.println("PASS - Longest: " + longest);
    }

    @Test
    public void testSearchByRecipient() {
        Message.loadTestData();
        ArrayList<Message> results = Message.searchByRecipient("+27838884567");
        assertEquals(2, results.size()); // Mike sent 2
        System.out.println("PASS - Found " + results.size() + " messages for recipient");
    }

    @Test
    public void testSearchForMessageID() {
        Message.loadTestData();
        Message m = Message.searchByMessageID("ID002");
        assertNotNull(m);
        assertEquals("+27838884567", m.getRecipient());
        assertEquals("Where are you? You are late! I have asked you to be on time.", m.getMessageText());
        System.out.println("PASS - Search by ID found: " + m.getMessageText());
    }

    @Test
    public void testDeleteByHash() {
        Message.loadTestData();
        int before = Message.sentMessages.size();
        String hashToDelete = Message.sentMessages.get(0).getMessageHash();
        String result = Message.deleteByHash(hashToDelete);
        assertEquals(before - 1, Message.sentMessages.size());
        assertTrue(result.contains("successfully deleted"));
        System.out.println("PASS - " + result);
    }
}