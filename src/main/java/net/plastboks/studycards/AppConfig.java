package net.plastboks.studycards;

import net.plastboks.studycards.dao.DAO;
import net.plastboks.studycards.dao.StudentDAO;
import net.plastboks.studycards.entity.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by alex on 1/9/16.
 */
@Configuration
@EnableTransactionManagement
public class AppConfig
{
    @Bean
    public DAO<Student> studentDAO()
    {
        return new StudentDAO();
    }

    @Bean
    public HibernateTemplate hibernateTemplate()
    {
        return new HibernateTemplate(sessionFactory());
    }

    @Bean
    public SessionFactory sessionFactory()
    {
        return new LocalSessionFactoryBuilder(getDataSource())
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Colloquium.class)
                .addAnnotatedClass(ApiKey.class)
                .addAnnotatedClass(Deck.class)
                .addAnnotatedClass(Play.class)
                .addAnnotatedClass(Question.class)
                .buildSessionFactory();
    }

    @Bean
    public DataSource getDataSource()
    {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/studycards_test");
        dataSource.setUsername("postgres");
        dataSource.setPassword("abcd");
        return dataSource;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager()
    {
        return new HibernateTransactionManager(sessionFactory());
    }

}
