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
    abstract:boolean =false;
    optional:boolean =false;
    name:string ="";
    type:string ="";
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
    }

    borrar(){
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
                        //rama.children.splice(0,1)
                    } 
                    }) 
            }
        });}
        return arbol[0]
    }

    limpiarArbol(){
        console.log("llego")
        arbol[0].children.forEach(rama=>{
            console.log(rama.children)
        })
        return arbol[0]
    }
   
  
    crearHijoArbol(valor:any){  
        aux=new Arbol()
        aux.name=valor.name;
        aux.abstract=valor.abstract;
        aux.optional=valor.optional;
        aux.type=valor.type;
        aux.children=valor.children;
        return aux
    }

    hasChild = (_: number, node: Arbol) => !!node.children && node.children.length >= 0;
    
}