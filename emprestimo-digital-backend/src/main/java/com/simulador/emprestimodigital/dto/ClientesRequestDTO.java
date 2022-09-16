package com.simulador.emprestimodigital.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class ClientesRequestDTO {

    @NotNull
    @Size(min = 3, max = 30, message = "O nome deve ter entre 3 e 30 caracteres")
    private String nome;

    @NotNull
    @Positive(message = "O empréstimo total deve ser positivo")
    private double totalEmprestimo;

    @NotNull
    @Positive(message = "Os juros devem ser positivos")
    private double juros;

    @NotNull
    @Positive(message = "O prazo devem ser positivos")
    private int anos;

    public ClientesRequestDTO() {
    }

    public ClientesRequestDTO(int Id, String nome, double totalEmprestimo, double juros, int anos) {
        this.nome = nome;
        this.totalEmprestimo = totalEmprestimo;
        this.juros = juros;
        this.anos = anos;
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
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

}
