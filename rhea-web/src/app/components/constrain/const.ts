import { Component } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { keyframes } from '@angular/animations';





let aux :any // variable auxiliar 
let aux2:any
let constrain :Array<Const> =[]
let constrain2 :Array<Const> =[]
let selecionado: Const
// Que pasa con el Xor o con el Xand,no existen o si


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
        constrain=[]
        for( const[key] of Object.entries(lista)){
            constrain.push(lista[key])
        }
        this.crearListaBuena(constrain)
        return constrain
    }
    CrearConstrain2(lista2:any){
        constrain2=[]
        for( const[key2] of Object.entries(lista2)){
            constrain2.push(lista2[key2])
        }
        return constrain2
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