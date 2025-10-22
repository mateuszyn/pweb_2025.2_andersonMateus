package br.com.mateus.cadpessoas_mateus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateus.cadpessoas_mateus.model.Pessoa;

public interface PessoaRepoitory extends JpaRepository<Pessoa, Long>{
    
}
