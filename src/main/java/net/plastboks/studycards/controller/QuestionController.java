package net.plastboks.studycards.controller;

import net.plastboks.studycards.entity.Question;
import net.plastboks.studycards.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "question")
public class QuestionController
{
    @Autowired
    private QuestionService questionService;

    public Question get(@RequestParam(value = "id") int id)
    {
        Question q = questionService.findById(id);

        return q;
    }
}
