import { Component, OnInit, Input, Inject } from '@angular/core'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { Injectable } from '@angular/core';
import { NONE_TYPE } from '@angular/compiler';
import { data, getJSON } from 'jquery';
import { jsDocComment } from '@angular/compiler';




let Nname:string;
let Nabstract:boolean;
let Noptional:boolean;
let Ntype:string;
let Nchildren:Array<Arbol>;



let aux :any=0 // variable auxiliar 
let arbol :Array<Arbol> =[]



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

    CrearArbol(valor: any){             // Crea los objetos pero no los introduce como hijos unos del otro
        Nname=valor.name;
        Nabstract=valor.abstract;
        Noptional=valor.optional;
        Ntype=valor.type;
        if(valor.children!=undefined){
        Nchildren=valor.children}
        else {Nchildren=[] }
        arbol[arbol.length]=new Arbol()
        if(valor.children!=undefined){
        if(Nchildren.length>0){
            aux=0
            valor.children.forEach(element => {
                this.CrearArbol(element);
            });
        }}
        return arbol
    }
    meterHijos(valor: any){  // mete todos los hijos pero solo en el primer valor 
        if(valor.children!=undefined){  // el primer valor es el primer padre de todos, y mete los hijos en los hijos de este
        valor.children.forEach(element => {// luego de todas formas el arbol deberia tener un solo elemento arriba
            arbol.forEach(rama=> {// por lo que se pueden borrar todos los demas porque ya aparecen sus datos en el primero
                if(rama.name==valor.name){
                    rama.children.push(element)
                } 
            } )
            if(element.children!=undefined){
                if(element.children.length>0){
                    this.meterHijos(element.children)
                }
            }
        });}
        return arbol[0]
    }
    
    valorHijos(algo:any){
        Nname=algo.name;
        Nabstract=algo.abstract;
        Noptional=algo.optional;
        Ntype=algo.type;
        if(algo.children!=undefined){
            Nchildren=algo.children}
        else {Nchildren=[] }
    }


    hasChild = (_: number, node: Arbol) => !!node.children && node.children.length >= 0;
    
}