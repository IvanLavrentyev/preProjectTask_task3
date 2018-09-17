package userDao;

import model.User;
import utils.DBHelper;
import utils.jdbc.JDBC_Executor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBC_Impl implements UserDao {

    private JDBC_Executor jdbc_executor;

    public UserDaoJDBC_Impl() {
        this.jdbc_executor = new JDBC_Executor();
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = jdbc_executor.execQuery(String.format("select * from task3.users"), result ->{
            List <User> userList = new ArrayList<>();
            try{
                while (result.next()){
                    userList.add( new User(result.getLong("id"),
                            result.getString("name"),
                            result.getString("login"),
                            result.getString("password")));

                }
            }catch (SQLException e){
               //todo logging
            }
            return userList;
        });
        return users;
    }

    @Override
    public User getUserById(long id) {
        User user = jdbc_executor.execQuery(String.format("select * from task3.users where id='%s'",id), result ->{
            User u = null;
            try {
                result.next();
                long userId = result.getLong("id");
                String userName = result.getString("name");
                String userLogin = result.getString("login");
                String userPass = result.getString("password");
                u = new User(userId, userName, userLogin, userPass);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return u;
        });
        return user;
    }

    @Override
    public void deleteUserById(long id) {
        jdbc_executor.execUpdate(String.format("delete from task3.users where id='%s'",id));
    }

    @Override
    public void updateUser(long id, String name, String login, String password) {
        jdbc_executor.execUpdate(String.format("update task3.users set name='%s', login='%s', password='%s' where id='%s'",
                name, login, password, id));
    }

    @Override
    public void addUser(String name, String login, String password) {
        jdbc_executor.execUpdate(String.format("insert into task3.users (name, login, password) values ('%s', '%s', '%s')",
                name,login,password));
    }
}
