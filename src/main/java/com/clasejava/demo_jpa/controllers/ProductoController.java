package com.clasejava.demo_jpa.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clasejava.demo_jpa.entity.Producto;
import com.clasejava.demo_jpa.service.ProductoService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    private final ProductoService productoService;
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getMethodName() {

        return productoService.listarProductos();
    }

    
    @GetMapping("/listaproductos")
    public Page<Producto> listarProductos(Pageable pageable) {

        return productoService.listarProductos(pageable);
    }
    @PostMapping
    public Producto postMethodName(@Valid @RequestBody Producto entity) {
        
        
        return productoService.crearProducto(entity);
    }
    @GetMapping("/{id}")
    public Producto getMethodName(@PathVariable Long id) {
        return productoService.buscar(id);
    }
    
    @PutMapping("/actualizar/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Producto entity) {
        //TODO: process PUT request
        
        productoService.actualizarProducto(id, entity).toString();

        return "Producto actualizado correctamente";
    }
    @DeleteMapping("/eliminar/{id}")
    public String deleteMethodName(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "Producto eliminado correctamente";
    }
    
}
