package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.Colloquium;
import net.plastboks.studycards.service.ColloquiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/colloquiums")
public class ColloquiumResource
{
    @Autowired
    private ColloquiumService colloquiumService;

    @RequestMapping(method = RequestMethod.GET)
    public Colloquium get(@RequestParam(value = "id") int id)
    {
        return colloquiumService.findOne(id);
    }
}
