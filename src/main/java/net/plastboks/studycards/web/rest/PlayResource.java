package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.Play;
import net.plastboks.studycards.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/plays")
public class PlayResource
{
    @Autowired
    private PlayService playService;

    @RequestMapping(method = RequestMethod.GET)
    public Play get(@RequestParam(value = "id") int id)
    {
        return playService.findOne(id);
    }
}
