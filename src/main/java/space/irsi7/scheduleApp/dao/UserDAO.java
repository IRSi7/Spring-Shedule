package space.irsi7.scheduleApp.dao;

import org.springframework.stereotype.Component;
import space.irsi7.scheduleApp.models.User;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserDAO {
    private final List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(1,"Tom"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }
}
