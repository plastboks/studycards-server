package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.ApiKey;
import net.plastboks.studycards.service.ApiKeyService;
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
public class ApiKeyResource implements IResource<ApiKey>
{
    @Autowired
    private ApiKeyService apiKeyService;

    private static final String RESOURCE_NAME = "api-keys";

    @Override
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.POST)
    public ResponseEntity<ApiKey> post(ApiKey apiKey) throws URISyntaxException {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME+"/{id}", method = RequestMethod.GET)
    public ResponseEntity<ApiKey> get(@PathVariable int id) {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.PUT)
    public ResponseEntity<ApiKey> put(ApiKey apiKey) throws URISyntaxException {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME+"{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        return null;
    }

    @Override
    @RequestMapping(value = RESOURCE_NAME, method = RequestMethod.GET)
    public List<ApiKey> getAll() {
        return null;
    }
}
