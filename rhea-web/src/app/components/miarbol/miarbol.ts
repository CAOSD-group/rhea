import {Component,Injectable, OnInit} from '@angular/core';
import {CdkTreeModule, NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { empty } from 'rxjs';
import { matMenuAnimations } from '@angular/material/menu';
import {MatTreeModule} from '@angular/material/tree';
import {getMultipleValuesInSingleSelectionError } from '@angular/cdk/collections';
    let ltexto ="";
    let laux =0;
    let laux2=0;
    let lposicion =0;
    let padreactual=1;
    let laux3=0;
    let lmarcado =false;
    let lindeterminado =false;
    var megaauxiliar :any;
    var seleccionado :Rama 
    var seleccionado2 :Rama;
    var ramaselecionada: Rama_controlada;
    var lista: Array<Rama> =[];
    var arbol:Array<Rama_controlada> =[];
    var arbolauxiliar:Array<Rama_controlada> =[];
    var arbolconduplicados:Array<Rama_controlada> =[];



@Component({
    selector: 'miarbol',
    templateUrl: './miarbol.html',
    styleUrls: ['./miarbol.css'],
})

export class Rama implements Rama_controlada  {
    aux =laux;
    aux2=laux2;
    posicion =lposicion;
    nombre = "";
    identificador =0 ;
    marcado= lmarcado;
    indeterminado=lindeterminado;
    Hijos: Array<Rama> =[] ;
    Padre: Array<Rama> =[] ;
    lista: Array<Rama> =[];
    treeControl = new NestedTreeControl<Rama_controlada>(node => node.Hijos);
    dataSource = new MatTreeNestedDataSource<Rama_controlada>();
 
    

    constructor() {
        
        this.nombre = ltexto;
        this.identificador =lista?.length || 0;
        this.posicion=this.identificador;
        this.Hijos = new Array<Rama>() ;
        this.Padre = new Array<Rama>();
        this.marcado= lmarcado;
        this.indeterminado=false;
        this.dataSource.data=arbol;
        TREE_DATA4=arbol;
    }

  
   

    hasChild = (_: number, node: Rama_controlada) => !!node.Hijos && node.Hijos.length >= 0;
  
    borrar(elemento? :number  ) { 
        console.log(elemento+" elemento")
        console.log(seleccionado+" seleccionado")
        if(elemento==undefined){
            elemento=seleccionado.posicion
        }
        console.log(elemento+" elemento")
        seleccionado=lista[elemento];
        laux2=1;
        console.log(seleccionado+" seleccionado")
        if(seleccionado.Hijos.length>0){  
            console.log("borro hijos")
            seleccionado.maximo_identificador();
            console.log(laux2+ " maximo identificador")
            console.log(laux2-seleccionado.identificador+1+ " cantidad a borrar")
            laux2=laux2-seleccionado.identificador+1;
           };
        lista.splice(elemento,laux2)
        if(seleccionado.Padre.length==0){
        arbol=arbol.filter(x=>x.nombre!=seleccionado.nombre) 
        }else{                                          
           arbol= borrarhijo(arbol)                       
           console.log(arbol+"arbol actualizado")
           this.escribirlistaarbol()
        }
        this.ordenarLista();
        this.dataSource.data=[]
        this.dataSource.data=arbol;
        TREE_DATA4=arbol;
        
    }

    ordenarLista(){
        laux=0;
        lista.forEach(element => {
            element.posicion=laux
            laux++
        });
    }


    verelvalor(id:string){
        seleccionado2=seleccionado
        seleccionado=lista.filter(x=> x.nombre==id)[0];
        console.log(seleccionado+ " el actual es")
        console.log(seleccionado2+" el anterior era")
    }

    escribirvalores(){
        console.log(seleccionado);
    }

    


    escribirlista(){
        console.log(lista);
    }
    escribirlistaarbol(){
        console.log(arbol);
    }
   
    actualizarvalores(elemento:string){
        ltexto=elemento;
        laux=this.aux
        laux2=this.aux2;
        lmarcado=this.marcado;
        lindeterminado=this.marcado;
        this.nombre=ltexto;
    }

    crearValor(valor:string){
        seleccionado.ordenarLista()
        seleccionado2=this;
        console.log(seleccionado2);
        this.actualizarvalores(valor);
        seleccionado2.marcado=false;
        seleccionado=new Rama();
        if(seleccionado!=undefined){
        new Rama_controlada(this.nombre)
        this.dataSource.data=arbol;
        TREE_DATA4=arbol;
      }
    }
    crearHijo(valor:string){
        seleccionado.ordenarLista()
        seleccionado2=this;
        console.log(seleccionado2);
        this.actualizarvalores(valor);
        seleccionado=new Rama();
        if(seleccionado!=undefined){
        new Rama_controlada(this.nombre)
        this.dataSource.data=arbol;
        TREE_DATA4=arbol;
      }
    }




    cambiar_nombre(posicion:number,nuevo_nombre:string){
        if(posicion!=0){
            seleccionado=lista[posicion-1];
            seleccionado.nombre=nuevo_nombre;
        }
    }

    cambiar_estado(posicion:number){
        laux=posicion-1
        if(posicion!=0){
       if (lista[laux].marcado) {
        lista[laux].marcado=false;
        lista[laux].indeterminado=false;
       } else {
        lista[laux].marcado=true;
        lista[laux].indeterminado=false;
       }
        if(lista[laux].Hijos[0]!=null){lista[laux].Cambiar_hijos()}; 
        if(lista[laux].Padre[0]!=null){lista[laux].Padre[0].Comprobar_padre();}
    }}

    cambiar_identificador(posicion:number,nuevo_id:number){ //falta poner la condicion de que no exista otro elemento con es identificador
        if(posicion!=0){
            seleccionado=lista[posicion-1];
            laux=0;
            lista.forEach(element => {
                if (element.identificador==nuevo_id){
                    laux=1
                } 
            });
            if (laux!=1) {
                seleccionado.identificador=nuevo_id;    
            } else {
                console.log("Error: ya existe este identificador")
            }
        }
    }


    meter_hijo(padre:number,hijo:number){
        if(lista[hijo-1]!=null && lista[padre-1]!=null){
        seleccionado=lista[hijo-1];
        seleccionado2=lista[padre-1];
        laux=0;

            if(seleccionado2.Hijos!=null){
        seleccionado2.Hijos.forEach(element => {
            if (element.identificador==seleccionado.identificador){
                laux=1
                console.log("ya existe este hijo");
            } 
        })};
        if (laux!=1) {
            seleccionado.Padre=[];
            seleccionado.Padre.push(seleccionado2);
            seleccionado2.Hijos.push(seleccionado);
        }
        }
    }


    quitar_un_hijo(padre:number,hijo:number){
        if(lista[hijo-1]!=null && lista[padre-1]!=null){
            seleccionado2=lista[hijo-1];
            seleccionado=lista[padre-1];
           
            console.log("llego aqui")
            seleccionado.Hijos.forEach(element =>{
                console.log("reviso hijos")
                if(element==seleccionado2){
                    seleccionado2.Padre=[];
                    console.log("el hijo existia")
                } else{
                    megaauxiliar= new Array<Rama>();
                    megaauxiliar.push(element);
                }
            })
            seleccionado.Hijos=megaauxiliar;
        }

    }

    quitar_hijos(padre:number){
        if(lista[padre-1]!=null){
        seleccionado=lista[padre-1];
        if(seleccionado.Hijos!=null){
            seleccionado.Hijos.forEach(element => {
                element.Padre=[];
            })};
        seleccionado.Hijos=[];

        }
    }
    


    
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
        laux2=this.posicion //el identificador de los hijos siempre es mas grande
        if(this.Hijos!=[]){
        this.Hijos.forEach(hijo => {
            hijo.maximo_identificador() //si da error if(hijos no nulo)
        })}
    }

    anadir(){
        seleccionado=new(Rama);  
        seleccionado.Padre.push(this);
        this.Hijos.push(seleccionado);
        seleccionado.maximo_identificador();
        if(lista[lista?.length-1||0]!=lista[laux]){ //si el nuevo objeto no es ya el ultimo
            //lista[laux].reordenar(1,2); //pongo el nuevo_hijo justo despues del ultimo hijo y reordeno los posteriores
    }
    console.log(seleccionado);
  }


  eliminar_duplicados(){
    arbolconduplicados=arbol;
    arbolauxiliar=arbol;
    arbol=[];
    arbol[0]=arbolauxiliar[0]
    laux=0;
    laux2=0;
    megaauxiliar=0;
    while(laux <arbolauxiliar.length){
        numero_hijos(arbolauxiliar[laux])
        if(megaauxiliar>0){
            laux2=laux2+megaauxiliar;
            megaauxiliar=0;  
        };
        arbol[laux]=arbolauxiliar[laux];
        laux2++;
        laux=laux2;
    }
    arbol=arbol.filter(function (e) {return e != null;})
    this.dataSource.data=arbol;
    TREE_DATA4=arbol;
    arbolauxiliar=arbol
    return(arbol[0])
  }


  sacarHijos(){
    while (seleccionado.Hijos.length>0){
        console.log("con hijo")
        sacarhijo(arbol)
        console.log(seleccionado.Padre)
        seleccionado.Hijos.forEach(element => {
            element.Padre=seleccionado.Padre;
            if(element.Padre.length>0){
            lista[element.Padre[0].posicion].Hijos.push(element);
        }     
        });
        seleccionado.Hijos=[]
    } 
        console.log("sin hijo")
    this.dataSource.data=[]
    this.dataSource.data=arbol;
    TREE_DATA4=arbol;
}

meterHijos(){ 
    seleccionado.maximo_identificador();
    laux=laux2+1;
    //seleccionado2=lista[laux];
      //seleccionado sera el padre y seleccionado2 el hijo
    seleccionado2.Padre=[]
    buscarRamaControlada(arbol)  //selecciona la rama que tiene que meter
    meterHijo(arbol);           //busca el elemento donde tiene que introducir la rama y la inserta 
    laux=0
    arbol=borrarRama(arbol);
    seleccionado2.Padre.push(seleccionado)      
    seleccionado.Hijos.push(seleccionado2)
    this.dataSource.data=[]
    this.dataSource.data=arbol;
    TREE_DATA4=arbol;
} 
vereltreedata(){
  console.log(TREE_DATA4);
}
saveJson( ) {
    localStorage.setItem("0", JSON.stringify(TREE_DATA4));
}
  





    



   
}


    class Rama_controlada  {
        declare nombre: string;
        declare marcado: boolean;
        declare Hijos: Rama_controlada[];


        constructor(Nnombre:string, Nmarcado?:boolean,Nhijos?:Rama_controlada[],control?:boolean){
          this.nombre=Nnombre;
          this.marcado=false;
          this.Hijos=[];
          arbol[arbol.length]=this;
          ltexto=this.nombre;
          if(control==undefined){
          lista[lista.length]=new Rama();}
        }
        

        
        
        
    
    }
   
    const TREE_DATA3: Rama_controlada[]=[
      {"nombre": "prueba",
        "marcado": false,
        "Hijos" : [{
          "nombre": "prueba2",
        "marcado": false,
        "Hijos" : [{"nombre": "hijo3",
        "marcado": false,
        "Hijos" : []}]},
        {
          "nombre": "prueba4",
        "marcado": false,
        "Hijos" : [{"nombre": "hijo5",
        "marcado": false,
        "Hijos" : []}]},
        {
            "nombre": "prueba6",
          "marcado": false,
          "Hijos" : [{"nombre": "hijo7",
          "marcado": false,
          "Hijos" : []}]},
          

      ]},{
        "nombre": "nuevaprueba",
        "marcado": false,
        "Hijos" : [   {
            "nombre": "nuevaprueba2",
            "marcado": false,
            "Hijos" : [   {
                "nombre": "nuevo3",
                "marcado": false,
                "Hijos" : []  }
                ]   }
                ]   }
    ]
    
    var TREE_DATA4: Rama_controlada[]=[]

     const TREE_DATA2: Rama_controlada[]=[
      actualizarvalores(),
      new Rama_controlada ("hola"),
      new Rama_controlada ("valgo"),
      new Rama_controlada ("distinto"),
      new Rama_controlada ("este"),
      lista[0].eliminar_duplicados(),
      actulizarhijos()
    ]
    function actualizarvalores(){
      TREE_DATA3.forEach(element => {

        arbol[arbol.length]= element as Rama_controlada;  // solo considera que tenga 2 elementos no 4
        ltexto=arbol[arbol.length-1].nombre;
        lista[arbol.length-1]=new Rama();
        if(element.Hijos) {actualizarvalores2(element)}             // aunque introduce los otros correctamente como los hijos
      
      });
      return(arbol[0])
    }
    function actualizarvalores2(objeto :Rama_controlada){
      objeto.Hijos.forEach(element2 => {
        arbol[arbol.length]= element2 as Rama_controlada;  // solo considera que tenga 2 elementos no 4
        ltexto=arbol[arbol.length-1].nombre;              // aunque introduce los otros correctamente como los hijos
      lista[arbol.length-1]=new Rama();
      if(element2.Hijos) {actualizarvalores2(element2)}  
      });
      return(arbol[0])
    }
    function numero_hijos(objeto :Rama_controlada){
        if(objeto.Hijos.length>0){
            megaauxiliar=megaauxiliar+objeto.Hijos.length;
            objeto.Hijos.forEach(element => {
                numero_hijos(element)
            });
        }
    }
    function actulizarhijos(){
        lposicion=0;
        laux2=0;
        laux3=0;
        megaauxiliar=0; 
        while(lposicion<lista.length-1){
            if(lista[lposicion+1].nombre==arbol[laux2+1].nombre){ // si el siguiente elemento de la lista arbol tiene el mismo nombre
                lposicion++;                                        // que el siguiente elemento de la lista normal, es porque no es hijo
                laux2++;
                laux3=lposicion;
                padreactual=laux3+1;
            }else{  // el elemento es hijo directo o no del elemento actual
                if(soyhijo(arbol[laux2].Hijos,lista[lposicion+1].nombre)){
                    lista.forEach( x => {
                        if(x.nombre==ramaselecionada.nombre){
                            megaauxiliar=arbolconduplicados.indexOf(ramaselecionada)
                            elegirpadre();
                            lista[0].meter_hijo( padreactual+1,x.identificador+1); //el elegir padre falla
                            
                        }
                    })

                }
                lposicion++;


            }   

        }
        return(arbol[0])
    }

    function elegirpadre(){
       
        if(lista[megaauxiliar-1].Hijos.length<arbolconduplicados[megaauxiliar-1].Hijos.length){
            padreactual=megaauxiliar-1;  
        }else{
            megaauxiliar--;
            elegirpadre();
        }

    }


    function soyhijo(conjunto : Array<Rama_controlada>,nombrebuscado :string){
        conjunto.forEach(element => {
            if(element.nombre==nombrebuscado){
                lmarcado=true
                ramaselecionada=element;
            }else{
                if(!lmarcado){
                    megaauxiliar++;
                }
                if(element.Hijos!=null){
                    if(soyhijo(element.Hijos,nombrebuscado)){
                        megaauxiliar++;
                    }
                }
            }
        });
        return lmarcado
    }
     function borrarhijo(lista:Array<Rama_controlada>){ //mando aqui una lista de hijos
        lista.forEach(element => {
   
            if(element.Hijos.length>0){
                if(element.Hijos.length!=element.Hijos.filter(x=> x.nombre!=seleccionado.nombre).length){
                    
                    element.Hijos=element.Hijos.filter(x=> x.nombre!=seleccionado.nombre)
                    
                }
                borrarhijo(element.Hijos)}
        } );
        return(lista)
     }
   
     function sacarhijo(lista:Array<Rama_controlada>){ //mando aqui una lista de hijos
        lista.forEach(element => {
            if(element.nombre==seleccionado.nombre && element.Hijos.length==seleccionado.Hijos.length){ //si tienen mismo nombre e hijos
                element.Hijos.forEach(hijo => {
                    lista.push(hijo) //meto los hijos en la lista del padre 
                });
                element.Hijos=[];
            }
            
            else{     //si el elemento tiene hijos y no se ha vaciado 
                if((element.Hijos.length>0)){
                sacarhijo(element.Hijos)}}
        } );
        return(lista)
     }


     function meterHijo(lista:Array<Rama_controlada>){ 
        lista.forEach(element => {
            if(element.nombre==seleccionado.nombre && element.Hijos.length==seleccionado.Hijos.length){
                element.Hijos.push(ramaselecionada);
                console.log(lista.filter(x=> x.nombre!=ramaselecionada.nombre))
            }else{     
                if((element.Hijos.length>0)){
                    meterHijo(element.Hijos)}}
        
       });
        
        return(lista)
     }

   function buscarRamaControlada(lista:Array<Rama_controlada>){ 
    lista.forEach(element => {
        if(element.nombre==seleccionado2.nombre && element.Hijos.length==seleccionado2.Hijos.length){ 
           ramaselecionada=element;
        }
        else{
            if((element.Hijos.length>0)){
                buscarRamaControlada(element.Hijos)}
        }
    } );
    return(lista)
   }
   function borrarRama(lista:Array<Rama_controlada>){
    lista.forEach(element=>{
      if(element.nombre==seleccionado2.nombre){
        if(laux==0){
          laux++;
        }
        else{
        lista=lista.filter(x=> x.nombre!=seleccionado2.nombre)  //cambia a la lista de hijos del elemento
       
      }}
    else{
      if(element.Hijos.length>0){
        element.Hijos=borrarRama(element.Hijos)
      }

    }    })
    return(lista)
   }
  