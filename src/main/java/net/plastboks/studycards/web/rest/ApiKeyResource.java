package net.plastboks.studycards.web.rest;

import net.plastboks.studycards.entity.ApiKey;
import net.plastboks.studycards.service.ApiKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 1/10/16.
 */
@RestController
@RequestMapping(value = "/apikey")
public class ApiKeyResource
{
    @Autowired
    private ApiKeyService apiKeyService;

    public ApiKey get(@RequestParam(value = "id") int id)
    {
        ApiKey ak = apiKeyService.findById(id);

        return ak;
    }
}
