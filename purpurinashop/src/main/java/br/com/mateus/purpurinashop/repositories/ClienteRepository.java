package br.com.mateus.purpurinashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateus.purpurinashop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}