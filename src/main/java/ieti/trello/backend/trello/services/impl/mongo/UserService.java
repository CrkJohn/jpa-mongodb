package ieti.trello.backend.trello.services.impl.mongo;

import ieti.trello.backend.trello.entities.User;
import ieti.trello.backend.trello.services.IUserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("userServiceMongo")
public class UserService implements IUserService {
    @Override
    public List<User> getUsersList() {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void removeUser(String userId) {

    }
}
