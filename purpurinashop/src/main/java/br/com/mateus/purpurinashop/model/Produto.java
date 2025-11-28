package br.com.mateus.purpurinashop.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Produto {
    @OneToMany(mappedBy = "produto", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ItemPedido> itens;

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