package net.plastboks.studycards;

import net.plastboks.studycards.model.ApiKey;
import net.plastboks.studycards.model.User;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by alex on 12/17/15.
 */
public class DB_Test
{
    @Test
    public void mainTest()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();
        session.save(new User("user1@example.com"));
        session.save(new ApiKey());
        session.close();
    }
}
