package net.plastboks.studycards.controller;

import net.plastboks.studycards.model.dao.QuestionDAO;
import net.plastboks.studycards.model.type.Question;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alex on 12/17/15.
 */
@RestController
public class QuestionController
{
    private final QuestionDAO questionDAO = new QuestionDAO();

    @RequestMapping(value = "/question/{id}", method = RequestMethod.GET)
    public Question getQuestion(@PathVariable int id)
    {
        return questionDAO.getById(id);
    }

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public List<Question> getQuestions()
    {
        return questionDAO.get();
    }
}
