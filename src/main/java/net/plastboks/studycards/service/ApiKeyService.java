package net.plastboks.studycards.service;

import javassist.NotFoundException;
import net.plastboks.studycards.entity.ApiKey;
import net.plastboks.studycards.repository.ApiKeyRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by alex on 1/10/16.
 */
@Service
public class ApiKeyService implements IService<ApiKey>
{
    @Resource
    private ApiKeyRepository apiKeyRepository;

    @Override
    public ApiKey save(ApiKey apiKey)
    {
        return apiKeyRepository.save(apiKey);
    }

    @Override
    public ApiKey delete(int id) throws NotFoundException
    {
        return null;
    }

    @Override
    public List<ApiKey> findAll()
    {
        return apiKeyRepository.findAll();
    }

    @Override
    public ApiKey findOne(int id)
    {
        return apiKeyRepository.findOne(id);
    }
}
