import { Component } from '@angular/core'




let Nchildren:Array<Arbol>;
let aux :any=0 
let arbol :Array<Arbol> =[]
let nlista:Array<string> =[]
@Component({
    selector: 'arbol',
    templateUrl: './arbol.html',
})

 export class Arbol  {
    name:string ="";
    card_min:number=0;
    card_max:number=0;
    type:string ="";
    optional:boolean =false;
    abstract:boolean =false;
    children:Array<Arbol> =[];
    constructor() {}

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

    borrarLista(){nlista.splice(0,nlista.length)}
    listanombres(){return nlista}
    listanombresModificar(nuevonombre:string,viejonombre:string){
        aux=nlista.indexOf(viejonombre)
        nlista[aux]=nuevonombre
        return nlista}

    CrearArbol(valor: any){             // Crea los objetos pero no los introduce como hijos unos del otro
        aux=new Arbol()
        aux.name=valor.name;
        aux.abstract=valor.abstract;
        aux.optional=valor.optional;
        aux.type=valor.type;
        aux.card_max=valor.card_max
        aux.card_min=valor.card_min
        aux.children=[]
        if(aux.card_min==undefined){aux.card_min=0}
        if(aux.card_max==undefined){aux.card_max=0}
        if(valor.children!=undefined ){
        Nchildren=valor.children}
        
       
        if(valor.children==undefined || valor.children.length==0){
        Nchildren=[] 
        nlista.push(valor.name)}
        arbol[arbol.length]=aux
        if(valor.children!=undefined){
        if(valor.children.length>0){
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
        aux.type="FEATURETERM"
        aux.children=[]
        return aux
    }
}