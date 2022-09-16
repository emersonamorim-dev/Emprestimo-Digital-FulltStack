import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ClientesComponent } from './component/clientes/clientes.component';
import { CalcularEmprestimoComponent } from './component/calcular-emprestimo/calcular-emprestimo.component';


const routes: Routes = [
  { path: 'clientes', component: ClientesComponent },
  { path: 'calcularEmprestimo', component: CalcularEmprestimoComponent },
  { path: '**', redirectTo: '/clientes' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
