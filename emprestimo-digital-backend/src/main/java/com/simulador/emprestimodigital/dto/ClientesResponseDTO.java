package com.simulador.emprestimodigital.dto;

import java.util.Objects;

public class ClientesResponseDTO {

    private Long id;
    private String nome;
    private double totalEmprestimo;
    private double juros;
    private int anos;
    private double fixoPagamentoMensal;

    public ClientesResponseDTO() {
    }

    public ClientesResponseDTO(Long id, String nome, double totalEmprestimo, double juros, int anos,
            double fixoPagamentoMensal) {
        this.id = id;
        this.nome = nome;
        this.totalEmprestimo = totalEmprestimo;
        this.juros = juros;
        this.anos = anos;
        this.fixoPagamentoMensal = fixoPagamentoMensal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTotalEmprestimo() {
        return totalEmprestimo;
    }

    public void setTotalEmprestimo(double totalEmprestimo) {
        this.totalEmprestimo = totalEmprestimo;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public int getAnos() {
        return this.anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public double getFixoPagamentoMensal() {
        return fixoPagamentoMensal;
    }

    public void setFixoPagamentoMensal(double fixoPagamentoMensal) {
        this.fixoPagamentoMensal = fixoPagamentoMensal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ClientesResponseDTO that = (ClientesResponseDTO) o;
        return Double.compare(that.totalEmprestimo,
                totalEmprestimo) == 0
                && Double.compare(that.juros, juros) == 0
                && anos == that.anos
                && Double.compare(that.fixoPagamentoMensal,
                        fixoPagamentoMensal) == 0
                && id.equals(that.id) && nome.equals(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, totalEmprestimo, juros, anos, fixoPagamentoMensal);
    }
}