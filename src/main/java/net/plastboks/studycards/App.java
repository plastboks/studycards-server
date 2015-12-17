package net.plastboks.studycards;

import net.plastboks.studycards.model.User;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by alex on 12/16/15.
 */
@SpringBootApplication
public class App
{
    public static void main(String ... args)
    {
        SpringApplication.run(App.class, args);
    }
}
