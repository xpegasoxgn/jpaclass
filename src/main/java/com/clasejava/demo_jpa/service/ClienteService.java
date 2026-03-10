package com.clasejava.demo_jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clasejava.demo_jpa.entity.Cliente;
import com.clasejava.demo_jpa.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }
    public Cliente crear(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
