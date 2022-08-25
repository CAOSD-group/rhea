import { Component} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { Arbol } from './components/arbol_pruebas/arbol';
import{Const} from './components/constrain/const';
import {MatDialog,} from '@angular/material/dialog';



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
    //lista de constrains y nombres de las features
    tiposconstrains:Array<string>=['OrTerm','AndTerm','NotTerm','ImpliesTerm']
    nombresFeatures:Array<string>=[]
  //otros
  item:string ='Pizzas.uvl';
  texto1="Ocultar Constrains";
  texto2=this.item;


  
constructor(private http: HttpClient,public dialog: MatDialog) { }  
ngOnInit() {}
//order : saveFM;downloadFM (2 ways) ;deleteFM;createFM; metodos auxiliares 



saveFile(texto?:string){ // envio el nuevo archivo y el nuvo nombre opcional
  // envia el treeControl (supongo que se borra aqui o alli o no da problemas)
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
  console.log("valores que se van a crear")
  console.log(jsonfeatures)
  console.log(jsonconstrain)
  this.http.post(this.urlcreate,[texto,jsonfeatures,jsonconstrain],{responseType:'text'}).subscribe(resultado => {
    //¿que pasa si el nombre ya existe?
    console.log(resultado)
  })
}










//    Arbol
//      Preguntar cuales van a ser los parametros finales del sistema
//          Preguntar cuales de ellos hay que decidir en el momento de creacion de un elemento
//          Preguntar cuales de ellos se van a poder modificar (todos?)
//          Consider los problemas cuando se borra una rama en las Constrains
//          Pueden haber elementos duplicados?
//    Constrains
//      Crear constrains con algun tipo de implementacion(Moore/Mealy)?
//      Modificar constrains asegurandonos de que no exista ya de antes?
//      Modificar constrains asegurandonos de que no sean contradictorias?
//      Formato para crear y modificar igual o diferente
//      
//
// Consultar con jose miguel las funciones del servidor
//     Como deberiana funcionar los metodos
//        Guardar/Actualizar
//          Comprobar validez del sistema
//          Comprobar si se cambia el nombre que pasa
//          Se debe actualizar manualmente o automaticamente siempre que haya un cambio
//              Confirmar modificaciones ha realizar?
//        Cargar                                                           Implementado¿?
//        Borrar
//          Alertas para reconsiderar? 
//        Crear
//          Crear uno vacio, o desde el modelo actual 
//              ((revisar pregunta de guardar automaticamente los cambios))
//          Comprobar si ya existe el nombre
//          Comprobar validez del sistema
// 
//  Consultas de visualicacion de la pagina web
//    Que formato final se va a aplicar
//        Diseño grafico estatico y dinamico
//        Paleta de colores
//        Imagenes y simbolos
//    Tenemos que considerar otros navegadores web ademas de google Chrome?
//    
//   OTROS CODIGOS
//      Arbol
//        Se deben meter solo los features no abstract¿?
//      Constrain
//        Que pasa con el Xor o con el Xand,no existen o si











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
        console.log("estoy en espera")
        this.crearCons()
        this.crearArbol()}
      },
      2000);
      this.item=file.name;
      this.texto2=this.item;
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
  console.log(padre)
  console.log(nombre)
  console.log(this.actual.crearHijo(nombre,padre))
  // falta meter el hijo en la lista del padre

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

eligochip(texto:string){
  console.log(texto)
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
  jsonconstrain=JSON.stringify(jsonconstrain)
  console.log(jsonfeatures)
  console.log(jsonconstrain)

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
