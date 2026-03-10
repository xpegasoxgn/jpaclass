package com.clasejava.demo_jpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clasejava.demo_jpa.entity.Pedido;
import com.clasejava.demo_jpa.service.PedidoService;


@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@RequestParam Long clienteId, @RequestParam Long productoId, @RequestParam int cantidad) {
        
        
        return pedidoService.crearPedido(clienteId, productoId, cantidad);
    }
    
    
}
