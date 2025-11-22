package br.com.mateus.purpurinashop.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    private Produto produto;

    private Integer quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne 
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    
    public BigDecimal getValorTotal() {
        if (precoUnitario != null && quantidade != null) {
            return precoUnitario.multiply(new BigDecimal(quantidade));
        }
        return BigDecimal.ZERO;
    }
}