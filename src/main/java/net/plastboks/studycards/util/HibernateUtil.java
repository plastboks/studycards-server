package net.plastboks.studycards.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by alex on 12/17/15.
 */
public class HibernateUtil
{
    private static final String cfgPath = "/xml/hibernate.cfg.xml";
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory()
    {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure(cfgPath).build();
        try {
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            StandardServiceRegistryBuilder.destroy(registry);
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
