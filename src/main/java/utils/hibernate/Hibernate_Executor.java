package utils.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Hibernate_Executor {
    SessionFactory sessionFactory;

    public Hibernate_Executor() {
        this.sessionFactory = SessionFactoryUtil.getSessionFactory();
    }

    public  <T> T help(Hibernate_Helper <T> helper){
        T result;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        result = helper.help(session);
        transaction.commit();
        session.close();
        return result;
    }
}
