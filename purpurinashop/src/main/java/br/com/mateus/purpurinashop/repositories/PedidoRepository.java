package br.com.mateus.purpurinashop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateus.purpurinashop.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findTop3ByOrderByDataPedidoDesc();
}