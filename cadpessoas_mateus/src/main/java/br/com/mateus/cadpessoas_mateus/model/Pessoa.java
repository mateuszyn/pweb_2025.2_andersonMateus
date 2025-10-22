package br.com.mateus.cadpessoas_mateus.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoas")
@Data 
@NoArgsConstructor 
@AllArgsConstructor

public class Pessoa implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String email;
    private String genero;
    private LocalDate dataNascimento;

    public String getDataNascimentoFormatada(){
        if (dataNascimento == null){
            return "N/A";
        }
        return dataNascimento.format(DateTimeFormatter.ofPattern ("dd/MM/yyyy"));
    }
    
}
