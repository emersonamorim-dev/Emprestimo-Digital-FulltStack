package com.simulador.emprestimodigital.model;

import javax.persistence.*;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double totalEmprestimo;

    @Column(nullable = false)
    private double juros;

    @Column(nullable = false)
    private int anos;

    public Clientes() {
    }

    public Clientes(String nome, double totalEmprestimo, double juros, int anos) {
        this.nome = nome;
        this.totalEmprestimo = totalEmprestimo;
        this.juros = juros;
        this.anos = anos;
    }

    public Clientes(Long id, String nome, double totalEmprestimo, double juros, int anos) {
        this.id = id;
        this.nome = nome;
        this.totalEmprestimo = totalEmprestimo;
        this.juros = juros;
        this.anos = anos;
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
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", totalEmprestimo=" + totalEmprestimo +
                ", juros=" + juros +
                ", Anos=" + anos +
                '}';
    }

}