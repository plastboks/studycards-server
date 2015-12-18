package net.plastboks.studycards.controller;

import net.plastboks.studycards.model.dao.ColloquiumDAO;
import net.plastboks.studycards.model.type.Colloquium;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alex on 12/17/15.
 */
@RestController
public class ColloquiumController
{
    private final ColloquiumDAO colloquiumDAO = new ColloquiumDAO();

    @RequestMapping(value = "/colloquium/{id}", method = RequestMethod.GET)
    public Colloquium getColloquium(@PathVariable int id)
    {
        return colloquiumDAO.getById(id);
    }

    @RequestMapping(value = "/colloquium", method = RequestMethod.GET)
    public List<Colloquium> getColloquia()
    {
        return colloquiumDAO.get();
    }
}
