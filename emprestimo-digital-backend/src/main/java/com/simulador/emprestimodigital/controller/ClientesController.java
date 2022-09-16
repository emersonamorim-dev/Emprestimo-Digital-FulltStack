package com.simulador.emprestimodigital.controller;

import com.simulador.emprestimodigital.dto.ClientesRequestDTO;
import com.simulador.emprestimodigital.dto.ClientesResponseDTO;
import com.simulador.emprestimodigital.dto.EmprestimoCalcResponseDTO;
import com.simulador.emprestimodigital.service.ClientesService;
import com.simulador.emprestimodigital.service.CalcularEmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@Validated
@RestController
@RequestMapping("/api/emprestimo-digital")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private CalcularEmprestimoService calcularEmprestimoService;

    @GetMapping("/clientes")
    public ResponseEntity<List<ClientesResponseDTO>> getAllClientes() {
        List<ClientesResponseDTO> clientes = clientesService.getAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClientesResponseDTO> addClientes(@Valid @RequestBody ClientesRequestDTO clientesRequestDTO) {
        ClientesResponseDTO newClientes = clientesService.addClientes(clientesRequestDTO);
        return new ResponseEntity<>(newClientes, HttpStatus.OK);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<ClientesResponseDTO> updateClientes(
            @PathVariable("id") Long id,
            @Valid @RequestBody ClientesRequestDTO clientesRequestDTO) {
        ClientesResponseDTO updatedClientes = clientesService.updateClientes(clientesRequestDTO, id);
        return new ResponseEntity<>(updatedClientes, HttpStatus.OK);
    }

    @GetMapping("/calcular-emprestimo")
    public ResponseEntity<EmprestimoCalcResponseDTO> getEmprestimoCalculos(
            @RequestParam @Min(0) double totalEmprestimo,
            @RequestParam @Min(0) double juros,
            @RequestParam @Min(0) int anos) {

        EmprestimoCalcResponseDTO emprestimoCalcular = calcularEmprestimoService.getEmprestimoCalculos(totalEmprestimo,
                juros,
                anos);
        return new ResponseEntity<>(emprestimoCalcular, HttpStatus.OK);
    }

}
