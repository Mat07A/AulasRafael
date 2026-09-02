package com.senai.cadastro.ServiceAplication;

import com.senai.cadastro.Enitity.Usuario;
import com.senai.cadastro.Repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ServiceAplication {

    final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(UUID id) {
        Optional<Usuario> usuario0pt = usuarioRepository.findById(id);

        if(usuario0pt.isPresent()){
            return usuario0pt.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario save(Usuario usuarioExistente) {
        return usuarioRepository.save(usuarioExistente);
    }

    public void deleteById(UUID id) {
        usuarioRepository.delete(findById(id));
    }

    public Usuario update(UUID id, Usuario usuario){
        Usuario usuarioExistente = findById(id);;
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setCpf(usuario.getCpf());
        usuarioExistente.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioExistente);
    }
}
