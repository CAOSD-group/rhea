
import {Component} from '@angular/core';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';

    let ltexto ="";
    let laux =0;
    let laux2=0;
    let lposicion =0;
    let lmarcado =true;
    let lindeterminado =false;
    var megaauxiliar :any;
    var seleccionado :Rama 
    var seleccionado2 :Rama;
    var lista: Array<Rama> =[];
    var arbol:Array<Rama_controlada> =[];

    

    class Rama_controlada {
        declare nombre: string;
        declare marcado: boolean;
        declare children?: Rama_controlada[];
        //declare arbol:[];
        constructor(Nnombre:string , Nmarcado:boolean){
          this.nombre=Nnombre;
          this.marcado=Nmarcado;
          this.children=[];
        }
    }
    const TREE_DATA2: Rama_controlada[]=[
      megaauxiliar=new Rama_controlada ("hola",true),
      arbol[arbol.length]=megaauxiliar,
      new Rama_controlada ("valgo",true),
      new Rama_controlada ("distinto",true),
      new Rama_controlada ("hola",true),
    ]

    const TREE_DATA: Rama_controlada[]=[
        {
            "nombre": "truck",
            "marcado": false,
            "children": [
              {
                "nombre": "weight",
                "marcado": true,
                "children": [
                  {
                    "nombre": "lightweight",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "12tons",
                        "marcado": true,
                      },
                      {
                        "nombre": "18tons",
                        "marcado": true,
                      },
                      {
                        "nombre": "20tons",
                        "marcado": true,
                      }
                    ]
                  },
                  {
                    "nombre": "heavyweight",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "23tons",
                        "marcado": true,
                      },
                      {
                        "nombre": "40tons",
                        "marcado": true,
                      }
                    ]
                  }
                ]
              },
              {
                "nombre": "type",
                "marcado": true,
                "children": [
                  {
                    "nombre": "semitrailer",
                    "marcado": true,
                  },
                  {
                    "nombre": "tank",
                    "marcado": true,
                  },
                  {
                    "nombre": "flatbed",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "dumper",
                        "marcado": true,
                      }
                    ]
                  }
                ]
              },
              {
                "nombre": "prueba",
                "marcado": true,
                "children": [
                  {
                    "nombre": "prueba1",
                    "marcado": true,
                  },
                  {
                    "nombre": "prueba_hijo",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "ultima",
                        "marcado": true,
                      }
                    ]
                  }
                ]
              },
              {
                "nombre": "engine",
                "marcado": true,
                "children": [
                  {
                    "nombre": "160kw",
                    "marcado": true,
                  },
                  {
                    "nombre": "280kw",
                    "marcado": true,
                  },
                  {
                    "nombre": "400kw",
                    "marcado": true,
                  }
                ]
              },
              {
                "nombre": "cabin",
                "marcado": true,
                "children": [
                  {
                    "nombre": "highroof",
                    "marcado": true,
                  },
                  {
                    "nombre": "sleepercabin",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "1bed",
                        "marcado": true,
                      },
                      {
                        "nombre": "2beds",
                        "marcado": true,
                      }
                    ]
                  }
                ]
              },
              {
                "nombre": "axles",
                "marcado": true,
                "children": [
                  {
                    "nombre": "count",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "2axles",
                        "marcado": true,
                      },
                      {
                        "nombre": "multiplerearaxles",
                        
                    "marcado": true,
                        "children": [
                          {
                            "nombre": "3axles",
                            "marcado": true,
                          },
                          {
                            "nombre": "4axles",
                            "marcado": true,
                          }
                        ]
                      }
                    ]
                  },
                  {
                    "nombre": "additionalsteeringaxle",
                    "marcado": true,
                  },
                  {
                    "nombre": "drivetrain",
                    "marcado": true,
                    "children": [
                      {
                        "nombre": "1drivenaxle",
                        "marcado": true,
                      },
                      {
                        "nombre": "2drivenaxles",
                        "marcado": true,
                      },
                      {
                        "nombre": "3drivenaxles",
                        "marcado": true,
                      }
                    ]
                  }
                ]
              }
            ]
          },
      ];

    

@Component({
    selector: 'miarbol',
    templateUrl: './miarbol.html',
    styleUrls: ['./miarbol.css'],
})

export class Rama implements Rama_controlada{
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
    treeControl = new NestedTreeControl<Rama_controlada>(node => node.children);
    dataSource = new MatTreeNestedDataSource<Rama_controlada>();
 
    

    constructor() {
        this.dataSource.data = TREE_DATA2;
        this.nombre = ltexto;
        this.identificador =lista?.length || 0;
        this.posicion=this.identificador;
        this.Hijos = new Array<Rama>() ;
        this.Padre = new Array<Rama>();
        this.marcado= lmarcado;
        this.indeterminado=false;
    }

    hasChild = (_: number, node: Rama_controlada) => !!node.children && node.children.length >= 0;
  
    borrar(elemento:number) {  //borra todos los hijos
        this.posicion=elemento-1;
        seleccionado=lista[this.posicion];
        seleccionado.Hijos.forEach(hijo => {
            hijo.borrar(hijo.posicion);
        });
        seleccionado.nombre = "";
        lista.splice(seleccionado.identificador,1); //elimina el elemento cuya posicion coincide con la del identificador
        seleccionado.identificador =-1 ;
        seleccionado.Hijos.splice(0);
        seleccionado.Padre.splice(0);
        seleccionado.marcado= false;
        seleccionado.indeterminado=false;
    }

    sumar(input:number,input2:number){
            if(Number(input.toString())+ Number(input2.toString())){
            alert(Number(input.toString())+ Number(input2.toString()))
            console.log("se ha sumado "+ input.toString() +" a " +input2.toString());
        } else{
        alert("se ha intentado sumar algo que no son numeros")}
    }
    crearValor(valor:string){
        this.actualizarvalores(valor);
        seleccionado=new Rama();
        if(seleccionado!=undefined){
        laux=lista.push(seleccionado);}
    }

    escribirvalores(){
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
    actualizarvalores(elemento:string){
        ltexto=elemento;
        laux=this.aux
        laux2=this.aux2;
        lmarcado=this.marcado;
        lindeterminado=this.marcado;
        this.nombre=ltexto;
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
    meter_hijo(hijo:number,padre:number){
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
            laux=-1;
            console.log("llego aqui")
            seleccionado.Hijos.forEach(element =>{
                laux++;
                console.log("reviso hijos")
                if(element==seleccionado2){
                    seleccionado2.Padre=[];
                    console.log("el hijo existia")
                    laux--;
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
    crea_Rama_controlada(valor:string){
      this.actualizarvalores(valor);
      seleccionado=new Rama();
      if(seleccionado!=undefined){
      laux=lista.push(seleccionado);}
      megaauxiliar=new Rama_controlada(seleccionado.nombre,seleccionado.marcado);
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
        //lista[laux].cambiar_identificador(elemento.identificador-laux) //comprobar si elemento mantiene el valor hasta este momento o si ya se cambia
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
        //elemento.cambiar_identificador(lista[laux].identificador-laux) //comprobar si elemento mantiene el valor hasta este momento o si ya se cambia
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