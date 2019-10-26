package ieti.trello.backend.trello.persistence;

import ieti.trello.backend.trello.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository  extends MongoRepository<User, String> {

}
