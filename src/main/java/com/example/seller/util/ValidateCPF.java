package com.example.seller.util;

public final class ValidateCPF {

    private static final int[] PESO_CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int INDEX_CPF_SEM_DIGITO = 9;
    private static final int RADIX_PAD_LEFT = 10;
    private static final int TAMANHO_CPF = 11;

    private ValidateCPF() {
        throw new IllegalStateException("Classe Util");
    }

    public static boolean isValidCPF(String cpf) {
        if (cpf == null) {
            return false;
        }
        cpf = cpf.trim().replaceAll("\\D", "");
        if ((cpf.length() != TAMANHO_CPF)) {
            return false;
        }
        // cpf = cpf.trim().replace(".", "").replace("-", "");
        for (int j = 0; j < RADIX_PAD_LEFT; j++) {
            if (ValidationUtils.padLeft(Integer.toString(j), Character.forDigit(j, RADIX_PAD_LEFT), "%11s").equals(cpf)) {
                return false;
            }
        }
        String tempCpfSemDigito = cpf.substring(0, INDEX_CPF_SEM_DIGITO);
        Integer digito1 = ValidationUtils.calculateDigit(tempCpfSemDigito, PESO_CPF);
        String tempCpfComDigito1 = tempCpfSemDigito + digito1;
        Integer digito2 = ValidationUtils.calculateDigit(tempCpfComDigito1, PESO_CPF);
        String tempCpfComDigito2 = tempCpfComDigito1 + digito2;
        return cpf.equals(tempCpfComDigito2);
    }
}
