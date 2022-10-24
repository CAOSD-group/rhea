import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card2',
    templateUrl: './card2.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class card2 {
    @Input() item:string ='GPL.xml';
    @Output() newItemEventreturnValues = new EventEmitter<string>();
    documents:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];


    returnValues(text:string){
      this.newItemEventreturnValues.emit(text);
  }
}