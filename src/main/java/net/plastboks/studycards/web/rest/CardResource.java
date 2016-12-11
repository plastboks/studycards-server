package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.Card;
import net.plastboks.studycards.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/cards")
public class CardResource
{
    @Autowired
    private CardService cardService;

    @RequestMapping(method = RequestMethod.GET)
    public Card get(@RequestParam(value = "id") int id)
    {
        return cardService.findOne(id);
    }
}
