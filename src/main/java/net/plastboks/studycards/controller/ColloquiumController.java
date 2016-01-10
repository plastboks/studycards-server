package net.plastboks.studycards.controller;

import net.plastboks.studycards.entity.Colloquium;
import net.plastboks.studycards.service.ColloquiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/colloquium")
public class ColloquiumController
{
    @Autowired
    private ColloquiumService colloquiumService;

    public Colloquium get(@RequestParam(value = "id") int id)
    {
        Colloquium c = colloquiumService.findById(id);

        return c;
    }
}
