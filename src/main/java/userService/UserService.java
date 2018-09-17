package userService;

import model.User;
import userDao.UserDao;
import userDao.UserDaoFactory;

import java.util.List;

public class UserService implements UserDao {

    private UserDao userServiceImpl;

    public UserService() {
        this.userServiceImpl = UserDaoFactory.getUserDaoImpl();
    }

    @Override
    public List<User> getAllUsers() {
        return userServiceImpl.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userServiceImpl.getUserById(id);
    }

    @Override
    public void deleteUserById(long id) {
        userServiceImpl.deleteUserById(id);
    }

    @Override
    public void updateUser(long id, String name, String login, String password) {
        userServiceImpl.updateUser(id,name,login,password);
    }

    @Override
    public void addUser(String name, String login, String password) {
        userServiceImpl.addUser(name,login,password);
    }
}
