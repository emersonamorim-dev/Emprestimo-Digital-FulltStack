package com.simulador.emprestimodigital.service;

import com.simulador.emprestimodigital.dto.ClientesRequestDTO;
import com.simulador.emprestimodigital.dto.ClientesResponseDTO;
import com.simulador.emprestimodigital.model.Clientes;
import com.simulador.emprestimodigital.repository.ClientesRepository;
import com.simulador.emprestimodigital.utils.CalcularJuros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesService {

    private final ClientesRepository clientesRepository;
    private final CalcularJuros calcularJuros;

    @Autowired
    public ClientesService(ClientesRepository clientesRepository, CalcularJuros calcularJuros) {
        this.clientesRepository = clientesRepository;
        this.calcularJuros = calcularJuros;
    }

    public List<ClientesResponseDTO> getAllClientes() {
        List<Clientes> clientes = clientesRepository.findAll();
        return createClientesResponseDTOList(clientes);
    }

    public ClientesResponseDTO addClientes(ClientesRequestDTO clientesRequestDTO) {
        Clientes clientes = new Clientes(
                clientesRequestDTO.getNome(),
                clientesRequestDTO.getTotalEmprestimo(),
                clientesRequestDTO.getJuros(),
                clientesRequestDTO.getAnos());
        clientes = clientesRepository.save(clientes);
        return createClientesResponseDTO(clientes);
    }

    public ClientesResponseDTO updateClientes(ClientesRequestDTO clientesRequestDTO, Long id) {
        Clientes clientes = new Clientes(
                id,
                clientesRequestDTO.getNome(),
                clientesRequestDTO.getTotalEmprestimo(),
                clientesRequestDTO.getJuros(),
                clientesRequestDTO.getAnos());
        clientes = clientesRepository.save(clientes);
        return createClientesResponseDTO(clientes);
    }

    public void deleteClientes(Long id) {
        clientesRepository.deleteById(id);
    }

    private List<ClientesResponseDTO> createClientesResponseDTOList(List<Clientes> clientes) {
        return clientes.stream()
                .map(this::createClientesResponseDTO)
                .collect(Collectors.toList());
    }

    private ClientesResponseDTO createClientesResponseDTO(Clientes clientes) {
        double fixoPagamentoMensal = calcularJuros.calcularPagamentoMensal(
                clientes.getTotalEmprestimo(),
                clientes.getJuros(),
                clientes.getAnos());

        return new ClientesResponseDTO(
                clientes.getId(),
                clientes.getNome(),
                clientes.getTotalEmprestimo(),
                clientes.getJuros(),
                clientes.getAnos(),
                fixoPagamentoMensal);
    }

}
