package com.zup.desafio.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NomeDuplicadoValidator.class)
public @interface NotNomeDuplicado {

    String message() default "Já existe uma Categoria com esse nome.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String value() default "";

}
