package com.pedium.usuario.entidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Usuario {
 
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String senha;
    private Contato contato;
    private Role role;
}
