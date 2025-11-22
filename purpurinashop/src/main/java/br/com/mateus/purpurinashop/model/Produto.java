package br.com.mateus.purpurinashop.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp; 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String tipoDeMetal;

    private String gemas; 

    private Double pesoEmGramas;
    private String quilates; 

    private String dimensoes;

    private BigDecimal precoDeCompra;
    private BigDecimal precoDeVenda;

    @CreationTimestamp 
    @Column(updatable = false) 
    private LocalDate dataDeCadastro;
}