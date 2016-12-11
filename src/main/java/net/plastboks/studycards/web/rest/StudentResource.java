package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.Student;
import net.plastboks.studycards.service.StudentService;
import net.plastboks.studycards.web.rest.util.HeaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 1/9/16.
 */
@RestController
@RequestMapping(value = "/api")
public class StudentResource
{
    @Autowired
    private StudentService studentService;

    /**
     * POST /students: Create a new student
     *
     * @param student the student to save
     * @return the ResponseEntity with status 201 (Created) and with body the new student, or with status 400 (Bad Request) if the student has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/students",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
            throws URISyntaxException
    {
        if (student.getId() != null) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert("student", "idexists", "A new student cannot already have an ID"))
                    .body(null);
        }

        Student result = studentService.save(student);
        return ResponseEntity.created(new URI("/api/students" + student.getId()))
                .headers(HeaderUtil.createEntityCreationAlert("student", student.getId().toString()))
                .body(result);
    }


    /**
     * PUT  /students : Updates an existing student.
     *
     * @param student the student to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated student,
     * or with status 400 (Bad Request) if the student is not valid,
     * or with status 500 (Internal Server Error) if the student couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/students",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws URISyntaxException {
        if (student.getId() == null) {
            return createStudent(student);
        }
        Student result = studentService.save(student);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("student", student.getId().toString()))
                .body(result);
    }

    /**
     * GET /students
     *
     * @return the ResponseEntity with status 200 (OK) and the list of students in body
     */
    @RequestMapping(value = "/students",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> getAllStudents()
    {
        return studentService.findAll();
    }

    /**
     * GET /students/:id get the student with id
     *
     * @param id the id of the student to retrieve
     * @return the ResponseEntity with status 200 (OK) and the student in body, or 404 (Not found)
     */
    @RequestMapping(value = "/students/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudent(@PathVariable int id)
    {
        Student student = studentService.findOne(id);

        return Optional.ofNullable(student)
                .map(result -> new ResponseEntity<>(
                        result,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /students/:id : delete the "id" student.
     *
     * @param id the id of the student to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/students/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteStudent(@PathVariable int id)
    {
        studentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("student", String.valueOf(id))).build();
    }
}
