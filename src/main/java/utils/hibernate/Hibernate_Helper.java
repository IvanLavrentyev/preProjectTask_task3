package utils.hibernate;

import org.hibernate.Session;

@FunctionalInterface
public interface Hibernate_Helper <T> {
    T help(Session session);
}
