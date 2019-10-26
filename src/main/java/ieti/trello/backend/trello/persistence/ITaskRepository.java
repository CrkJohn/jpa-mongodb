package ieti.trello.backend.trello.persistence;

import ieti.trello.backend.trello.entities.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;



public interface ITaskRepository extends MongoRepository<Task, String> {

    List<Task> findByResponsible(String responsible);

}
