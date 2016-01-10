package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Colloquium;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@Service
public class ColloquiumService implements IService<Colloquium>
{
    @Resource
    private ColloquiumService colloquiumService;

    @Override
    public Colloquium create(Colloquium colloquium)
    {
        return null;
    }

    @Override
    public Colloquium delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Colloquium> findAll()
    {
        return null;
    }

    @Override
    public Colloquium update(Colloquium colloquium) throws NotFoundException
    {
        return null;
    }

    @Override
    public Colloquium findById(int id)
    {
        return null;
    }
}
