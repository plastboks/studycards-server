package net.plastboks.studycards.service;

import net.plastboks.studycards.entity.Student;
import net.plastboks.studycards.repository.StudentRepository;
import org.springframework.stereotype.Service;

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
    public Student save(Student student)
    {
        return studentRepository.save(student);
    }

    @Override
    public Student delete(int id)
    {
        Student s = studentRepository.findOne(id);

        studentRepository.delete(s);

        return s;
    }

    @Override
    public List<Student> findAll()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student findOne(int id)
    {
        return studentRepository.findOne(id);
    }
}
