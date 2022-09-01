import { Component } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { keyframes } from '@angular/animations';





let aux :any // variable auxiliar 
let aux2:any
let aux3:any
let constrain :Array<Const> =[]
let constrainarbol :Array<Const> =[]
let constraintexto :Array<any> =[]
// Que pasa con el Xor o con el Xand,no existen o si


@Component({
    selector: 'const',
    templateUrl: './const.html',
    styleUrls: ['./const.css'],
})

 export class Const  {
    type:string=""
    operands:Array<Const>=[];
    constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
    constraindataSource = new MatTreeNestedDataSource<Const>();
    
    constructor() {
    }
    hasChild = (_: number, node: Const) => !!node.operands && node.operands.length >= 0;


    CrearConstrain(lista2:any){
        constrainarbol=[]
        constraintexto=[]
        for( const[key2] of Object.entries(lista2)){
            aux2=this.CreanuevaConstrain(lista2[key2].ast)
            constrain.push(aux2)
            this.bucle(constrain)
            constrainarbol.push(lista2[key2].ast)
            constraintexto.push(lista2[key2].expr)
        }
        return [constrainarbol,constraintexto]
    }


    CreanuevaConstrain(valor:any){
        aux=new Const()
        aux.type=valor.type
        aux.operands=valor.operands
        return aux
    }
    buscar(lista:Array<Const>){
        if(lista!=undefined && lista.length>0 && lista!= null){
            lista.forEach(element => {
                this.CreanuevaConstrain(element)
                lista.push(aux)
                if(element.operands!=undefined && element.operands.length>0 && element.operands!= null){
                    this.buscar(element.operands)
                }
            });
        }
        lista.splice(0,lista.length/2)
        return lista
    }




    bucle(lista:any){
        if(lista.length!=undefined){
            lista.forEach(element => {
                if(element.operands.length!=undefined){
                element.operands.forEach(hijo => {
                    element.operands.push(this.CreanuevaConstrain(hijo))
                })
                element.operands.splice(0,element.operands.length/2)
                this.bucle(element)
            }
            });
    }
    }






    crearListaBuena(list:Array<any>){
        list.forEach(element => {
            if(element.type=='FeatureTerm'){
                element.type=element.operands[0]
                element.operands=null
            }
            else{this.crearListaBuena(element.operands)}
        });
        return list
    }
        
   
}

