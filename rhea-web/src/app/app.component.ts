import { Component} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { Arbol } from './components/arbol_pruebas/arbol';
import{Const} from './components/constrain/const';


var aux:any;
var aux2:string;
var aux3: any;
let baux=false;

export interface Tile {
  color: string;
  cols: number;
  rows: number;
  text: string;
  }


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  urlsave="http://172.16.51.94:5000/saveFM" //servidor guardar datos
  urldownload="http://172.16.51.94:5000/downloadFM"  //servidor cargar datos
  urldelete="http://172.16.51.94:5000/deleteFM"  //servidor cargar datos
  urlcreate="http://172.16.51.94:5000/createFM" //servidor guardar datos
  documentos:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl'];
  file: File | null = null;
  articulos: any;        //atributo donde guardo las respuestas
  title:string ='rhea-web' // evita un error en app.component.spec.ts
  declare actual:Arbol      //valor actual del arbol
  tree:Array<Arbol> =[new Arbol()]  // el arbol de datos 
  cons:Array<Const>=[new Const()]
  declare json_nombre:any;    //guardo los valores de las features
  declare json_const:any;     //guardo los valores de las constraints
  treeControl = new NestedTreeControl<Arbol>(node => node.children);
  dataSource = new MatTreeNestedDataSource<Arbol>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();

  // variables para la representacion web
  tiles: Tile[] = [ // variables para la visualizacion del grid
    {text: 'One', cols: 1, rows: 6, color:'lightblue'}, // acepta valores no enteros como 1.3
    {text: 'Two', cols: 9, rows: 6, color:'lightgreen'},
    {text: 'Three', cols: 7, rows: 6, color:'lightpink'},
    {text: 'Four', cols: 2, rows: 6, color:'#DDBDF1'}]
  item:string ='Truck.uvl';       //variable para el titulo 


  
constructor(private http: HttpClient) { }  
ngOnInit() {}
//order : saveFM;downloadFM (2 ways) ;deleteFM;createFM; metodos auxiliares 

saveFile(texto?:string){ // envio el nuevo archivo y el nuvo nombre opcional
  // envia el treeControl (supongo que se borra aqui o alli o no da problemas)
  if(texto==undefined || texto==""){
    console.log("sin cambio de nombre")
    this.http.post(this.urlsave,this.tree,{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)})}
  else{
    console.log("el nombre se cambia")
    this.http.post(this.urlsave,[texto,this.tree],{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)
  })}
}
returnValues(texto?:string){
  if(texto==""){texto=this.item}
  if(texto==undefined){texto=this.item}
  this.http.post(this.urldownload,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.item=texto||"";
    this.articulos=JSON.parse(this.articulos)
    this.json_nombre=this.articulos.features,
    this.json_const=this.articulos.constraints
    this.crearCons()
    this.crearArbol()
  })
}
getArchivo(texto?:string){
  this.http.post(this.urldownload,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.item=texto||"";
    this.articulos=JSON.parse(this.articulos)
    this.json_nombre=this.articulos.features,
    console.log(this.json_nombre)
    this.json_const=this.articulos.constraints
    console.log(this.json_const)
    this.crearCons()
    this.crearArbol()
  })
}

deleteFile(){  //envia el nombre del archivo a borrar
  this.http.post(this.urldelete,this.item,{responseType:'text'}).subscribe(resultado => {
    //¿Controlamos de alguna forma este metodo?¿Creo un arbol vacio o que no exista ningun arbol en la vista?
    console.log(resultado)
  })
}
createFile(texto:string){  // envia el nombre del arvhico a crear y el archivo a crear (1 o 2 pasos?)
  console.log(this.tree)
  this.http.post(this.urlcreate,[texto,this.tree],{responseType:'text'}).subscribe(resultado => {
    //¿que pasa si el nombre ya existe?
    console.log(resultado)
  })
}







// comprobar las opciones de modificaciones (cuales tiene que haber)
//    preguntar cuales van a ser los parametros finales
//    tanto del arbol como de las constrains
// consultar con jose miguel las funciones del servidor
//
//
// alertas para comprobar ciertas funciones como borrar? 
// 









constrainhasChild = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;


crearCons(){
  console.log("creo constrains")
  this.cons.splice(0,this.cons.length)
  this.cons=[new Const()]
  this.cons=this.cons[0].CrearConstrain(this.json_const)
  console.log(this.cons)
}

crearArbol(){
  console.log("creo arbol")
  this.tree.splice(0,this.tree.length)
  this.tree=[new Arbol()]
  this.tree=this.tree[0].CrearArbol(this.json_nombre)
  this.tree[0]=this.tree[0].meterHijos(this.json_nombre);
  this.tree.splice(1,this.tree.length)
  this.dataSource.data=this.tree
  this.constraindataSource.data=this.cons
  console.log(this.tree)
}

borrarArbol(){
  this.dataSource.data=[]
  this.constraindataSource.data=[]
}

recargarArbol(){
  console.log(this.tree)
  this.dataSource.data=this.tree
  this.constraindataSource.data=this.cons
}

changeListener($event): void {this.readThis($event.target);}

readThis(inputValue: any): void { // de momento solo sirve con archivos .json o escritos similares 
 
    var file: File = inputValue.files[0];
    var myReader: FileReader = new FileReader();
    myReader.readAsText(file);
    myReader.onloadend = function (e) {
        aux=myReader.result 
        aux2=myReader.result?.toString()||""
        aux=JSON.parse(aux)
        aux2=aux.constraints
        aux=aux.features
    }                       // implementar con while false, y tiempo mucho menor 
    //(evita errores en tiempos muy largos y reduce tiempo de espera en los cortos)
    
      setTimeout(() =>     //me permite asegurarme que el valor del archivo se ha leido a tiempo
      { 
        if(aux!=undefined){
        this.json_nombre=aux
        this.json_const=aux2
        console.log("estoy en espera")
        this.crearCons()
        this.crearArbol()}
      },
      2000);
  }
  

seleccionar(id:string,lista?:Array<any>){  // este devuelve un objeto tipo Object
  aux2=this.tree[0].name
  if(lista==null){lista=this.tree}
  if(lista.filter(x=> x.name==id)[0]==undefined){
    lista.forEach(element => {
      if(element.children){
      if(element.children.length>0){
        this.seleccionar(id,element.children)
      }}
    });
  }else{
    this.actual=lista.filter(x=> x.name==id)[0]
    this.buscarArbol()
    this.tree[0].name=aux2
  }
  }

  buscarArbol(lista?:Array<any>){     // este busca el Object y devuelve el tipo Arbol , no se si sera necesario pero seguro evita algun problema
    if(lista==null){lista=this.tree}
    baux=false;
    while(!baux){
      lista.forEach(element => {
        if(element.name=this.actual.name){
          baux=true
          this.actual=element
          console.log(this.actual)}
        else{if(element.children){if(element.children.length>0){this.buscarArbol(element.children)}}}
      })}}

crearValor(nombre:string,padre:string){                // mete el elemento en el primer elemento, no en el que deberia
  console.log(nombre,padre)
  console.log(this.actual.crearHijo(nombre,padre))
  // falta meter el hijo en la lista del padre

}
}
