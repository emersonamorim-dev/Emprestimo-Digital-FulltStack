import { Component, OnInit, Input } from '@angular/core';

import { EmprestimoCalculos } from 'src/app/model/emprestimoCalcular';


@Component({
  selector: 'app-calcular-resultado',
  templateUrl: './calcular-resultado.component.html',
  styleUrls: ['./calcular-resultado.component.css']
})
export class CalcularResultadoComponent implements OnInit {

  @Input() emprestimoCalcular: EmprestimoCalculos | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
