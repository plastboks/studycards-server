package net.plastboks.studycards.model.dao;

import net.plastboks.studycards.model.dao.DAO;
import net.plastboks.studycards.model.type.Question;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by alex on 12/18/15.
 */
public class QuestionDAO implements DAO<Question>
{
    public void save(Question question)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        session.save(question);

        session.getTransaction().commit();
    }

    public List<Question> get()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        List<Question> questions = session.createCriteria(Question.class).list();

        session.close();

        return questions;
    }

    public Question getById(int id)
    {
        return getById(id, false);
    }

    public Question getById(int id, boolean joins)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        Question question = session.get(Question.class, id);

        if (joins) {
            //Hibernate.initialize(question...);
        }

        session.close();

        return question;
    }
}
