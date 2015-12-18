package net.plastboks.studycards.model;

import net.plastboks.studycards.model.type.Student;
import net.plastboks.studycards.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

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
