import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpErrorResponse } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators'

import { EmprestimoCalculos } from '../model/emprestimoCalcular';
import { Emprestimo } from '../model/emprestimo';


@Injectable({
  providedIn: 'root'
})
export class CalcularEmprestimoService {

  private baseURL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getEmprestimoCalculos(emprestimo: Emprestimo): Observable<EmprestimoCalculos> {
    const params = new HttpParams()
      .set("totalEmprestimo", emprestimo.totalEmprestimo)
      .set("juros", emprestimo.juros)
      .set("anos", emprestimo.anos);

    return this.http.get<EmprestimoCalculos>(`${this.baseURL}/api/emprestimo-digital/calcular-emprestimo`, { params: params })
      .pipe(catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse) {
    return throwError(() => error);
  }

}
