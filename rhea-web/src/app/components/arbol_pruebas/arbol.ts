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

interface FeatureNode {
    name: string;
    children?: FeatureNode[];
}

@Component({
    selector: 'arbol',
    templateUrl: './arbol.html',
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
                Nchildren.push(element)
            });
        }}
        return arbol
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
    organizarArbol(valor: any,lista:Array<Arbol>){  // recorrer los dos archivos y compararlos para meter los hijos
        
        return arbol
    }

    hasChild = (_: number, node: FeatureNode) => !!node.children && node.children.length >= 0;
    
}