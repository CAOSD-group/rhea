import { Component } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { keyframes } from '@angular/animations';





let aux :any // variable auxiliar 
let aux2:any
let constrain :Array<Const> =[]
let lista :Array<Const> =[]
let selecionado: Const




@Component({
    selector: 'const',
    templateUrl: './const.html',
    styleUrls: ['./const.css'],
})

 export class Const  {
    type:any;
    operands:Array<Const>=[];
    feature:Array<Featureobjetc>=[];
    consoperands:Array<Const> =[];
    constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.consoperands);
    constraindataSource = new MatTreeNestedDataSource<Const>();
    
    constructor() {
    }
    hasChild = (_: number, node: Const) => !!node.consoperands && node.consoperands.length >= 0;

    CrearConstrain(lista:any){
        for( const[key] of Object.entries(lista)){
            constrain.push(lista[key])
        }
        this.crearListaBuena(constrain)
        return constrain
    }
    crearListaBuena(list:Array<any>){
        list.forEach(element => {
            if(element.type=='FeatureTerm'){
                element.type=element.operands[0]
                element.operands=null
            }
            else{this.crearListaBuena(element.operands)}
        });
    }
}


class Featureobjetc{
    constructor(){

    }
}
class advanceConst{
    operand1:any;
    operand2:any;
    constructor(){
        this.operand1=null;
        this.operand2=null;
    }
}