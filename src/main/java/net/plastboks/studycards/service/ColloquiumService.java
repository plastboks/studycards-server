package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Colloquium;
import net.plastboks.studycards.repository.ColloquiumRepository;
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
    private ColloquiumRepository colloquiumRepository;

    @Override
    public Colloquium save(Colloquium colloquium)
    {
        return colloquiumRepository.save(colloquium);
    }

    @Override
    public Colloquium delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Colloquium> findAll()
    {
        return colloquiumRepository.findAll();
    }

    @Override
    public Colloquium findOne(int id)
    {
        return colloquiumRepository.findOne(id);
    }
}
