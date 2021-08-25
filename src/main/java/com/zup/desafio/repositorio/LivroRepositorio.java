package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
}
