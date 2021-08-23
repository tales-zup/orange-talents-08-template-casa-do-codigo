package com.zup.desafio.modelo.repositorio;

import org.springframework.data.repository.CrudRepository;

public interface AlunoRepositorio<Aluno> extends CrudRepository<Aluno, Long> {
}
