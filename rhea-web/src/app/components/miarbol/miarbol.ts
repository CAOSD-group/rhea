import {SelectionModel} from '@angular/cdk/collections';
import {FlatTreeControl} from '@angular/cdk/tree';
import {Component, Injectable} from '@angular/core';
import {MatTreeFlatDataSource, MatTreeFlattener} from '@angular/material/tree';
import {BehaviorSubject} from 'rxjs';
import {ComponentFixture, TestBed} from '@angular/core/testing';
import {TestbedHarnessEnvironment} from '@angular/cdk/testing/testbed';
import {MatMenuHarness} from '@angular/material/menu/testing';
import {HarnessLoader} from '@angular/cdk/testing';
import {MatMenuModule} from '@angular/material/menu';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';



    let ltexto ="";
    let laux =0;
    let laux2=0;
   // let lposicion =0;
    let lmarcado =false;
    var seleccionado :Rama 
    var lista: Array<Rama> =[];

    var TREE_DATA = {
     Groceries: {
       'Almond Meal flour': null,
       'Organic eggs': null,
       'Protein Powder': null,
        Fruits: {
            Apple: null,
            Berries: ['Blueberry', 'Raspberry'],
            Orange: null,
         },
        },
    };


@Component({
    selector: 'miarbol',
    templateUrl: './miarbol.html',
    styleUrls: ['./miarbol.css'],
})

export class Rama{
    aux =laux;
    aux2=laux2;
    nombre = "";
    identificador =0 ;
    marcado= lmarcado;
    indeterminado=false;
    Hijos: Array<Rama> =[] ;
    Padre: Array<Rama> =[] ;
 

    constructor() {
        this.nombre = ltexto;
        this.identificador =lista?.length || 0;
        this.Hijos = new Array<Rama>() ;
        this.Padre = new Array<Rama>();
        this.marcado= lmarcado;
        this.indeterminado=false;
    }
  

    borrar() {  //borra todos los hijos
        this.Hijos.forEach(element => {
            element.borrar;
        });
        this.nombre = "";
        lista.splice(this.identificador,1); //elimina el elemento cuya posicion coincide con la del identificador
        this.identificador =-1 ;
        this.Hijos.splice(0);
        this.Padre.splice(0);
        this.marcado= false;
        this.indeterminado=false;
    }

    sumar(input:number,input2:number){
            if(Number(input.toString())+ Number(input2.toString())){
            alert(Number(input.toString())+ Number(input2.toString()))
            console.log("se ha sumado "+ input.toString() +" a " +input2.toString());
        } else{
        alert("se ha intentado sumar algo que no son numeros")}
    }
    actualizarvalores(elemento:string){
        ltexto=elemento;
        laux=this.aux
        laux2=this.aux2;
        lmarcado=this.marcado;
        this.nombre=ltexto;
    }
    crearValor(){
        seleccionado=new Rama();
        if(seleccionado!=undefined){
        laux=lista.push(seleccionado);}
    }

    escribirvalores(){
        alert("valores actuales:"+this.nombre+" ,"+this.identificador+" ,"+this.marcado+" ,"+this.indeterminado+" ,"+this.Hijos+" ,"+this.Padre)
        alert(seleccionado);
        laux=lista.push(seleccionado);
        console.log(seleccionado);
    }
    escribirlista(){
        console.log(lista);
    }
    eligeObjeto(posicion:number){
        if(posicion!=0){
        seleccionado=lista[Number(posicion)-1];
        console.log(seleccionado);
        }
    }
    


        
    cambiar_estado(posicion:number){
        laux=posicion-1
        console.log(laux);
        if(posicion!=0){
       if (lista[laux].marcado) {
        console.log(lista[laux].marcado);
        lista[laux].marcado=false;
        lista[laux].indeterminado=false;
       } else {
        console.log(lista[laux].marcado);
        lista[laux].marcado=true;
        lista[laux].indeterminado=false;

       }
        if(lista[laux].Hijos[0]!=null){lista[laux].Cambiar_hijos()}; 
        if(lista[laux].Padre[0]!=null){lista[laux].Padre[0].Comprobar_padre();}
        console.log(lista[laux].marcado + " deberia salir cambiado");
    }}


