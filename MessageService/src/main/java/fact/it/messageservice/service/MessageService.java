package fact.it.messageservice.service;

import fact.it.messageservice.dto.MessageRequest;
import fact.it.messageservice.dto.MessageResponse;
import fact.it.messageservice.model.Message;
import fact.it.messageservice.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<MessageResponse> getAllMessages() {
        List<Message> messages = messageRepository.findAll();

        return messages.stream().map(this::mapToMessageResponse).toList();
    }

    public void createMessage(MessageRequest messageRequest) {
        Message message = Message.builder()
                .header(messageRequest.getHeader())
                .message(messageRequest.getMessage())
                .deviceId(messageRequest.getDeviceId())
                .sentAt(LocalDateTime.now())
                .build();

        messageRepository.save(message);
    }

    private MessageResponse mapToMessageResponse(Message message) {
        return MessageResponse.builder()
                .id(message.getId())
                .deviceId(message.getDeviceId())
                .header(message.getHeader())
                .message(message.getMessage())
                .sentAt(message.getSentAt())
                .build();
    }
}
