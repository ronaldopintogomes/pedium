package com.pedium.mono.usuario.servico;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pedium.mono.usuario.entidade.Usuario;
import com.pedium.mono.usuario.repositorio.UsuarioRepositorio;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public UserDetails loadUserByUsername(String cpfCnpj) {
        Usuario usuario = usuarioRepositorio.buscarPorCfpCnpj(cpfCnpj).orElseThrow(
            () -> new UsernameNotFoundException("Usuario nao encontrado!")
        );
        return User
            .withUsername(usuario.getCpfCnpj())
            .password(usuario.getSenha())
            .roles(usuario.getRole().name())
            .build();
    }
}
