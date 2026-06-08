package com.choma.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.choma.restaurante.model.Pedido;
import com.choma.restaurante.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido){
        return pedidoService.criarPedido(pedido);
    }


    @GetMapping
    public List<Pedido> lerPedidos(){
        return pedidoService.lerLista();
    }
}
