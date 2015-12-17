package net.plastboks.studycards.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by alex on 12/17/15.
 */
public class HibernateUtil
{
    private static final String cfgPath = "/xml/hibernate.cfg.xml";
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        try {
            SessionFactory sessionFactory = new Configuration()
                    .configure(cfgPath).buildSessionFactory();
            return sessionFactory;
        } catch (Throwable ex) {
            System.out.println("=> Could not load configuration file");
            System.out.println("=> Working Directory = " + System.getProperty("user.dir"));
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

    public static void shutdown()
    {
        getSessionFactory().close();
    }
}
