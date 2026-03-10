package com.clasejava.demo_jpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clasejava.demo_jpa.entity.Usuario;
import com.clasejava.demo_jpa.repository.UsuarioRepository;

@Service
public class UsuarioService {
     
    private final UsuarioRepository usuarioRepository;
    //spring inyecta automaticamente el repositorio en el constructor
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);

    }

    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null)  ;
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setEmail(usuario.getEmail());
            return usuarioRepository.save(usuarioExistente);
        }
        return null;
    }
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
