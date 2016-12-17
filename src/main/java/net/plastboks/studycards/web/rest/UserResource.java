package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.domain.User;
import net.plastboks.studycards.service.StudentService;
import net.plastboks.studycards.web.rest.util.HeaderUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = Constants.API_VERSION, produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentResource implements IResource<User>
{
    @Autowired
    private StudentService studentService;

    private final Logger log = LoggerFactory.getLogger(StudentResource.class);
    private final String RESOURCE_NAME = "students";

    /**
     * POST /students: Create a new student
     *
     * @param student the student to save
     * @return the ResponseEntity with status 201 (Created) and with body the new student, or with status 400 (Bad Request) if the student has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.POST)
    public ResponseEntity<User> post(@RequestBody User student)
            throws URISyntaxException
    {
        log.debug("REST request to save Student : {}", student);
        if (student.getId() != null) {
            return ResponseEntity.badRequest()
                    .headers(HeaderUtil.createFailureAlert("student", "idexists", "A new student cannot already have an ID"))
                    .body(null);
        }

        User result = studentService.save(student);
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
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.PUT)
    public ResponseEntity<User> put(@RequestBody User student) throws URISyntaxException
    {
        log.debug("REST request to update Student : {}", student);
        if (student.getId() == null) {
            return post(student);
        }
        User result = studentService.save(student);
        return ResponseEntity.ok()
                .headers(HeaderUtil.createEntityUpdateAlert("student", student.getId().toString()))
                .body(result);
    }

    /**
     * GET /students
     *
     * @return the ResponseEntity with status 200 (OK) and the list of students in body
     */
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.GET)
    public List<User> getAll()
    {
        log.debug("REST request to fetch all students");
        return studentService.findAll();
    }

    /**
     * GET /students/:id get the student with id
     *
     * @param id the id of the student to retrieve
     * @return the ResponseEntity with status 200 (OK) and the student in body, or 404 (Not found)
     */
    @RequestMapping(value = RESOURCE_NAME+"/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> get(@PathVariable int id)
    {
        log.debug("REST request to get student: ", id);

        User student = studentService.findOne(id);

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
    @RequestMapping(value = RESOURCE_NAME+"{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id)
    {
        log.debug("REST request to delete student: ", id);
        studentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("student", String.valueOf(id))).build();
    }
}
