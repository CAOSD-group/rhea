import { Component} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { Arbol } from './components/arbol_pruebas/arbol';
import{Const} from './components/constrain/const';
import {MatDialog,} from '@angular/material/dialog';
import { event } from 'jquery';




var aux:any;
var aux2:any=""
var aux3: any;
var jsonconstrain: any;
var jsonfeatures:string
let baux=false;
var diccionario:any



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
  declare padre:Arbol      //valor actual del padre del actual arbol
  tree:Array<Arbol> =[new Arbol()]  // el arbol de datos 
  cons:Array<Const>=[new Const()]
  declare json_nombre:any;    //guardo los valores de las features
  declare json_const:any;     //guardo los valores de las constraints
  dictconst:Map<string,Object>=new Map<string,Object>();
  treeControl = new NestedTreeControl<Arbol>(node => node.children);
  dataSource = new MatTreeNestedDataSource<Arbol>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();

  
    
    //lista de constrains y nombres de las features
    tiposconstrains:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','Xor','Xand','doubleImpliesTerm']
    nombresFeatures:Array<string>=[]
    crearConstrains:Array<string>=[]
  //otros
  item:string ='Truck.uvl';
  texto1="Ocultar Constrains";
  texto2=this.item;
  // modificar o crear arbol
  nombre:string="";
  optional:boolean=false;
  abstract:boolean=false;
  type:string ="";
  card_min:number=0;
  card_max:number=0;


  
constructor(private http: HttpClient,public dialog: MatDialog) { }  
ngOnInit() {}
//orden : saveFM;downloadFM (2 ways) ;createFM;
// metodos de modificacion,creacion y eliminacion de valores
// otros metodos



saveFile(texto?:string){ // envio el nuevo archivo y el nuvo nombre opcional
  this.pasoajson()  //actualizo los valores del json
  if(texto==undefined || texto==""){
    console.log("sin cambio de nombre")
    this.http.post(this.urlsave,[jsonfeatures,jsonconstrain],{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)})}
  else{
    console.log("el nombre se cambia")
    this.http.post(this.urlsave,[texto,jsonfeatures,jsonconstrain],{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)
  })}
}
returnValues(texto?:string){
  if(texto==""){texto=this.item}
  if(texto==undefined){texto=this.item}
  this.http.post(this.urldownload,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.item=texto||"";
    this.texto2=this.item
    this.articulos=JSON.parse(this.articulos)
    this.json_nombre=this.articulos.features,
    this.json_const=this.articulos.constraints

    aux2=""
    diccionario = Object.assign({}, resultado);
    for( const[key] of Object.entries(diccionario)){
      aux2=aux2+diccionario[key]
  }
    aux=JSON.parse(aux2)
    aux3=aux.constraints
    this.crearCons()
    this.crearArbol()
  })
}
getArchivo(texto?:string){
  this.http.post(this.urldownload,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.item=texto||"";
    this.texto2=this.item
    this.articulos=JSON.parse(this.articulos)
    this.json_nombre=this.articulos.features,
    this.json_const=this.articulos.constraints

    aux2=""
    diccionario = Object.assign({}, resultado);
    for( const[key] of Object.entries(diccionario)){
      aux2=aux2+diccionario[key]
  }
    aux=JSON.parse(aux2)
    aux3=aux.constraints
    console.log("vengo por aqui")
    this.crearCons()
    this.crearArbol()
  })
}

createFile(texto:string){  // envia el nombre del archivo a crear y el archivo a crear (1 o 2 pasos?)
  this.pasoajson()
  console.log("valores que se van a crear")
  console.log(jsonfeatures)
  console.log(jsonconstrain)
  this.http.post(this.urlcreate,[texto,jsonfeatures,jsonconstrain],{responseType:'text'}).subscribe(resultado => {
    //¿que pasa si el nombre ya existe?
    console.log(resultado)
  })
}



//descargar el fichero y lo envia al servidor (mirar ejemplo FM-SPL carpetas bucador)
//constrains van a tener forma de texto (mantener forma arbol)
//cambios manuales  un boton para enviar al server 

//  documentacion explicar que hace cada metodo, las referencias que tiene
//  explicar los elementos y que parametros tienen y los codigos que se usan


// Consultar las esperas de tiempo
// 
//  Consultas de visualicacion de la pagina web
//    Que formato final se va a aplicar
//        Diseño grafico estatico y dinamico
//        Paleta de colores
//        Imagenes y simbolos
//        Sidnav que se cierren automatico
  


modificarSeleccion(){
  if(this.actual.name!=this.nombre && this.actual.evitaDuplicados(this.nombre)){
    alert("este nombre ya existe, por favor use otro")
  }
  else{
  this.actual.name=this.nombre
  if(this.actual.children==undefined){
    alert("has intentado modificar un objeto que no tiene 2 o mas hijos")
  }
  if(this.actual.children!=undefined){
  if(this.actual.children.length<2){
    alert("has intentado modificar un objeto que no tiene 2 o mas hijos")
  }
  else{
  this.actual.type=this.type
  this.actual.card_max=this.card_max
  this.actual.card_min=this.card_min
  alert("no se comprueba que el tipo tenga concordancia con el maximo y minimo")
}}
  this.actual.optional=this.optional
  this.actual.abstract=this.abstract
}
console.log(this.actual)
}
borrarRama(){
  this.actual.borrar(this.padre)
  console.log(this.actual)
  this.borrarArbol()
  this.recargarArbol()
}
CrearHijo(){
  if(this.actual.evitaDuplicados(this.nombre)){
    alert("este nombre ya existe, por favor use otro")
  }
  else{
  if(this.actual.children==undefined){this.actual.children=[]}
  this.actual.children.push(this.actual.creardeafault(this.nombre))
  this.borrarArbol()
  this.recargarArbol()}
}
CrearHermano(){
  if(this.actual.evitaDuplicados(this.nombre)){
    alert("este nombre ya existe, por favor use otro")
  }
  else{
  if(this.padre==undefined){
    alert("estas intentando crear una raiz")
  }
  else{
  this.padre.children.push(this.actual.creardeafault(this.nombre))
  this.borrarArbol()
  this.recargarArbol()
}}
}





