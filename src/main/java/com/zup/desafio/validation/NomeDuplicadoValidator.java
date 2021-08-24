package com.zup.desafio.validation;

import com.zup.desafio.modelo.Categoria;
import com.zup.desafio.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NomeDuplicadoValidator implements ConstraintValidator<NotNomeDuplicado, String> {

    @Autowired
    private CategoriaRepositorio repositorio;

    @Override
    public void initialize(NotNomeDuplicado constraintAnnotation) {
        String value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Categoria categoria = repositorio.findByNome(s);
        return categoria == null;
    }
}
