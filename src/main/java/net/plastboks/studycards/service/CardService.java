package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Card;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@Service
public class CardService implements IService<Card>
{
    @Resource
    private CardService cardService;

    @Override
    public Card create(Card card)
    {
        return null;
    }

    @Override
    public Card delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Card> findAll()
    {
        return null;
    }

    @Override
    public Card update(Card card) throws NotFoundException
    {
        return null;
    }

    @Override
    public Card findById(int id)
    {
        return null;
    }
}
