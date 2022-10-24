import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card3',
    templateUrl: './card3.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card3 {
    @Output() newItemEventSaveJson = new EventEmitter<string>();
    @Output() newItemEventSaveUVL = new EventEmitter<string>();


    SaveJson(){
      this.newItemEventSaveJson.emit();
    }
    SaveUVL(){
      this.newItemEventSaveUVL.emit();
    }
}