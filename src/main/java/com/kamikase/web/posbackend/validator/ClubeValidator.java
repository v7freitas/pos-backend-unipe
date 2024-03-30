package com.kamikase.web.posbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class ClubeValidator implements
        ConstraintValidator<ClubeValidation, String> {

    List<String> clubesProibidos = Arrays.asList("Flamengo", "Palmeiras", "Fluminense", "Botafogo");
    private String message;

    @Override
    public void initialize(ClubeValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if (!clubesProibidos.contains(nome)) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return false;
    }
}