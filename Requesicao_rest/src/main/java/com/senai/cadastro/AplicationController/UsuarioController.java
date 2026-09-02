package com.senai.cadastro.AplicationController;

import com.senai.cadastro.Enitity.Usuario;
import com.senai.cadastro.ServiceAplication.ServiceAplication;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {


    final ServiceAplication ServiceAplication;


    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return ServiceAplication.findAll();
    }

    @GetMapping("/{id}")
    public Usuario listarUsuarioPorId(@PathVariable UUID id) {
        return ServiceAplication.findById(id);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return ServiceAplication.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable UUID id, @RequestBody Usuario usuario) {
        return ServiceAplication.update(id, usuario);
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable UUID id) {
        ServiceAplication.deleteById(id);
    }
}