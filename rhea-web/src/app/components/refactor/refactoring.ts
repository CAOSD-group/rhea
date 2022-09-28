import { Component } from '@angular/core'
@Component({
    selector: 'refactor',
    templateUrl: './refactor.html',
})
export class Refactoring  {
    name:string=""
    id:string=""
    description:string=""
    create(object:any){
        if(object.name!=undefined){this.name=object.name}
        if(object.id!=undefined){this.id=object.id}
        if(object.description!=undefined){this.description=object.description}
        return this
    }
}