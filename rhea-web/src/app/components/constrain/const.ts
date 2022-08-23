import { Component } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';





let aux :any // variable auxiliar 
let aux2:any
let constrain :Array<Const> =[]



@Component({
    selector: 'const',
    templateUrl: './const.html',
    styleUrls: ['./const.css'],
})

 export class Const  {
    operands:Array<Const> =[];
    constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
    constraindataSource = new MatTreeNestedDataSource<Const>();
    
    constructor() {
       
    }
    hasChild = (_: number, node: Const) => !!node.operands && node.operands.length >= 0;

    CrearConstrain(lista:any){
        //lista.forEach(element => {constrain.push(element)});
        console.log(constrain)
        console.log(lista.CTC1)
        return constrain

    }
}