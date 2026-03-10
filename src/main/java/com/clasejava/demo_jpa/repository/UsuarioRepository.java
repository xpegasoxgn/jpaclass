package com.clasejava.demo_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clasejava.demo_jpa.entity.Usuario;

@Repository
public interface  UsuarioRepository extends JpaRepository<Usuario, Long>    {
    


    
}
