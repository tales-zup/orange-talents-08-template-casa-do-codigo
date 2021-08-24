package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Categoria;
import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepositorio extends CrudRepository<Categoria, Long> {
}
