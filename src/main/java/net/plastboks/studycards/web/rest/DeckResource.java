package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.Deck;
import net.plastboks.studycards.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/decks")
public class DeckResource
{
    @Autowired
    private DeckService deckService;

    @RequestMapping(method = RequestMethod.GET)
    public Deck get(@RequestParam(value = "id") int id)
    {
        return deckService.findOne(id);
    }
}
