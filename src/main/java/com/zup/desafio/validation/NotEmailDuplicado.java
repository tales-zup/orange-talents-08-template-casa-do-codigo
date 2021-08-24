package com.zup.desafio.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailDuplicadoValidator.class)
public @interface NotEmailDuplicado {

    String message() default "Já existe um Autor com esse email.";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    String value() default "";

}
