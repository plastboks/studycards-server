package net.plastboks.studycards.model.dao;

import net.plastboks.studycards.model.dao.DAO;
import net.plastboks.studycards.model.type.Deck;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by alex on 12/18/15.
 */
public class DeckDAO implements DAO<Deck>
{
    public void save(Deck deck)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        session.save(deck);

        session.getTransaction().commit();
    }

    public List<Deck> get()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        List<Deck> decks = session.createCriteria(Deck.class).list();

        session.close();

        return decks;
    }

    public Deck getById(int id)
    {
        return getById(id, false);
    }

    public Deck getById(int id, boolean joins)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        Deck deck = session.get(Deck.class, id);

        if (joins) {
            Hibernate.initialize(deck.getQuestions());
            Hibernate.initialize(deck.getColloquia());
        }

        session.close();

        return deck;
    }
}
