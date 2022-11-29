import { Component } from '@angular/core'


let aux:any
let listsemantics:Array<Semantics>=[]
@Component({
    selector: 'Semantics',
    templateUrl: './Semantics.html',
})

export class Semantics  {
    name=""
    value:any=0
    description=""


    CreateSemantics(list:Array<any>){
        listsemantics=[]
        list.forEach(element => {
            aux=new Semantics
            aux.name=element.name
            aux.description=element.description
            aux.value=element.value
            listsemantics.push(aux)
        });
        return listsemantics
    }
}