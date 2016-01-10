package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Question;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@Service
public class QuestionService implements IService<Question>
{
    @Resource
    private QuestionService questionService;

    @Override
    public Question create(Question question)
    {
        return null;
    }

    @Override
    public Question delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Question> findAll()
    {
        return null;
    }

    @Override
    public Question update(Question question) throws NotFoundException
    {
        return null;
    }

    @Override
    public Question findById(int id)
    {
        return null;
    }
}
