import {Component,Input,Output,EventEmitter} from '@angular/core';



let aux:any
let list:Array<any>=[]
@Component({

  selector: 'ToolsExtension',
    templateUrl: './ToolsExtension.html',
  })
  
  export class ToolsExtension {
    name =""
    extension=""

    constructor(){}

    CreateTools(Object:any){
        Object.forEach(element => {
            aux=new ToolsExtension()
            aux.name=element.name
            aux.extension=element.extension
            list.push(aux)
        });
        return list
    }
}