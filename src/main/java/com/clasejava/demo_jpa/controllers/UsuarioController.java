package com.clasejava.demo_jpa.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clasejava.demo_jpa.entity.Usuario;
import com.clasejava.demo_jpa.service.UsuarioService;





@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    private final UsuarioService usuarioService;
    //spring inyecta automaticamente el servicio en el constructor
    public UsuarioController(UsuarioService usuarioService) {   
        this.usuarioService = usuarioService;
    }
    

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.listar();
    }


    @PostMapping("/crear")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        

        return usuarioService.crear(usuario);
    }

    @PutMapping("actualizar/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        
        
        return usuarioService.actualizar(id, usuario)   ;
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "Usuario eliminado correctamente";
    }
}
