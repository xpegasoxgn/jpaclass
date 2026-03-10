package com.clasejava.demo_jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clasejava.demo_jpa.dto.PedidoDTO;
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
    
    public List<PedidoDTO> listarPedidos() {
        
        List <Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(p -> {
            Double total = p.getProducto().getPrecio() * p.getCantidad();
            Integer cantidad = p.getCantidad();
            Double precioUnitario = p.getProducto().getPrecio();

            return new PedidoDTO(p.getId(), p.getCliente().getNombre(), p.getProducto().getNombre(), cantidad, total);

            
            }).toList();
    }

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
