import {Component,Input,Output,EventEmitter} from '@angular/core';
import { Refactoring } from '../../refactor/refactoring';
import { Language } from '../../Language/Language';
import { elementAt } from 'rxjs';

@Component({

  selector: 'Information',
    templateUrl: './Information.html',
    styleUrls: ['../../../app.component.css' ]
  })

  export class Information {
    @Input() ListOfRefactorsInfo :Array<Refactoring>=[];
    @Input() ListLanguage:Array<string>=[]
    @Input() jsonlanguage:Array<Language>=[]
    mychip:any=""

    Refactor(){
      console.log(this.mychip)
    }
    columns(){
      let columns=["languages constructor","Value"]
      this.ListLanguage.forEach(element => {
        columns.push(element)
      });
      return columns
    }
    IsValidLenguage(len:any,chip:string){
      let icon="cancel"
      let text=true
      let symbol=false
      let button=true
      let menu=true
      if(chip=="languages constructor"){
        text=false
        symbol=true
        icon=len.name
        menu=false
      }
      if(chip=="Value"){
        text=false
        symbol=true
        icon=len.value.toString()
      }
      if(chip!="languages constructor"&&chip!="Value" ){
      if(len.tools.indexOf(chip)!=-1){
        icon="check_circle"
      }
      else{
        if(len.refactorings.length>0){
          icon="remove_circle"
        }
      }}
    
      return [icon,symbol,text,button,menu]
    }
    
  }