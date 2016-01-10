package net.plastboks.studycards.controller;

import net.plastboks.studycards.entity.Student;
import net.plastboks.studycards.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/9/16.
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController
{
    //@Autowired
    //private StudentService studentService;

    public Student get(@RequestParam(value = "id") int id)
    {
        //Student s = studentService.findById(id);

        return new Student("ping", "pong");
    }
}
