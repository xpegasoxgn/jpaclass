package com.clasejava.demo_jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clasejava.demo_jpa.entity.Producto;
import com.clasejava.demo_jpa.repository.ProductoRepository;


@Service
public class ProductoService{
    private final ProductoRepository productoRepository;
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List <Producto> listarProductos(){
        return productoRepository.findAll();
    }
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }
    public Producto buscar(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        });
        
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        Producto productoExistente = productoRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        });
        productoExistente.setNombre(producto.getNombre());
        productoExistente.setPrecio(producto.getPrecio());
        return productoRepository.save(productoExistente);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
