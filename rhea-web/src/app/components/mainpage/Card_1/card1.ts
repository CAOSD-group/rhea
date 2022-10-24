import {Component,Input,Output,EventEmitter} from '@angular/core';


let aux:any

@Component({

  selector: 'card1',
    templateUrl: './card1.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class card1 {
    myfile_name=""
    myfile:any
    @Output() newItemEventreadThis = new EventEmitter<any>();
    changeListener($event){
        if($event.target.files[0].name!=undefined){
            this.myfile_name=$event.target.files[0].name
            this.myfile=$event.target}
    }
    readThis(){
      if(this.myfile!=undefined){
      this.newItemEventreadThis.emit(this.myfile);
    }
  }
}
