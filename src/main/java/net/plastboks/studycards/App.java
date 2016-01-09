package net.plastboks.studycards;

import net.plastboks.studycards.dao.DAO;
import net.plastboks.studycards.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by alex on 12/16/15.
 */
//@SpringBootApplication
public class App
{
    public static void main(String ... args)
    {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();


        DAO<Student> studentDAO = ctx.getBean(DAO.class);

        studentDAO.save(new Student("ompa", "lompa"));

        //SpringApplication.run(App.class, args);

    }
}
