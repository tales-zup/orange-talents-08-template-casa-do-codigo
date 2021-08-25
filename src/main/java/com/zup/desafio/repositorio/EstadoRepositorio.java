package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Estado;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepositorio extends CrudRepository<Estado, Long> {

    Estado findByPais_NomeAndNome(String nomePais, String nome);

}
