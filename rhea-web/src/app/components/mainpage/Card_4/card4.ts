import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card4',
    templateUrl: './card4.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card4 {

    @Input() loglist:string[] =[]
    @Input() loghash:Array<string>=[]
    @Input() logposition:number=-1
    @Output() newItemEventreundo = new EventEmitter<number>();
    selectfirst(a:any){
      if(this.loglist.indexOf(a)==0){
      return "rgba(85, 85, 85, 0.295)"}
      else{
        return "rgba(0, 0, 0, 0)"
      }
    }
  Redo(){
    console.log(this.loghash)
    console.log(this.logposition)
  this.newItemEventreundo.emit(1);
  }
  Undo(){
  this.newItemEventreundo.emit(-1);
  }
  Disblebutton(){
    let boolredo=false
    let boolundo=false
    if(this.loghash.length-1==this.logposition){
      boolredo=true
    }
    if(this.logposition==0){
      boolundo=true
    }
    return [boolredo,boolundo]
  }
  }