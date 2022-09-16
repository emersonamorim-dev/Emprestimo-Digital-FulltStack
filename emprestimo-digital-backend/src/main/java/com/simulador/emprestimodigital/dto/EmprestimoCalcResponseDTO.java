package com.simulador.emprestimodigital.dto;

import java.util.Objects;

public class EmprestimoCalcResponseDTO {

    double pagamentoMensal;
    double totalPagamento;
    double totalJuros;
    int pagamentos;

    public EmprestimoCalcResponseDTO(double pagamentoMensal, double totalPagamento, double totalJuros,
            int pagamentos) {
        this.pagamentoMensal = pagamentoMensal;
        this.totalPagamento = totalPagamento;
        this.totalJuros = totalJuros;
        this.pagamentos = pagamentos;

    }

    public double getPagamentoMensal() {
        return pagamentoMensal;
    }

    public void setPagamentoMensal(double pagamentoMensal) {
        this.pagamentoMensal = pagamentoMensal;
    }

    public double getTotalPagamento() {
        return totalPagamento;
    }

    public void setTotalPagamento(double totalPagamento) {
        this.totalPagamento = totalPagamento;
    }

    public double getTotalJuros() {
        return totalJuros;
    }

    public void setTotalJuros(double totalJuros) {
        this.totalJuros = totalJuros;
    }

    public int getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(int pagamentos) {
        this.pagamentos = pagamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        EmprestimoCalcResponseDTO that = (EmprestimoCalcResponseDTO) o;
        return Double.compare(that.pagamentoMensal, pagamentoMensal) == 0
                && Double.compare(that.totalPagamento, totalPagamento) == 0
                && Double.compare(that.totalJuros, totalJuros) == 0 && pagamentos == that.pagamentos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pagamentoMensal, totalPagamento, totalJuros, pagamentos);
    }
}
