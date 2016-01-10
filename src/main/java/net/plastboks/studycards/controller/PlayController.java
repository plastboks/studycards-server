package net.plastboks.studycards.controller;

import net.plastboks.studycards.entity.Play;
import net.plastboks.studycards.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/play")
public class PlayController
{
    @Autowired
    private PlayService playService;

    public Play get(@RequestParam(value = "id") int id)
    {
        Play p = playService.findById(id);

        return p;
    }
}
