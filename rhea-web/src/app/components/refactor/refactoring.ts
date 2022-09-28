import { Component } from '@angular/core'
import { elementAt } from 'rxjs'

let ListOfRefactors:Array<Refactoring>=[]

@Component({
    selector: 'refactor',
    templateUrl: './refactor.html',
})
export class Refactoring  {
    name:string=""
    id:string=""
    description:string=""

    Delete(){
        this.name="";
        this.id="";
        this.description="";
    }

    DeleteList(){ListOfRefactors=[]}

    Create(object:any){
        console.log(object)
        object.forEach(element => {
            console.log(element)
        if(element.name!=undefined){this.name=element.name}
        if(element.id!=undefined){this.id=element.id}
        if(element.description!=undefined){this.description=element.description}
        ListOfRefactors.push(this)
        });
        
        return ListOfRefactors
    }
}