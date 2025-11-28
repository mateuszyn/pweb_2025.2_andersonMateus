package br.com.mateus.purpurinashop.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data               
@NoArgsConstructor  
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;

    private String genero;
    private String rua;
    private String bairro;
    private String numero;
    private String cidade;
    private String telefone;

    @ToString.Exclude 
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Dependente> dependentes;

    @ToString.Exclude 
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;
}