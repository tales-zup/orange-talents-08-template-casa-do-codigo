package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Autor;
import org.springframework.data.repository.CrudRepository;

public interface AutorRepositorio extends CrudRepository<Autor, Long> {

    Autor findByEmail(String email);

}
