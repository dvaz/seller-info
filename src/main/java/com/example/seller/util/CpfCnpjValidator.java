package com.example.seller.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {

    @Override
    public void initialize(CpfCnpj constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || value.isEmpty() || ValidateCPF.isValidCPF(value) || ValidateCNPJ.isValidCNPJ(value);
    }

}
