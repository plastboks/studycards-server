package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Deck;
import net.plastboks.studycards.repository.DeckRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@Service
public class DeckService implements IService<Deck>
{
    @Resource
    private DeckRepository deckRepository;

    @Override
    public Deck create(Deck deck)
    {
        return null;
    }

    @Override
    public Deck delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Deck> findAll()
    {
        return null;
    }

    @Override
    public Deck update(Deck deck) throws NotFoundException
    {
        return null;
    }

    @Override
    public Deck findById(int id)
    {
        return null;
    }
}
