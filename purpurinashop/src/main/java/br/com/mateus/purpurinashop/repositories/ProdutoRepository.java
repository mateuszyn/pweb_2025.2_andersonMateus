package br.com.mateus.purpurinashop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateus.purpurinashop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findTop3ByOrderByIdAsc();

    List<Produto> findAllByOrderByMarcaAsc();

    List<Produto> findByMarcaContainingIgnoreCaseOrTipoDeMetalContainingIgnoreCaseOrGemasContainingIgnoreCaseOrQuilatesContainingIgnoreCase(
        String keyword1, String keyword2, String keyword3, String keyword4
    );

}