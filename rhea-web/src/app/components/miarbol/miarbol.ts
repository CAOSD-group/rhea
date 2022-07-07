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







   var texto ="";
   var aux =0;
   var aux2=0;
   var seleccionado :Rama 
   var lista: Array<Rama>;


@Component({
    selector: 'miarbol',
    templateUrl: './miarbol.html',
    //styleUrls: ['./miarbol.css'],
})
export class Rama{
    nombre = "";
    identificador =0 ;
    Hijos = new Array<Rama>() ;
    Padre = new Array<Rama>();
    marcado= false;
    indeterminado=false;

    constructor() {
        this.nombre = texto;
        aux=lista?.length || 0  ;
        this.identificador =aux;
        this.Hijos = new Array<Rama>() ;
        this.Padre = new Array<Rama>();
        this.marcado= false;
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




    cambiar_estado(){
       if (this.marcado) {
        this.MarcarNo;
       } else {
        this.MarcarSi;}

        this.Cambiar_hijos;
        this.Padre[0].Comprobar_padre;
    }
    MarcarSi(){
        this.marcado=true;
        this.indeterminado=false;
    }
    MarcarNo(){
        this.marcado=false;
        this.indeterminado=false;
    }
    Marcarduda(){
        this.marcado=false;
        this.indeterminado=true;;
    }

    Cambiar_hijos(){
        if (this.marcado) {
            aux=0;
            while(this.Hijos[aux]!==null){
               this.Hijos[aux].MarcarSi();
               aux++;                         
            }
        } else {
            aux=0;
            while(this.Hijos[aux]!==null){
                this.Hijos[aux].MarcarNo();                         
                aux++;
             }
        }
        aux=0;
    }
    Comprobar_padre(){
        aux=0;
        aux2=0;
        while(this.Hijos[aux]!==null){
            aux++ 
            if(this.Hijos[aux].marcado){
                aux2++;
            }                        
        }
        if (aux2==0) {
            this.MarcarNo;
        } else {
            if (aux2=this.Hijos.length-1) {
                this.MarcarSi;
            } else {
                this.Marcarduda; 
            }
        }
    }
    Cambiar_nombre(nuevo_nombre:string){
        this.nombre=nuevo_nombre;
    }
    maximo_identificador(){
        aux=this.identificador //el identificador de los hijos siempre es mas grande
        this.Hijos.forEach(hijo => {
            hijo.maximo_identificador() //si da error if(hijos no nulo)
        })
    }
    cambiar_identificador(nuevo_id:number){
        aux=nuevo_id+1;
        this.identificador=nuevo_id;
        this.Hijos.forEach(hijo => {    //si da error if(hijos no nulo)
            hijo.cambiar_identificador(aux)
        });
    }
    reordenar(elemento:Rama){ //
        if(this.identificador!=elemento.identificador){
        if (this.identificador>elemento.identificador) {
            this.maximo_identificador
            aux=aux-this.identificador+1;
            aux2=elemento.identificador;
            while (aux2+aux<lista.length) {
            lista[aux2].identificador=lista[aux2].identificador+aux;
            aux2++;
        }
        this.cambiar_identificador(elemento.identificador-aux) //comprobar si elemento mantiene el valor hasta este momento o si ya se cambia
        } 
        else {
            elemento.maximo_identificador
            aux=aux-elemento.identificador+1;
            aux2=this.identificador;
            while (aux2+aux<lista.length) {
            lista[aux2].identificador=lista[aux2].identificador+aux;
            aux2++;
        }
        elemento.cambiar_identificador(this.identificador-aux) //comprobar si elemento mantiene el valor hasta este momento o si ya se cambia
        } 
    this.ordenar_elementos}
    }

    comparar (a:Rama, b:Rama){
        return(a.identificador - b.identificador);
    }
    ordenar_elementos(){ //ordena los elementos de lista segun su identificador
        lista.sort(this.comparar);
    }
    anadir(){
        seleccionado=new(Rama);  
        seleccionado.Padre.push(this);
        this.Hijos.push(seleccionado);
        this.maximo_identificador;
        if(lista[lista.length-1]!=lista[aux]){ //si el nuevo objeto no es ya el ultimo
        lista[aux+1].reordenar(seleccionado); //pongo el nuevo_hijo justo despues del ultimo hijo y reordeno los posteriores
    }
}
}