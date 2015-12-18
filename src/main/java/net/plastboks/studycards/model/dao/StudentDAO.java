package net.plastboks.studycards.model.dao;

import net.plastboks.studycards.model.dao.DAO;
import net.plastboks.studycards.model.type.Student;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by alex on 12/18/15.
 */
public class StudentDAO implements DAO<Student>
{
    public void save(Student student)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        session.save(student);

        session.getTransaction().commit();
    }

    public List<Student> get()
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        List<Student> students = session.createCriteria(Student.class).list();

        session.close();

        return students;
    }

    public Student getById(int id)
    {
        return getById(id, false);
    }

    public Student getById(int id, boolean joins)
    {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        Student student = session.get(Student.class, id);

        if (joins) {
            Hibernate.initialize(student.getColloquia());
            Hibernate.initialize(student.getKeys());
        }

        session.close();

        return student;
    }
}
