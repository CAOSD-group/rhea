import {Component,Input,Output,EventEmitter} from '@angular/core';
import { Refactoring } from '../../refactor/refactoring';
import { Language } from '../../Language/Language';
import { elementAt } from 'rxjs';

let aux=0
@Component({

  selector: 'Information',
    templateUrl: './Information.html',
    styleUrls: ['../../../app.component.css' ]
  })

  export class Information {
    tooltip:any=""
    @Input() ListOfRefactorsInfo :Array<Refactoring>=[];
    @Input() ListLanguage:Array<string>=[]
    @Input() jsonlanguage:Array<Language>=[]
    @Input() loadingmodal=false
    @Output() newItemEventrefactoingall= new EventEmitter<Refactoring>();
    declare mychip:Language

    Refactor(){
      aux=-1
      this.loadingmodal=false
        this.ListOfRefactorsInfo.forEach(element => {
        if(element.name==this.mychip.refactorings){
        aux=this.ListOfRefactorsInfo.indexOf(element)}
        });
        if(aux!=-1){
      this.newItemEventrefactoingall.emit(this.ListOfRefactorsInfo[aux])}
    }
    columns(){
      let columns=["Language constructs","#"]
      this.ListLanguage.forEach(element => {
        columns.push(element)
      });
      return columns
    }
    columnsclass(chip:string){
      if(chip=="Language constructs" || chip=="#"){
        return "colum-header-lang"
      }
      if(chip.length>6){
        return "colum-header-longtext"
      }
      else{
      return "colum-header"}
    }
    hiddencolum(len:Language){
      if(len.value==-1){
        return true
      }
      else{
        return false
      }
      
    }
    IsValidLenguage(len:Language,chip:string){
      let icon="cancel"
      let symbol=false
      let menu=true
      if(chip=="Language constructs"){
        symbol=true
        icon=len.name
        if(len.refactorings.length!=0&&len.value!=0){
        menu=false}
      }
      if(chip=="#"){
        symbol=true
        icon=len.value.toString()
      }
      if(chip!="Language constructs"&&chip!="#" ){
      if(len.tools.indexOf(chip)!=-1){
        icon="check_circle"
      }
      else{
        if(len.value==0){
          icon="remove_circle_valid"
        }
        else{
          if(len.refactorings.length>0){
            icon="remove_circle"
          }
        }
      }}
    
      return [icon,symbol,menu]
    }

    ToolTipText(a:any,chip:string){
      if(a==this.tooltip && chip=="Language constructs"){
        return[true,this.tooltip.id]
      }
      else{
      return [false,""]}
    }
    
  }