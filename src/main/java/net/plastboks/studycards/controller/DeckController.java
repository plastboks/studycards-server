package net.plastboks.studycards.controller;

import net.plastboks.studycards.model.dao.DeckDAO;
import net.plastboks.studycards.model.type.Deck;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alex on 12/17/15.
 */
@RestController
public class DeckController
{
    private final DeckDAO deckDAO = new DeckDAO();

    @RequestMapping(value = "/deck/{id}", method = RequestMethod.GET)
    public Deck getDeck(@PathVariable int id)
    {
        return deckDAO.getById(id);
    }

    @RequestMapping(value = "/deck", method = RequestMethod.GET)
    public List<Deck> getDecks()
    {
        return deckDAO.get();
    }
}
