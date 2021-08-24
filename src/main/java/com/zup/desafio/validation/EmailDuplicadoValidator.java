package com.zup.desafio.validation;

import com.zup.desafio.modelo.Autor;
import com.zup.desafio.repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailDuplicadoValidator implements ConstraintValidator<NotEmailDuplicado, String> {

    @Autowired
    private AutorRepositorio repositorio;

    @Override
    public void initialize(NotEmailDuplicado constraintAnnotation) {
        String value = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Autor autor = repositorio.findByEmail(s);
        return autor == null;
    }
}
