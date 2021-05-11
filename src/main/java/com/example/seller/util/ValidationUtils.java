package com.example.seller.util;

public final class ValidationUtils {


    private static final int QUOCIENTE = 11;
    private static final int QUOCIENTE_RESULTADO = 9;

    private ValidationUtils() {
        throw new IllegalStateException("Utility class");
    }


    public static int calculateDigit(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length(); indice > 0; indice--) {
            int digito = Integer.parseInt(str.substring(indice - 1, indice));
            soma += digito * peso[peso.length - str.length() + indice - 1];
        }
        soma = QUOCIENTE - soma % QUOCIENTE;
        return soma > QUOCIENTE_RESULTADO ? 0 : soma;
    }

    public static String padLeft(String text, char character, String regex) {
        return String.format(regex, text).replace(' ', character);
    }

}
