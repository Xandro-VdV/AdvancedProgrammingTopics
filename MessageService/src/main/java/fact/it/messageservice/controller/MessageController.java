package fact.it.messageservice.controller;

import fact.it.messageservice.dto.MessageRequest;
import fact.it.messageservice.dto.MessageResponse;
import fact.it.messageservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MessageResponse> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createMessage(@RequestBody MessageRequest messageRequest) {
        messageService.createMessage(messageRequest);
    }
}
