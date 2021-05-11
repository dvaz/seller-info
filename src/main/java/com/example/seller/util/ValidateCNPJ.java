package com.example.seller.util;

public final class ValidateCNPJ {
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int INDEX_CNPJ_SEM_DIGITO = 12;
    private static final int RADIX_PAD_LEFT = 10;
    private static final int TAMANHO_CNPJ = 14;

    private ValidateCNPJ() {
        throw new IllegalStateException("Classe Util");
    }

    public static boolean isValidCNPJ(String cnpj) {
        if (cnpj == null) {
            return false;
        }
        cnpj = cnpj.replaceAll("\\D", "");
        if ((cnpj.length() != TAMANHO_CNPJ)) {
            return false;
        }
        for (int j = 0; j < RADIX_PAD_LEFT; j++) {
            if (ValidationUtils.padLeft(Integer.toString(j), Character.forDigit(j, RADIX_PAD_LEFT), "%14s").equals(cnpj)) {
                return false;
            }
        }
        String tempCnpjSemDigito = cnpj.substring(0, INDEX_CNPJ_SEM_DIGITO);
        Integer digito1 = ValidationUtils.calculateDigit(tempCnpjSemDigito, pesoCNPJ);
        String tempCnpjComDigito1 = tempCnpjSemDigito + digito1;
        Integer digito2 = ValidationUtils.calculateDigit(tempCnpjComDigito1, pesoCNPJ);
        String tempCnpjComDigito2 = tempCnpjComDigito1 + digito2;
        return cnpj.equals(tempCnpjComDigito2);
    }
}