constrainhasChild = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;


crearCons(){
  console.log("creo constrains")
  this.cons.splice(0,this.cons.length)
  aux=[new Const()]
  aux2=[new Const()]
  jsonconstrain=aux[0].CrearConstrain2(aux3)
  this.cons=aux2[0].CrearConstrain(this.json_const)
  this.constraindataSource.data=this.cons
}

crearArbol(){
  console.log("creo arbol")
  this.tree.splice(0,this.tree.length)
  this.tree=[new Arbol()]
  this.tree[0].borrarLista();
  this.tree=this.tree[0].CrearArbol(this.json_nombre)
  this.nombresFeatures=this.tree[0].listanombres();
  this.tree[0]=this.tree[0].meterHijos(this.json_nombre);
  this.tree.splice(1,this.tree.length)
  this.tree[0].limpiarArbol()
  console.log(this.tree)
  this.dataSource.data=this.tree
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

readThis(inputValue: any): void { 
 
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
        aux3=aux2
        console.log("estoy en espera")
        console.log("falla aux3 por la duplicacion del diccionario")
        this.crearCons()
        this.crearArbol()}
      },
      2000);
      this.item=file.name;
      this.texto2=this.item;
  }
  

seleccionar(id:string,lista?:Array<any>,padre?:any){  // este devuelve un objeto tipo Object
  aux2=this.tree[0].name
  if(lista==null){lista=this.tree}
  if(lista.filter(x=> x.name==id)[0]==undefined){
    lista.forEach(element => {
      if(element.children){
      if(element.children.length>0){
        this.seleccionar(id,element.children,element)
      }}
    });
  }else{
    this.actual=lista.filter(x=> x.name==id)[0]
    this.padre=padre
    this.nombre=this.actual.name
    this.type=this.actual.type
    this.optional=this.actual.optional
    this.abstract=this.actual.abstract
    this.card_max=this.actual.card_max
    this.card_min=this.actual.card_min
    console.log(this.actual)
    console.log(this.padre)
    this.tree[0].name=aux2
  }
  }

togglevisibility(){
  if(this.texto1=="Ocultar Constrains"){
  this.texto1="Mostrar Constrains"
  this.texto2=""
  this.constraindataSource.data=[]
  }
  else{
    this.texto1="Ocultar Constrains"
    this.texto2=this.item
    this.constraindataSource.data=this.cons
  }
}


ContrainsToDictionary(){
  aux=0
  while(aux<this.cons.length){
    aux++
    aux2='CTC'+aux
    this.dictconst.set(aux2,this.cons[aux-1])
  }
}

openDialog() {
  const dialogRef = this.dialog.open(DialogContentExampleDialog);
  dialogRef.afterClosed().subscribe(result => {
    console.log(`Dialog result: ${result}`);
  });
}

pasoajson(){
  aux3=this.tree[0]
  aux3.treeControl=null
  aux3.aux=null
  aux3.dataSource=null
  jsonfeatures=JSON.stringify(aux3, (key, value) => {
    if (value !== null) return value
  })
  //jsonfeatures='"'+'name'+'"'+':'+'"'+ this.item+'"'+','+'"'+"features"+'"'+':'+jsonfeatures
  jsonconstrain=JSON.stringify(jsonconstrain)
  jsonconstrain=jsonconstrain.slice(1,jsonconstrain.length-1)
  alert("fallan los { } ")
  //alert("a los json les faltaria incluir el nombre y el features;--constrains:--")
  //alert("en los constrains habria que mirar el tema de diccionario key-value")

}

CreoConstrain(valor:string){
  if(valor=="NotTerm")
  {
    if(this.crearConstrains[this.CreoConstrain.length-1]=="AndTerm" 
    || this.crearConstrains[this.CreoConstrain.length-1]=="OrTerm" 
    || this.crearConstrains[this.CreoConstrain.length-1]=="ImpliesTerm" 
    || this.crearConstrains[this.CreoConstrain.length-1]=="Xor" 
    || this.crearConstrains[this.CreoConstrain.length-1]=="Xand"
    || this.crearConstrains[this.CreoConstrain.length-1]=="Xand"
    || this.crearConstrains[this.CreoConstrain.length-1]=="doubleImpliesTerm"){

     }
  }
  else{
  if(valor=="AndTerm" || valor=="OrTerm" || valor=="ImpliesTerm" || valor=="Xor" || valor=="Xand" || valor=="doubleImpliesTerm" )
  {
    // toca faetureTerm o not
  }
  if(valor!="AndTerm" && valor!="OrTerm" && valor!="ImpliesTerm" && valor!="Xor" && valor!="Xand" && valor!="doubleImpliesTerm")
  {
    //toca condicionales o final
  }}
}


SimboloPorTipo(tipo:string){
  if(tipo=="FEATURE"){
    aux='add'
  }
  if(tipo=="XOR"){
    aux='menu'
  }
  if(tipo=="XOR"){
    aux='sentiment_very_satisfied'
  }
  if(tipo=="OR"){
    aux='pages'
  }
  return aux
}

onRightClick($event) {
  alert("hola")
  return true
}

}
@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: './dialog-content-example-dialog.html',
})
export class DialogContentExampleDialog {
  sirvo(texto:string){
    console.log(texto)
    alert(texto)
  }
}
