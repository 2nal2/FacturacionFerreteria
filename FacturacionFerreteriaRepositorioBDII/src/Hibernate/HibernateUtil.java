package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Ing. Donaldo
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static void Configurar() throws Throwable {
        Configuration conf = new Configuration().configure();

        conf.setProperty("hibernate.connection.username", Conexion.getUser());
        conf.setProperty("hibernate.connection.password", Conexion.getPass());

        sessionFactory = conf.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
