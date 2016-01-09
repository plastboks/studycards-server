package net.plastboks.studycards.service;

import net.plastboks.studycards.entity.Student;
import net.plastboks.studycards.repository.StudentRepository;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by alex on 1/9/16.
 */
@org.springframework.stereotype.Service
public class StudentService implements Service<Student>
{
    @Resource
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public Student get()
    {
        return new Student("ompa", "lompa");
    }
}
