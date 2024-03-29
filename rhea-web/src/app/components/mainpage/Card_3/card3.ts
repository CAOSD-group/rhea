import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card3',
    templateUrl: './card3.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card3 {
    tooltip:any=""
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
  this.loglist.unshift("Redo")
  this.tooltip=""
  this.newItemEventreundo.emit(1);
  }
  Undo(){
  this.loglist.unshift("Undo")
  this.tooltip=""
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

  ToolTipText(){
    let bool_re=false
    let bool_un=false
    if(this.tooltip=="Undo"){
      bool_un=true
    }
    if(this.tooltip=="Redo"){
      bool_re=true
    }
    return [bool_re,bool_un]
  }


  }

  