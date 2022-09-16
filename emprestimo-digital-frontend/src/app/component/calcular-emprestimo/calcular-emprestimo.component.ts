import { Component, OnInit } from '@angular/core';

import { Emprestimo } from 'src/app/model/emprestimo';
import { EmprestimoCalculos } from 'src/app/model/emprestimoCalcular';
import { CalcularEmprestimoService } from 'src/app/service/calcular-emprestimo.service';


@Component({
  selector: 'app-calcular-emprestimo',
  templateUrl: './calcular-emprestimo.component.html',
  styleUrls: ['./calcular-emprestimo.component.css']
})
export class CalcularEmprestimoComponent implements OnInit {

  submitted = false;
  emprestimo = new Emprestimo();
  emprestimoCalcular: EmprestimoCalculos | undefined;
  errorMessage: string = "";

  constructor(private CalcularEmprestimoService: CalcularEmprestimoService) { }

  ngOnInit() {
  }

  onSubmit() {
    console.log(this.emprestimo);
    this.getCalcular();
  }

  getCalcular(): void {
    this.CalcularEmprestimoService.getEmprestimoCalculos(this.emprestimo).subscribe({
      next: data => {
        this.submitted = true;
        this.emprestimoCalcular = data;
        console.log(this.emprestimoCalcular);
      },
      error: err => {
        this.handleError(err);
      }
    });
  }

  handleError(err: any): void {
    if (err.status === 0) {
      this.showErrorMessage("Status: 0, A solicitação não foi bem-sucedida");
    }
    else {
      this.showErrorMessage(err.error.message);
    }
    console.log(err);
  }

  showErrorMessage(errorMessage: string): void {
    this.errorMessage = errorMessage;
    setTimeout(() => {
      this.errorMessage = "";
    }, 5000);
  }

}
