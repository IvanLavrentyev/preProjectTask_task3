package utils.hibernate;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import utils.DBHelper;

public class SessionFactoryUtil {

    private static SessionFactory sessionFactory;

    static SessionFactory getSessionFactory(){
        if (sessionFactory == null) {
            Configuration configuration = DBHelper.getDBHelper().getConfiguration();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
            builder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = builder.build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

}
