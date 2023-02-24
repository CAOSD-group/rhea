import { Component } from '@angular/core'
import { elementAt } from 'rxjs'

let ListOfRefactors:Array<Refactoring>=[]
let aux:any
@Component({
    selector: 'refactor',
    templateUrl: './refactor.html',
})
export class Refactoring  {
    name:string=""
    id:string=""
    description:string=""
    type:string=""
    instances:Array<string> =[]
    applicable:boolean=true;
    constructor(){}

    Delete(){
        this.name="";
        this.id="";
        this.description="";
        this.type="";
        this.instances=[];
        this.applicable=false;
    }
    

    DeleteList(){ListOfRefactors=[]}

    Create(object:any){
        object.forEach(element => {
            aux=new Refactoring()
        if(element.name!=undefined){aux.name=element.name}
        if(element.id!=undefined){aux.id=element.id}
        if(element.description!=undefined){aux.description=element.description}
        if(element.type!=undefined){aux.type=element.type}
        if(element.instances!=undefined){aux.instances=element.instances}
        if(element.applicable!=undefined){this.applicable=element.applicable}
        ListOfRefactors.push(aux)
        });
        
        return ListOfRefactors
    }
}