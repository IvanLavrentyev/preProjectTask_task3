package userDao;

import model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    User getUserById(long id);
    void deleteUserById(long id);

    void updateUser(long id, String name, String login, String password);
    void addUser(String name, String login, String password);

}
