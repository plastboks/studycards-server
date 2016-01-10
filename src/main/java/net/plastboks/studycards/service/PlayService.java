package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Play;
import net.plastboks.studycards.repository.PlayRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@Service
public class PlayService implements IService<Play>
{
    @Resource
    private PlayRepository playRepository;

    @Override
    public Play create(Play play)
    {
        return null;
    }

    @Override
    public Play delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Play> findAll()
    {
        return null;
    }

    @Override
    public Play update(Play play) throws NotFoundException
    {
        return null;
    }

    @Override
    public Play findById(int id)
    {
        return null;
    }
}
