package eci.cosw.data;

import eci.cosw.data.model.Customer;
import eci.cosw.data.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ITodoRepository extends MongoRepository<Todo, String> {

    List<Todo> findByResponsible(String responsible);

}
