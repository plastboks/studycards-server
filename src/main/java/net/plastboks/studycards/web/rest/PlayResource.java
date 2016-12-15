package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.Play;
import net.plastboks.studycards.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = Constants.API_VERSION, produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayResource implements IResource<Play>
{
    @Autowired
    private PlayService playService;

    private static final String RESOURCE_NAME = "plays";

    @Override
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.POST)
    public ResponseEntity<Play> post(Play play) throws URISyntaxException {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME+"/{id}", method = RequestMethod.GET)
    public ResponseEntity<Play> get(@PathVariable int id) {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.PUT)
    public ResponseEntity<Play> put(Play play) throws URISyntaxException {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME+"{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.GET)
    public List<Play> getAll() {
        return null;
    }
}
