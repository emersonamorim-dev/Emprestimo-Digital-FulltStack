package com.simulador.emprestimodigital.utils;

import org.springframework.stereotype.Component;

@Component("calcularJuros")
public class CalcularJuros {

    public double calcularPagamentoMensal(double totalEmprestimo, double juros, int anos) {
        double jurosMensal = juros / (12 * 100);
        int numeroPagamentos = anos * 12;

        return (totalEmprestimo * jurosMensal * power(1 + jurosMensal,
                numeroPagamentos))
                / (power(1 + jurosMensal, numeroPagamentos) - 1);
    }

    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        double result = power(base, exponent / 2);
        result = result * result;
        if (exponent % 2 != 0) {
            result = result * base;
        }
        return result;
    }

}