package eci.cosw.data;

import eci.cosw.data.model.Customer;
import eci.cosw.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository  extends MongoRepository<User, String> {

}
