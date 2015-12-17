package net.plastboks.studycards;

import net.plastboks.studycards.model.ApiKey;
import net.plastboks.studycards.model.User;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by alex on 12/17/15.
 */
public class DB_Test
{
    private Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    @Test
    public void createUser()
    {
        session.getTransaction().begin();

        User user = new User("john@example.com", "ping");

        Set<ApiKey> keys = new LinkedHashSet<>();
        keys.add(new ApiKey("key1"));
        keys.add(new ApiKey("key2"));
        keys.add(new ApiKey("key3"));

        user.setKeys(keys);
        session.save(user);
        session.close();


    }

}
