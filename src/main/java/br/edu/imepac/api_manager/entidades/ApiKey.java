package br.edu.imepac.api_manager.entidades;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "api_key")
public class ApiKey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String register;
    @Column(name = "api_key")
    private String apiKey;
}