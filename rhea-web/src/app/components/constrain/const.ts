import { Component } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { keyframes } from '@angular/animations';





let aux :any // variable auxiliar 
let aux2:any
let aux3:any
let aux4:any

let constrainarbol :Array<Const> =[]
let constraintexto :Array<any> =[]
let constrainnombre :Array<any> =[]

@Component({
    selector: 'const',
    templateUrl: './const.html',
})

 export class Const  {
    type:string=""
    operands:Array<any>=[];
    
    
    constructor() {}
  


    CrearConstrain(lista2:any){
        constrainarbol=[]
        constraintexto=[]
        constrainnombre=[]
        for( const[key2] of Object.entries(lista2)){
            aux2=this.CreanuevaConstrain(lista2[key2].ast)
            constrainarbol.push(lista2[key2].ast)
            constraintexto.push(lista2[key2].expr)
            constrainnombre.push(lista2[key2].name)
            
        }
        return [constrainarbol,constraintexto,constrainnombre]
    }


    CreanuevaConstrain(valor:any){
        if(valor.type!=undefined){
        aux=new Const()
        aux.type=valor.type
        aux.operands=valor.operands
        }
        else{aux=valor}
        return aux
    }
    buscar(lista:Array<any>){
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

    crearListaescritura(list:Array<any>,valores:Array<string>){
        if(list!=undefined){
        list.forEach(element => {
            console.log(element)
            if(valores.indexOf(element.type)==-1){
            element.operands=[]
            element.operands.push(element.type)
            element.type='FeatureTerm'
            console.log(element)
            

            }
            else{this.crearListaescritura(element.operands,valores)}
        });}
        else {list=[new Const]}
        return list
    }

    listaConstrains(lista:Array<any>){
        aux=0
        aux2=0
        aux3=true
        aux4=0
        console.log(lista)
        
        while(aux<lista.length){
            console.log(lista[aux])
            if(lista[aux].operands.length==1){ 
                console.log("vengo por negativo ")
                console.log(lista[aux])
                lista[aux].operands.push(lista[aux+1]);
                lista[aux].operands.splice(0,1);
                aux++}
            if(lista[aux].operands.length>=2){
                console.log("vengo por logic")
                console.log(lista[aux])
                lista[aux].operands.push(lista[aux+1]);
                aux4=aux+1
                aux2=aux+1
                while(aux3){
                    alert("comprobar que pasa cuando esta mal y se podria introducir como bien")
                    // si se meten multiples features con un solo logic , se meteran los dos primeros en vez de saltar error
                    aux4=aux4+lista[aux2].operands.length
                    aux2++
                    if(aux2>aux4){
                        aux3=false
                    }
                }
                aux3=true
                lista[aux].operands.push(lista[aux2])
                lista[aux].operands.splice(0,2);
                aux++}

                if(lista[aux].operands.length!=undefined && lista[aux].operands.length==0){
                    console.log("vengo por feature")
                    console.log(lista[aux])
                    aux++
                }
        }
        console.log(lista[0])
        return lista[0]
    }
  
        
   
}

