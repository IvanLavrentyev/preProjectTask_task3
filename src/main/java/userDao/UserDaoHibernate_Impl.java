package userDao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionFactoryImpl;
import utils.hibernate.Hibernate_Executor;
import utils.hibernate.SessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernate_Impl implements UserDao {

    private Hibernate_Executor hibernate_executor;

    public UserDaoHibernate_Impl() {
        this.hibernate_executor = new Hibernate_Executor();
    }

    @Override
    public List<User> getAllUsers() {
        return hibernate_executor.help(result ->{
            String sql = "From " + User.class.getSimpleName();
            List<User> userList = new ArrayList<User>(result.createQuery(sql).list());
            return userList;
        });
    }

    @Override
    public User getUserById(long id) {
        return hibernate_executor.help(result -> result.get(User.class, id));
    }

    @Override
    public void deleteUserById(long id) {
        hibernate_executor.help(result -> {
            User user = result.get(User.class, id);
            result.delete(user);
            return null;
        });
    }

    @Override
    public void updateUser(long id, String name, String login, String password) {
        hibernate_executor.help(result ->{
            User user = result.get(User.class, id);
            user.setName(name);
            user.setLogin(login);
            user.setPassword(password);
            result.update(user);
            return null;
        });
    }

    @Override
    public void addUser(String name, String login, String password) {
        hibernate_executor.help(result -> {
            result.save(new User(name, login, password));
            return null;
        });
    }
}
