package com.clasejava.demo_jpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clasejava.demo_jpa.dto.PedidoDTO;
import com.clasejava.demo_jpa.dto.ProductoVentaDTO;
import com.clasejava.demo_jpa.dto.VentaClienteDTO;
import com.clasejava.demo_jpa.entity.Pedido;
import com.clasejava.demo_jpa.entity.Producto;
import com.clasejava.demo_jpa.service.PedidoService;
import com.clasejava.demo_jpa.utils.JsonResult;



@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@RequestParam Long clienteId, @RequestParam Long productoId, @RequestParam int cantidad) {
        
        
        return pedidoService.crearPedido(clienteId, productoId, cantidad);
    }
    //mal no es buena practica usar get para crear recursos, pero lo hago para probar el servicio sin necesidad de usar postman o algun cliente http
    @GetMapping
    public List <PedidoDTO> getMethodName() {
        return pedidoService.listarPedidos();
    }
    
    @GetMapping("/reportes/productos-por-cliente")
    public List<VentaClienteDTO> productoPorCliente() {
        return pedidoService.ventasPorCliente();
    }
    
     @GetMapping("/reportes/productos-mas-vendidos")
    public List<ProductoVentaDTO> productoMasVendido() {
        return pedidoService.productoMasVendido();
    }

    @GetMapping("/listasPedido")
    public JsonResult listaconJsonResult() {
        
        List<PedidoDTO> pedidos = pedidoService.listarPedidos();
        return new JsonResult(true, "Pedidos listados correctamente", pedidos);
    }

    
    @GetMapping("/busca/{id}")
    public JsonResult buscarPedido2(@PathVariable Long id) {
        
        Producto producto = pedidoService.buscaProducto(id);
        
        return new JsonResult(true, "Producto encontrado", producto);
    }
    @GetMapping("/{id}")
    public JsonResult buscarPedido(@PathVariable Long id) {
        
        Pedido pedido = pedidoService.buscarPedido(id);
        
        if (pedido != null) {
            
            return new JsonResult(true, "Pedido encontrado", pedido);
        } else {
            return new JsonResult(false, "Pedido no encontrado", pedido);
        }
    }
    

    
}
