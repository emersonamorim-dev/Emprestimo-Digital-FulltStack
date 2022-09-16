import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ClientesComponent } from './component/clientes/clientes.component';
import { CalcularEmprestimoComponent } from './component/calcular-emprestimo/calcular-emprestimo.component';
import { CalcularResultadoComponent } from './component/calcular-resultado/calcular-resultado.component';
import { ErrorMessageComponent } from './component/error-message/error-message.component';


@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    CalcularEmprestimoComponent,
    CalcularResultadoComponent,
    ErrorMessageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
