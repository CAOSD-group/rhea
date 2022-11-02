import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card4',
    templateUrl: './card4.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card4 {

    @Input() loglist:string[] =[]


}