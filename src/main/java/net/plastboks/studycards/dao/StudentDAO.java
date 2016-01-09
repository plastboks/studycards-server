package net.plastboks.studycards.dao;

import net.plastboks.studycards.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;

/**
 * Created by alex on 12/18/15.
 */
@Transactional
public class StudentDAO implements DAO<Student>
{
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void save(Student student)
    {
        hibernateTemplate.save(student);
    }

}
