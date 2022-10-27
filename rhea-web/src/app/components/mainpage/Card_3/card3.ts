import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card3',
    templateUrl: './card3.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card3 {
    language  =""
    @Input() ListLanguage:Array<string>=[]
    @Output() newItemEventSave= new EventEmitter<string>();
    @Output() newItemEventSaveUVL = new EventEmitter<string>();


    SaveJson(lang:string){
      if(this.ListLanguage.indexOf(lang)!=-1){
        console.log(lang)
      this.newItemEventSave.emit(lang);}
    }
}