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
    @Input() ListOfRefactorsInfo :Array<Refactoring>=[];
    @Input() ListLanguage:Array<string>=[]
    @Input() jsonlanguage:Array<Language>=[]
    @Output() newItemEventrefactoingall= new EventEmitter<Refactoring>();
    @Output() newItemEventdownload= new EventEmitter<string>();
    declare mychip:Language

    Refactor(){
      aux=-1
      if(this.mychip.refactorings.length==0){
        console.log("not a refactoring")
      }
      else{
        this.ListOfRefactorsInfo.forEach(element => {
          if(element.id==this.mychip.refactorings[0]){
          aux=this.ListOfRefactorsInfo.indexOf(element)}
        });
        if(aux!=-1){
      this.newItemEventrefactoingall.emit(this.ListOfRefactorsInfo[aux])}
    }
    }
    download(chip:string){
      let aux =true
      if(chip!="languages constructor" && chip!="Value"){
        this.jsonlanguage.forEach(element => {
          if(element.value!=0&&element.tools.indexOf(chip)==-1){
            aux =false
          }
        })
        if(aux){this.newItemEventdownload.emit(chip)}
        else{console.log("not a valid language")
        }
        }
    }
    columns(){
      let columns=["languages constructor","Value"]
      this.ListLanguage.forEach(element => {
        columns.push(element)
      });
      return columns
    }
    columnsclass(chip:string){
      if(chip=="languages constructor"){
        return "colum-header-lang"
      }
      else{
      return "colum-header"}
    }
    hiddencolum(len:Language){
      if(len.value==0){
        return true
      }
      else{
        return false
      }
      
    }
    IsValidLenguage(len:Language,chip:string){
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