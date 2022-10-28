import {Component,Input,Output,EventEmitter} from '@angular/core';


let aux:any

@Component({

  selector: 'card1',
    templateUrl: './card1.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class card1 {
  
    documents:string[]= ['GPL.xml', 'JHipster.uvl','MobileMedia.xml', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];
    myfile_name=""
    myfile:any
    @Output() newItemEventreadThis = new EventEmitter<any>(); 
    @Input() item:string ='GPL.xml';
    @Output() newItemEventreturnValues = new EventEmitter<string>();

    changeListener($event){
        if($event.target.files[0].name!=undefined){
            this.myfile_name=$event.target.files[0].name
            this.myfile=$event.target
          }
    }
    readThis(){
      if(this.myfile!=undefined && this.myfile!=null){
      this.newItemEventreadThis.emit(this.myfile);
      }
    } 

    select(event){
      if(this.documents.indexOf(event.value)!=-1){
      this.newItemEventreturnValues.emit(event.value)};
    }
}
