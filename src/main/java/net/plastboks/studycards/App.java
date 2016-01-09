package net.plastboks.studycards;

import net.plastboks.studycards.dao.DAO;
import net.plastboks.studycards.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by alex on 12/16/15.
 */
@SpringBootApplication
public class App
{
    public static void main(String ... args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        SpringApplication.run(App.class, args);
    }
}
