package fact.it.messageservice.repository;

import fact.it.messageservice.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findAll();
}
