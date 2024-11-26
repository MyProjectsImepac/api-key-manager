package br.edu.imepac.api_manager.resources;

import br.edu.imepac.api_manager.dtos.ApiKeyDto;
import br.edu.imepac.api_manager.dtos.ApiKeyRegisterDto;
import br.edu.imepac.api_manager.services.ApiKeyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/api-key")
public class ApiKeyResources {
    private final ApiKeyService apiKeyService;

    public ApiKeyResources(ApiKeyService apiKeyService) {
        this.apiKeyService = apiKeyService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiKeyDto register(@RequestBody ApiKeyRegisterDto apiKeyRegisterDto) {
        return apiKeyService.register(apiKeyRegisterDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ApiKeyDto findById(@PathVariable Long id, @RequestParam("register") String register) {
        return apiKeyService.findByIdAndRegister(id, register);
    }

    @DeleteMapping("/{id}/{apiKey}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id, @PathVariable String apiKey) {
        apiKeyService.delete(id, apiKey);
    }
}
