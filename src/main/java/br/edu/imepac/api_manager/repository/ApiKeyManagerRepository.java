package br.edu.imepac.api_manager.repository;

import br.edu.imepac.api_manager.entidades.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiKeyManagerRepository extends JpaRepository<ApiKey, Long> {
    void deleteByIdAndApiKey(Long id, String apiKey);

    Optional<ApiKey> findByIdAndRegister(Long id, String record);
}
