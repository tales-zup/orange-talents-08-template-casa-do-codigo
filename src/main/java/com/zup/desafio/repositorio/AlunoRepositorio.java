package com.zup.desafio.repositorio;

import org.springframework.data.repository.CrudRepository;

public interface AlunoRepositorio<Aluno> extends CrudRepository<Aluno, Long> {
}
