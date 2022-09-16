import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'

import { Cliente } from '../model/cliente';


@Injectable({
  providedIn: 'root'
})
export class ClientesService {

  private baseURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.baseURL}/api/emprestimo-digital/clientes`)
      .pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse) {
    return throwError(() => error);
  }

}
