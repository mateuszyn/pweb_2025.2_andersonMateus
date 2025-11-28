package br.com.mateus.purpurinashop.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
public class Pedido {

    private static final BigDecimal IMPOSTO = new BigDecimal("0.3575");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude 
    @ManyToOne 
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemPedido> itens;

    private LocalDateTime dataPedido;
    
    private String formaPagamento;
    private String dadosPagamento;


    public BigDecimal getTotalItens() {
        if (itens == null) return BigDecimal.ZERO;
        
        return itens.stream()
            .map(ItemPedido::getValorTotal)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
    public BigDecimal getValorImposto() {
        return getTotalItens().multiply(IMPOSTO);
    }

    public BigDecimal getTotalGeral() {
        return getTotalItens().add(getValorImposto());
    }
    
}