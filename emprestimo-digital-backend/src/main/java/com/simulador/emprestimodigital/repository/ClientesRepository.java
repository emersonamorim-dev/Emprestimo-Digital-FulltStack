package com.simulador.emprestimodigital.repository;

import com.simulador.emprestimodigital.model.Clientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
