package net.plastboks.studycards.controller;

import net.plastboks.studycards.model.StudentDAO;
import net.plastboks.studycards.model.type.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alex on 12/17/15.
 */
@RestController
public class StudentController
{
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String student()
    {
        return new String("ping");
    }
}
