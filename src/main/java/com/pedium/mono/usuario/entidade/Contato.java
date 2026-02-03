package com.pedium.mono.usuario.entidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Contato {
 
    private Long id;
    private String email;
    private String celular;
}
