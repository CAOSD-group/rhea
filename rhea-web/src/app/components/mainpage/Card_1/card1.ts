import {Component,Input,Output,EventEmitter} from '@angular/core';


let aux:any

@Component({

  selector: 'card1',
    templateUrl: './card1.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class card1 {
  
    @Input() documents:string[]= [];
    myfile_name=""
    myfile:any
    @Output() newItemEventreadThis = new EventEmitter<any>(); 
    @Input() item:string ='GPL.xml';
    @Output() newItemEventreturnValues = new EventEmitter<string>();

    changeListener($event){
        if($event.target.files[0].name!=undefined){
            this.myfile_name=$event.target.files[0].name
            this.myfile=$event.target
            aux=1
          }
    }
    readThis(){
      if(this.myfile!=undefined && this.myfile!=null && aux==1){
      this.newItemEventreadThis.emit(this.myfile);
      }
      if(aux==0){
      this.newItemEventreturnValues.emit(this.myfile_name);
      }
    } 

    select(event){
      if(this.documents.indexOf(event.value)!=-1){
        aux=0
        this.myfile_name=event.value};
    }
}
