import {Component,Input,Output,EventEmitter} from '@angular/core';
import { ToolsExtension } from '../../ToolsExtension/ToolsExtension'


let aux
@Component({

  selector: 'card2',
    templateUrl: './card2.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card2 {
    language  =""
    list:Array<any>=[]
    myfile_name=""
    @Input() ListLanguage:Array<string>=[]
    @Input() jsonLanguageextension:Array<ToolsExtension>=[]
    @Output() newItemEventSave= new EventEmitter<number>();
    @Output() newItemEventName = new EventEmitter<string>();

    constructor(){}
    SaveJson(lang:string){
      if(lang!="" && lang!="tree name"){
      aux=this.list.indexOf(lang)
      this.newItemEventName.emit(this.myfile_name);
      this.newItemEventSave.emit(aux);}
    }

    ListLanguageFormat(){
      this.list=[]
      this.ListLanguage.forEach(element => {
        this.jsonLanguageextension.forEach(tool => {
          if(element==tool.name){
            element=element+" (."+tool.extension+")"
            this.list.push(element)}
        });
      });
      return this.list
    }
}