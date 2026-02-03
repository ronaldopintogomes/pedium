package com.pedium.usuario.repositorio;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.pedium.mono.usuario.entidade.Usuario;

@Repository
public class UsuarioRepositorio {
    
    private final JdbcClient jdbcClient;
    
    public UsuarioRepositorio(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Optional<Usuario> buscarPorCfpCnpj(String cpfCnpj) {
        return jdbcClient.sql(SqlLoader.load("buscar_usuario_por_cpf_cnpj.sql"))
            .param("cpf_cnpj", cpfCnpj)
            .query(Usuario.class)
            .optional();
    }
}
