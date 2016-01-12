package net.plastboks.studycards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by alex on 12/16/15.
 */
@SpringBootApplication
public class App
{
    public static void main(String ... args)
    {
        //AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //ctx.register(AppConfig.class);
        //ctx.refresh();

        SpringApplication.run(App.class, args);
    }
}
