package net.plastboks.studycards;

import net.plastboks.studycards.dao.DAO;
import net.plastboks.studycards.dao.StudentDAO;
import net.plastboks.studycards.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by alex on 1/9/16.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
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

    @Bean
    public EmbeddedServletContainerFactory servletContainer()
    {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(8080);
        return factory;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(getDataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
        entityManagerFactoryBean.setPackagesToScan("net.plastboks.studycards.entity");

        entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "true");
        return properties;
    }


    @Bean
    public JpaTransactionManager transactionManager()
    {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
