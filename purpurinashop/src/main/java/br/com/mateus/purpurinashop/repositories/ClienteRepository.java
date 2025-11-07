package br.com.mateus.purpurinashop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateus.purpurinashop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findTop3ByOrderByIdAsc();
    
}