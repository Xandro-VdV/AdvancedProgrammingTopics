package fact.it.messageservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(value = "message")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Message {
    private String id;
    private Integer deviceId;
    private String header;
    private String message;
    private LocalDateTime sentAt;
}
