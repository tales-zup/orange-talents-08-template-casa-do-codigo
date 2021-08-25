package com.zup.desafio.repositorio;

import com.zup.desafio.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {
}
