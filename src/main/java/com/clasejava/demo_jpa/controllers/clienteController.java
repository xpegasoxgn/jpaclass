package com.clasejava.demo_jpa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.clasejava.demo_jpa.entity.Cliente;
import com.clasejava.demo_jpa.service.ClienteService;



@RestController
@RequestMapping("/clientes")
public class clienteController {
    private final ClienteService clienteService;
    public clienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }
    @PostMapping
    public Cliente postMethodName(@RequestBody Cliente entity) {
        
        
        return clienteService.crear(entity);
    }
    @DeleteMapping
    public String eliminar(@RequestParam Long id) {
        clienteService.eliminar(id);
        return "Cliente eliminado correctamente";
    }
    

}
