package fact.it.messageservice;

import fact.it.messageservice.model.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {
    private Message message;

    @BeforeEach
    void setUp() {
        message = new Message();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(message);
        assertNull(message.getId());
        assertNull(message.getDeviceId());
        assertNull(message.getHeader());
        assertNull(message.getMessage());
        assertNull(message.getSentAt());
    }

    @Test
    void testAllArgsConstructor() {
        LocalDateTime sentTime = LocalDateTime.now();
        message = new Message("1", 123, "Test Header", "Test Message", sentTime);

        assertEquals("1", message.getId());
        assertEquals(123, message.getDeviceId());
        assertEquals("Test Header", message.getHeader());
        assertEquals("Test Message", message.getMessage());
        assertEquals(sentTime, message.getSentAt());
    }

    @Test
    void testingSettersAndGetters() {
        message.setId("2");
        assertEquals("2", message.getId());
        message.setDeviceId(456);
        assertEquals(456, message.getDeviceId());
        message.setHeader("New Header");
        assertEquals("New Header", message.getHeader());
        message.setMessage("New Message");
        assertEquals("New Message", message.getMessage());
        LocalDateTime newSentTime = LocalDateTime.now();
        message.setSentAt(newSentTime);
        assertEquals(newSentTime, message.getSentAt());
    }
}
