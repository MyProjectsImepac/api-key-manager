package br.edu.imepac.api_manager.services;

import br.edu.imepac.api_manager.dtos.ApiKeyDto;
import br.edu.imepac.api_manager.dtos.ApiKeyRegisterDto;
import br.edu.imepac.api_manager.entidades.ApiKey;
import br.edu.imepac.api_manager.repository.ApiKeyManagerRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApiKeyService {
    private final ApiKeyManagerRepository apiKeyManagerRepository;
    private final ModelMapper modelMapper;

    public ApiKeyService(ApiKeyManagerRepository apiKeyManagerRepository, ModelMapper modelMapper) {
        this.apiKeyManagerRepository = apiKeyManagerRepository;
        this.modelMapper = modelMapper;
    }

    public ApiKeyDto register(ApiKeyRegisterDto apiKeyRegisterDto) {
        ApiKey apiKey = modelMapper.map(apiKeyRegisterDto, ApiKey.class);
        apiKey.setApiKey(UUID.randomUUID().toString());
        ApiKey savedApiKey = apiKeyManagerRepository.save(apiKey);
        return modelMapper.map(savedApiKey, ApiKeyDto.class);
    }


    public ApiKeyDto findByIdAndRegister(Long id, String register) {
        ApiKey apiKey = apiKeyManagerRepository.findByIdAndRegister(id,register).orElseThrow();
        return modelMapper.map(apiKey, ApiKeyDto.class);
    }

    @Transactional
    public void delete(Long id, String apiKey) {
        apiKeyManagerRepository.deleteByIdAndApiKey(id, apiKey);
    }
}
