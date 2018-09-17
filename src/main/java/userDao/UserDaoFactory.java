package userDao;

import java.io.*;
import java.util.Properties;

public class UserDaoFactory {
    private static Properties properties;
    public static String typeOfConnection;


    public static UserDao getUserDaoImpl(){
        UserDao userDao;

        properties = getProperties();

        if (properties.getProperty("daoRealization").equalsIgnoreCase("hibernate")) {
            userDao = new UserDaoHibernate_Impl();
            typeOfConnection = "hibernate";
        }else {
            userDao = new UserDaoJDBC_Impl();
            typeOfConnection = "jdbc";
        }

        return userDao;
//        return (properties.getProperty("daoRealization").equals("hibernate"))
//                ? new UserDaoHibernate_Impl() : new UserDaoJDBC_Impl();
    }

    private static Properties getProperties(){
        properties = new Properties();
        try{
            InputStream inputStream = new FileInputStream("C:\\WEB\\preProjectTask_task3\\src\\main\\resources\\daoImpl.properties");
            properties.load(inputStream);
        }catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return properties;
    }

}
