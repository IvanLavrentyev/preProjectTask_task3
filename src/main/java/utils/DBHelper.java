package utils;

import model.User;

import org.hibernate.cfg.Configuration;;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

    private static DBHelper dbHelper = null;
    private Connection connection = null;
    private Configuration configuration = null;

    private DBHelper() {}

    public static DBHelper getDBHelper(){
        if (dbHelper == null){
            dbHelper = new DBHelper();
        }
        return dbHelper;
    }

    public Configuration getConfiguration(){
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/task3");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    public Connection getConnection() {
        try{
            if (connection == null){
                Driver driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
                DriverManager.registerDriver(driver);
                StringBuilder url = new StringBuilder();
                url.
                        append("jdbc:mysql://").
                        append("localhost:").
                        append("3306/").
                        append("task3?").
                        append("user=root&").
                        append("password=root");
                connection = (Connection) DriverManager.getConnection(url.toString());
            }
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

