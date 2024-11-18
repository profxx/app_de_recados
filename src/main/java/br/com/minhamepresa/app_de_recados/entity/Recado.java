package br.com.minhamepresa.app_de_recados.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Recado {

    @Id // Chave Primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincrement
    private Long id;
    private String mensagem;
    private String status;
    
}
