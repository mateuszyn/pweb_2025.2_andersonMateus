package br.com.mateus.purpurinashop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.mateus.purpurinashop.model.Cliente;
import br.com.mateus.purpurinashop.model.Pedido;
import br.com.mateus.purpurinashop.model.Produto;
import br.com.mateus.purpurinashop.repositories.ClienteRepository;
import br.com.mateus.purpurinashop.repositories.PedidoRepository;
import br.com.mateus.purpurinashop.repositories.ProdutoRepository;

@Controller
public class HomeController {

    @Autowired
    private ClienteRepository clienteRepo; 

    @Autowired
    private ProdutoRepository produtoRepo; 

    @Autowired
    private PedidoRepository pedidoRepo; 

    @GetMapping({"/", ""})
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("index");

        List<Cliente> clientes = clienteRepo.findTop3ByOrderByIdAsc();
        List<Produto> produtos = produtoRepo.findTop3ByOrderByIdAsc();
        List<Pedido> pedidos = pedidoRepo.findTop3ByOrderByDataPedidoDesc();

        modelAndView.addObject("clientes", clientes);
        modelAndView.addObject("produtos", produtos);
        modelAndView.addObject("pedidos", pedidos);


        return modelAndView;
    }
}