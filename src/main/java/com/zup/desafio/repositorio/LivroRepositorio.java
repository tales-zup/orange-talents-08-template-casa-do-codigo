package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepositorio extends CrudRepository<Livro, Long> {
}
