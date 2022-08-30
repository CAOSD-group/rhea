import { Component, OnInit, Input, Inject } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { Injectable } from '@angular/core';
import { NONE_TYPE } from '@angular/compiler';
import { data, getJSON } from 'jquery';
import { jsDocComment } from '@angular/compiler';
import { Rama } from '../miarbol/miarbol';




let Nname:string;
let Nabstract:boolean;
let Noptional:boolean;
let Ntype:string;
let Nchildren:Array<Arbol>;
let Ncard_max:number
let Ncard_min:number



let aux :any=0 // variable auxiliar 
let aux2:any
let arbol :Array<Arbol> =[]
let lista:Array<string> =[]


@Component({
    selector: 'arbol',
    templateUrl: './arbol.html',
    styleUrls: ['./arbol.css'],
})

 export class Arbol  {
    name:string ="";
    card_min:number=0;
    card_max:number=0;
    type:string ="";
    optional:boolean =false;
    abstract:boolean =false;
    children:Array<Arbol> =[];
    aux=0
    treeControl = new NestedTreeControl<Arbol>(node => node.children);
    dataSource = new MatTreeNestedDataSource<Arbol>();
    


    constructor() {
        this.name=Nname;
        this.abstract=Nabstract;
        this.optional=Noptional;
        this.type=Ntype;
        this.children=[];
        this.card_max=Ncard_max;
        this.card_min=Ncard_min 
        if(this.card_min==undefined){this.card_min=0}
        if(this.card_max==undefined){this.card_max=0}
    }

    borrar(lista:Arbol){
        if(lista!=undefined){
        if(lista.children!=undefined){
        lista.children=lista.children.filter(x=>x.name!=this.name)}}
        if(this.children!=undefined){
            this.children.forEach(element => {
                element.borrar
            });
        }
        this.name=""
        this.abstract=false;
        this.optional=false;
        this.type="";
        this.children=[];
        this.card_max=-1;
        this.card_min=-1;
        }



    borrarLista(){
        lista.splice(0,lista.length)
    }
    listanombres(){
        return lista
    }

    CrearArbol(valor: any){             // Crea los objetos pero no los introduce como hijos unos del otro
        Nname=valor.name;
        Nabstract=valor.abstract;
        Noptional=valor.optional;
        Ntype=valor.type;
        Ncard_max=valor.card_max
        Ncard_min=valor.card_min
        if(valor.children!=undefined ){
        Nchildren=valor.children}
        else {Nchildren=[] }
        arbol[arbol.length]=new Arbol()

        if(valor.children==undefined)
        {
        lista.push(arbol[arbol.length-1].name)}

        if(valor.children!=undefined){
        if(Nchildren.length>0){
            aux=0
            valor.children.forEach(element => {
                this.CrearArbol(element);
            });
        }}
        
        return arbol
    }


    meterHijos(valor: any ,padre?:any, control?:boolean){ 
        if(valor.children!=undefined){  
        valor.children.forEach(element => {
            if(control==undefined){
            arbol.forEach(rama=> {
                if(rama.name==valor.name){
                    this.crearHijoArbol(element)
                    rama.children.push(aux)
                    this.meterHijos(element,rama,true)
                } })}
            if(control){
                padre.children.forEach(rama=> {
                    if(rama.name==valor.name){
                        this.crearHijoArbol(element)
                        rama.children.push(aux)
                        this.meterHijos(element,rama,true)
                    } 
                    }) 
            }
        });}
        return arbol[0]
    }



    limpiarArbol(lista?:Array<Arbol>){
        
        if(lista==undefined){lista=arbol}
        lista=lista.filter(x=> x instanceof Arbol)
        lista.forEach(element => {
            if(element.children!=undefined){
                element.children=this.limpiarArbol(element.children)}
        });
        return lista
    }
    evitaDuplicados(duplicado:string,lista?:Array<Arbol>){
        if(lista==undefined){
            aux=false
            lista=arbol
        }
        lista.forEach(element => {
            if(element.name==duplicado){aux=true
            console.log("Esta duplicado")}
            else{
            if(element.children!=undefined){
            this.evitaDuplicados(duplicado,element.children)}}
        });
        return aux
    }
   
  
    crearHijoArbol(valor:any){  
        aux=new Arbol()
        aux.name=valor.name;
        aux.abstract=valor.abstract;
        aux.optional=valor.optional;
        aux.card_max=valor.card_max;
        aux.card_min=valor.card_min 
        if(aux.card_min==undefined){aux.card_min=0}
        if(aux.card_max==undefined){aux.card_max=0}
        aux.type=valor.type;
        aux.children=[]
        return aux
    }
    creardeafault(nombre:string){  
        aux=new Arbol()
        aux.name=nombre
        aux.card_max=0;
        aux.card_min=0;
        aux.abstract=false;
        aux.optional=true
        aux.type="FEATURE"
        aux.children=[]
        return aux
    }

    hasChild = (_: number, node: Arbol) => !!node.children && node.children.length >= 0;
    
}