package net.plastboks.studycards.service;

import net.plastboks.studycards.domain.User;
import net.plastboks.studycards.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/9/16.
 */
@Service
public class StudentService implements IService<User>
{
    @Resource
    private StudentRepository studentRepository;

    @Override
    public User save(User student)
    {
        return studentRepository.save(student);
    }

    @Override
    public User delete(int id)
    {
        User s = studentRepository.findOne(id);

        studentRepository.delete(s);

        return s;
    }

    @Override
    public List<User> findAll()
    {
        return studentRepository.findAll();
    }

    @Override
    public User findOne(int id)
    {
        return studentRepository.findOne(id);
    }
}
