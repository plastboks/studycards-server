package net.plastboks.studycards.controller;

import net.plastboks.studycards.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alex on 1/9/16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController
{
    @Autowired
    private StudentService studentService;
}
