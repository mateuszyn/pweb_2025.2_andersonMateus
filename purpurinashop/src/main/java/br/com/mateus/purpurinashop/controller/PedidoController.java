package br.com.mateus.purpurinashop.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mateus.purpurinashop.model.Cliente;
import br.com.mateus.purpurinashop.model.ItemPedido;
import br.com.mateus.purpurinashop.model.Pedido;
import br.com.mateus.purpurinashop.model.Produto;
import br.com.mateus.purpurinashop.repositories.ClienteRepository;
import br.com.mateus.purpurinashop.repositories.PedidoRepository;
import br.com.mateus.purpurinashop.repositories.ProdutoRepository;

@Controller
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepo;
    
    @Autowired
    private ProdutoRepository produtoRepo;
    
    @Autowired
    private ClienteRepository clienteRepo;


    @GetMapping("/listarPedidos")
    public ModelAndView listarPedidos() {
        ModelAndView modelAndView = new ModelAndView("listarPedidos");
        List<Pedido> pedidos = pedidoRepo.findAll();
        modelAndView.addObject("pedidos", pedidos);
        return modelAndView;
    }

    @GetMapping("/adicionarPedido")
    public ModelAndView formularioAdicionarPedido() {
        ModelAndView modelAndView = new ModelAndView("adicionarPedido");
        
        modelAndView.addObject("pedido", new Pedido()); 
        
        List<Cliente> clientes = clienteRepo.findAll();
        modelAndView.addObject("clientes", clientes);
        
        List<Produto> produtos = produtoRepo.findAllByOrderByMarcaAsc(); 
        modelAndView.addObject("produtos", produtos);
        
        return modelAndView;
    }
    
    @PostMapping("/adicionarPedido")
    public String adicionarPedido(Pedido pedido) {
        
        pedido.setDataPedido(LocalDateTime.now());
        
        List<ItemPedido> itensValidos = pedido.getItens().stream()
            .filter(item -> item.getQuantidade() != null && item.getQuantidade() > 0 && item.getProduto() != null)
            .toList();
        
        for (ItemPedido item : itensValidos) {
            item.setPedido(pedido);
            
            Produto prod = produtoRepo.findById(item.getProduto().getId()).orElse(null);
            if (prod != null) {
                item.setProduto(prod); 
            }
        }
        
        pedido.setItens(itensValidos);

        pedidoRepo.save(pedido);
        
        return "redirect:/listarPedidos"; 
    }
    
    @GetMapping("/excluirPedido/{id}")
    public String excluirPedido(@PathVariable("id") Long id) {
        pedidoRepo.deleteById(id);
        return "redirect:/listarPedidos";
    }

    @GetMapping("/editarPedido/{id}")
    public ModelAndView formularioEditarPedido(@PathVariable("id") Long id) {
        Optional<Pedido> pedidoOptional = pedidoRepo.findById(id);
        if (pedidoOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("editarPedido");
            modelAndView.addObject("pedido", pedidoOptional.get());
            
            modelAndView.addObject("clientes", clienteRepo.findAll());
            modelAndView.addObject("produtos", produtoRepo.findAll());

            return modelAndView;
        }
        return new ModelAndView("redirect:/listarPedidos");
    }

    @PostMapping("/editarPedido")
    public String editarPedido(Pedido pedido) {
        
        pedido.setDataPedido(LocalDateTime.now());
        
        List<ItemPedido> itensValidos = pedido.getItens().stream()
            .filter(item -> item.getQuantidade() != null && item.getQuantidade() > 0)
            .toList();

        for (ItemPedido item : itensValidos) {
            item.setPedido(pedido);
            Produto prod = produtoRepo.findById(item.getProduto().getId()).orElse(null);
            if (prod != null) {
                 item.setProduto(prod); 
            }
        }
        pedido.setItens(itensValidos);

        pedidoRepo.save(pedido); 
        return "redirect:/listarPedidos";
    }
}