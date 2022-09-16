package com.simulador.emprestimodigital.service;

import com.simulador.emprestimodigital.dto.EmprestimoCalcResponseDTO;
import com.simulador.emprestimodigital.utils.CalcularJuros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcularEmprestimoService {

    private static CalcularJuros calcularJuros;

    @Autowired
    public CalcularEmprestimoService(CalcularJuros calcularJuros) {
        CalcularEmprestimoService.calcularJuros = calcularJuros;
    }

    public EmprestimoCalcResponseDTO getEmprestimoCalculos(double totalEmprestimo, double juros, int anos) {
        double pagamentoMensal = calcularJuros.calcularPagamentoMensal(totalEmprestimo, juros, anos);
        int pagamentos = anos * 12;
        double totalPagamento = pagamentoMensal * pagamentos;
        double totalJuros = totalPagamento - totalEmprestimo;

        return new EmprestimoCalcResponseDTO(pagamentoMensal, totalPagamento, totalJuros, pagamentos);
    }
}