    Cambiar_hijos(){
        if (lista[laux].marcado) {
            laux2=0;
            while(lista[laux].Hijos[laux2]!==null){
                lista[laux].Hijos[laux2].marcado=true;
                lista[laux].Hijos[laux2].indeterminado=false;
               laux2++;                         
            }
        } else {
            laux2=0;
            while(lista[laux].Hijos[laux2]!==null){
                lista[laux].Hijos[laux2].marcado=false;
                lista[laux].Hijos[laux2].indeterminado=false;                        
                laux2++;
             }
        }
        laux=0;
    }
    Comprobar_padre(){
        laux=0;
        laux2=0;
        if (this.Padre!==null) {
            
        } else {
            
        
        while(this.Hijos[laux]!==null){
            laux++ 
            if(this.Hijos[laux].marcado){
                laux2++;
            }                        
        }
        if (laux2==0) {
             //ver a que referencia this
            lista[laux].marcado=false;
            lista[laux].indeterminado=false;
        } else {
            if (laux2=this.Hijos.length-1) {
                lista[laux].Hijos[laux2].marcado=true;
                lista[laux].Hijos[laux2].indeterminado=false;
            } else {
              
                lista[laux].marcado=false;
                lista[laux].indeterminado=true;
            }
        }}


    }
    Cambiar_nombre(nuevo_nombre:string){
        this.nombre=nuevo_nombre;
    }
    maximo_identificador(){
        laux=this.identificador //el identificador de los hijos siempre es mas grande
        this.Hijos.forEach(hijo => {
            hijo.maximo_identificador() //si da error if(hijos no nulo)
        })
    }
    cambiar_identificador(nuevo_id:number){
        laux=nuevo_id+1;
        this.identificador=nuevo_id;
        this.Hijos.forEach(hijo => {    //si da error if(hijos no nulo)
            hijo.cambiar_identificador(laux)
        });
    }
    reordenar(elemento:Rama){ //
        if(lista[laux].identificador!=elemento.identificador){
            console.log("1");
        if (lista[laux].identificador>elemento.identificador) {
            console.log("2");
            lista[laux].maximo_identificador
            console.log("2");
            laux=laux-lista[laux].identificador+1;
            console.log("2");
            laux2=elemento.identificador;
            console.log("2");
            while (laux2+laux<lista.length) {
            
            lista[laux2].identificador=lista[laux2].identificador+laux;
            laux2++;
        }
        console.log("3");
        lista[laux].cambiar_identificador(elemento.identificador-laux) //comprobar si elemento mantiene el valor hasta este momento o si ya se cambia
        } 
        else {
            console.log("2");
            elemento.maximo_identificador
            laux=laux-elemento.identificador+1;
            laux2=lista[laux].identificador;
            while (laux2+laux<lista.length) {
            lista[laux2].identificador=lista[laux2].identificador+laux;
            laux2++;
        }
        elemento.cambiar_identificador(lista[laux].identificador-laux) //comprobar si elemento mantiene el valor hasta este momento o si ya se cambia
        } 
        lista[laux].ordenar_elementos}
    }

    comparar (a:Rama, b:Rama){
        return(a.identificador - b.identificador);
    }
    ordenar_elementos(){ //ordena los elementos de lista segun su identificador
        lista.sort(this.comparar);
    }

    anadir(){
        seleccionado=new(Rama);  
        // seleccionado.Padre.push(this);
        //this.Hijos.push(seleccionado);
        seleccionado.maximo_identificador();
        console.log(seleccionado);
        if(lista[lista?.length-1||0]!=lista[laux]){ //si el nuevo objeto no es ya el ultimo
            lista[laux].reordenar(seleccionado); //pongo el nuevo_hijo justo despues del ultimo hijo y reordeno los posteriores
    }
    console.log(seleccionado);
}
}