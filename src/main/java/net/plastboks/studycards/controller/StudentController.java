package net.plastboks.studycards.controller;

import net.plastboks.studycards.model.dao.StudentDAO;
import net.plastboks.studycards.model.type.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alex on 12/17/15.
 */
@RestController
public class StudentController
{
    private final StudentDAO studentDAO = new StudentDAO();

    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable int id)
    {
        return studentDAO.getById(id, true);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudents()
    {
        return studentDAO.get();
    }
}
