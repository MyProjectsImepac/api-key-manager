package br.edu.imepac.api_manager.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiKeyDto {
    private Long id;
    private String register;
    private String apiKey;
}
