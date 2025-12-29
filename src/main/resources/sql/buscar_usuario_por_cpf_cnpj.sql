SELECT usuario.id, usuario.nome, usuario.cpf_cnpj, usuario.senha
FROM usuario
WHERE usuario.cpf_cnpj = :cpf_cnpj;
