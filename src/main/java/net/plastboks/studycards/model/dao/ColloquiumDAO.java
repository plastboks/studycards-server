package net.plastboks.studycards.model.dao;

import net.plastboks.studycards.model.dao.DAO;
import net.plastboks.studycards.model.type.Colloquium;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by alex on 12/18/15.
 */
public class ColloquiumDAO implements DAO<Colloquium>
{
    public void save(Colloquium colloquium)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        session.save(colloquium);

        session.getTransaction().commit();
    }

    public List<Colloquium> get()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        List<Colloquium> colloquia = session.createCriteria(Colloquium.class).list();

        session.close();

        return colloquia;
    }

    public Colloquium getById(int id)
    {
        return getById(id, false);
    }

    public Colloquium getById(int id, boolean joins)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        Colloquium colloquium = session.get(Colloquium.class, id);

        if (joins) {
            Hibernate.initialize(colloquium.getDecks());
            Hibernate.initialize(colloquium.getStudents());
        }

        session.close();

        return colloquium;
    }
}
