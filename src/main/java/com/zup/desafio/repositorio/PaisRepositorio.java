package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepositorio extends JpaRepository<Pais, Long> {
}
