package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.Card;
import net.plastboks.studycards.repository.CardRepository;
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
    private CardRepository cardRepository;

    @Override
    public Card save(Card card)
    {
        return cardRepository.save(card);
    }

    @Override
    public Card delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<Card> findAll()
    {
        return cardRepository.findAll();
    }

    @Override
    public Card findOne(int id)
    {
        return cardRepository.findOne(id);
    }
}
