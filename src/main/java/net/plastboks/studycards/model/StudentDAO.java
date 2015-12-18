package net.plastboks.studycards.model;

import net.plastboks.studycards.model.type.Student;
import net.plastboks.studycards.util.HibernateUtil;
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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        session.getTransaction().begin();

        Student student = (Student)session.get(Student.class, id);

        session.close();

        return student;
    }
}
