import {Component,Input,Output,EventEmitter} from '@angular/core';
import { Refactoring } from '../../refactor/refactoring';
import { Language } from '../../Language/Language';
import { Semantics} from'../../Semantics/Semantics';
let aux=0
@Component({

  selector: 'Semantics_metrics',
    templateUrl: './Semantics_metrics.html',
    styleUrls: ['../../../app.component.css' ]
  })

  export class semantics_metrics {
    columns=["name","value"]
    
    @Input() jsonsemantic:Array<Semantics>=[]



  }