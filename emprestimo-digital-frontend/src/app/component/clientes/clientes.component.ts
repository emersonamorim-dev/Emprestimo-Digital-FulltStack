import { Component, OnInit } from '@angular/core';

import { Cliente } from 'src/app/model/cliente';
import { ClientesService } from 'src/app/service/ClientesService';


@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[] = [];
  errorMessage: string = "";

  constructor(private clientesService: ClientesService) { }

  ngOnInit(): void {
    this.getClientes();
  }

  getClientes(): void {
    this.clientesService.getClientes().subscribe({
      next: data => {
        this.clientes = data;
        console.log(this.clientes);
      },
      error: err => {
        this.handleError(err);
      }
    })
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
