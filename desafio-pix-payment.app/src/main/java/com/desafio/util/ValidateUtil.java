package com.desafio.util;

import com.desafio.model.enums.FrequencyEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe Util que auxilia nas validações necessarios para o pagamento
 */
public class ValidateUtil {

    public static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";

    /**
     * Valida se o valor da recorrencia é maior que o minimo permitido
     * @param frequencyEnum
     * @param value
     * @return
     */
    public static boolean isValidRecurrenceValue(FrequencyEnum frequencyEnum, BigDecimal value){
        return value.compareTo(frequencyEnum.getMinimumValue()) > 0;
    }

    /**
     * Valida se o valor de meses da frequencia é maior que o maximo permitido
     * @param frequencyEnum
     * @param initialDate
     * @param finalDate
     * @return
     */
    public static boolean isValidRecurrenceFrequency(FrequencyEnum frequencyEnum, LocalDate initialDate, LocalDate finalDate) {
        return frequencyEnum.getMaximumPeriod().longValue() > initialDate.until(finalDate, ChronoUnit.MONTHS);
    }

    /**
     * Valida se a string é um string
     * @param string
     * @return
     */
    public static boolean isValidEmailAddress(String string) {
        Pattern p = Pattern.compile(EMAIL_PATTERN);
        Matcher m = p.matcher(string);
        return m.matches();
    }

    /**
     * Valida se a string é um cpf
     * @param string
     * @return
     */
    public static boolean isCPF(String string) {

        if (string.equals("00000000000") ||
                string.equals("11111111111") ||
                string.equals("22222222222") || string.equals("33333333333") ||
                string.equals("44444444444") || string.equals("55555555555") ||
                string.equals("66666666666") || string.equals("77777777777") ||
                string.equals("88888888888") || string.equals("99999999999") ||
                (string.length() != 11))
            return(false);

        char penultimoDigito, ultimoDigito;
        int soma, resto, numero, peso;

        try {
            // Calculo do 1o. Digito Verificador
            soma = 0;
            peso = 10;
            for (int i=0; i<9; i++) {
                // converte o i-esimo caractere do string em um numero:
                numero = (string.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                penultimoDigito = '0';
            else penultimoDigito = (char)(resto + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            soma = 0;
            peso = 11;
            for(int i=0; i<10; i++) {
                numero = (string.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }

            resto = 11 - (soma % 11);
            if ((resto == 10) || (resto == 11))
                ultimoDigito = '0';
            else ultimoDigito = (char)(resto + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((penultimoDigito == string.charAt(9)) && (ultimoDigito == string.charAt(10)))
                return(true);
            else return(false);
        } catch (InputMismatchException erro) {
            return(false);
        }
    }

}
