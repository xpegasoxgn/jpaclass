package com.clasejava.demo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clasejava.demo_jpa.entity.Pedido;

public interface  PedidoRepository extends JpaRepository<Pedido, Long>    {
    
}
