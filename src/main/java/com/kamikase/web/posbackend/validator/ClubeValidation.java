package com.kamikase.web.posbackend.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ClubeValidator.class)
public @interface ClubeValidation {
    String message() default "Esse clube não pode ser cadastrado!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
