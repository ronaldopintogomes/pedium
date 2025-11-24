package com.pedium.monolitico.model.repositorio;

import java.util.Optional;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.pedium.monolitico.model.entidade.Usuario;

@Repository
public class UsuarioRepositorio {
    
    private final JdbcClient jdbcClient;
    
    public UsuarioRepositorio(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public Optional<Usuario> buscarPorCfpCnpj(String cpfCnpj) {
        return JdbcClient.sql(SqlLoader.load("buscar_usuario_por_cpfcnpj.sql"))
            .param("cpf_cnpj", cpfCnpj)
            .query(Usuario.class)
            .optional();
    }
}