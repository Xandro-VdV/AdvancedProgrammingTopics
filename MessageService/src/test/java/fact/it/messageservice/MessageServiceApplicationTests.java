package fact.it.messageservice;

import fact.it.messageservice.dto.MessageRequest;
import fact.it.messageservice.dto.MessageResponse;
import fact.it.messageservice.model.Message;
import fact.it.messageservice.repository.MessageRepository;
import fact.it.messageservice.service.MessageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageServiceApplicationTests {

    @InjectMocks
    private MessageService messageService;

    @Mock
    private MessageRepository messageRepository;

    @Test
    public void testGetAllMessages() {
        // Arrange
        Message message1 = Message.builder()
                .id("1")
                .deviceId(101)
                .header("Test Header")
                .message("Test Message")
                .sentAt(LocalDateTime.of(2023, 12, 19, 10, 0))
                .build();

        when(messageRepository.findAll()).thenReturn(List.of(message1));

        // Act
        List<MessageResponse> messages = messageService.getAllMessages();

        // Assert
        assertEquals(1, messages.size());
        assertEquals("1", messages.get(0).getId());
        assertEquals(101, messages.get(0).getDeviceId());
        assertEquals("Test Header", messages.get(0).getHeader());
        assertEquals("Test Message", messages.get(0).getMessage());
        assertEquals(LocalDateTime.of(2023, 12, 19, 10, 0), messages.get(0).getSentAt());

        verify(messageRepository, times(1)).findAll();
    }

    @Test
    public void testCreateMessage() {
        // Arrange
        MessageRequest messageRequest = MessageRequest.builder()
                .deviceId(102)
                .header("New Header")
                .message("New Message")
                .sentAt(LocalDateTime.of(2023, 12, 19, 11, 0))
                .build();

        Message message = Message.builder()
                .id("2")
                .deviceId(102)
                .header("New Header")
                .message("New Message")
                .sentAt(LocalDateTime.of(2023, 12, 19, 11, 0))
                .build();

        when(messageRepository.save(any(Message.class))).thenReturn(message);

        // Act
        messageService.createMessage(messageRequest);

        // Assert
        verify(messageRepository, times(1)).save(any(Message.class));
    }
}
