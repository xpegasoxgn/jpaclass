package com.clasejava.demo_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasejava.demo_jpa.entity.Cliente;
import com.clasejava.demo_jpa.entity.Pedido;
import com.clasejava.demo_jpa.entity.Producto;
import com.clasejava.demo_jpa.repository.ClienteRepository;
import com.clasejava.demo_jpa.repository.PedidoRepository;
import com.clasejava.demo_jpa.repository.ProductoRepository;


@Service
public class PedidoService {

    @Autowired
    private  PedidoRepository pedidoRepository;
    @Autowired
    private  ClienteRepository clienteRepository;
    @Autowired
    private  ProductoRepository productoRepository;
    

    public Pedido crearPedido(Long clienteId, Long productoId, int cantidad) {

        //buscar cliente
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> {
            throw new RuntimeException("Cliente no encontrado con id: " + clienteId);
        });

        //buscar el producto
        Producto producto = productoRepository.findById(productoId).orElseThrow(() -> {
            throw new RuntimeException("Producto no encontrado con id: " + productoId);
        });

        //crear el pedido
        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setProducto(producto);
        pedido.setCantidad(cantidad);
        return pedidoRepository.save(pedido);
    }
    
}
