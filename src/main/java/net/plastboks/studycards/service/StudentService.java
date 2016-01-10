package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Student;
import net.plastboks.studycards.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/9/16.
 */
@Service
public class StudentService implements IService<Student>
{
    @Resource
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public Student create(Student student)
    {
        Student s = student;
        return studentRepository.save(s);
    }

    @Override
    @Transactional
    public Student delete(int id) throws NotFoundException
    {
        Student s = studentRepository.findOne(id);

        if (s == null) throw new NotFoundException("Student not found");

        studentRepository.delete(s);

        return s;
    }

    @Override
    @Transactional
    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student update(Student student) throws NotFoundException
    {
        Student s = studentRepository.findOne(student.getId());

        if (s == null) throw new NotFoundException("Student not found");

        // UPDATE 's' HERE!

        return s;
    }

    @Override
    @Transactional
    public Student findById(int id)
    {
        return studentRepository.findOne(id);
    }
}
