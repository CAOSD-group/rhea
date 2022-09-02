import { ANALYZE_FOR_ENTRY_COMPONENTS, Component} from '@angular/core';
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
var jsonconstrain: Array<Const>=[new Const()] 
var constrainTexto:string;
var jsonfeatures:string
var diccionario:any
var listaconstrain:Array<Const>=[]
var posicion:number;



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
  declare consactual:Const      //valor actual del arbol
  declare padre:Arbol      //valor actual del padre del actual arbol
  declare conspadre:Const      //valor actual del padre del actual arbol
  tree:Array<Arbol> =[new Arbol()]  // el arbol de datos 
  cons:Array<Const>=[new Const()]   // El arbol de constrains con el nombre en la rama final
  //declare json_nombre:any;    //guardo los valores de las features
  //declare json_const:any;     //guardo los valores de las constraints
  dictconst:Map<string,Object>=new Map<string,Object>();
  treeControl = new NestedTreeControl<Arbol>(node => node.children);
  dataSource = new MatTreeNestedDataSource<Arbol>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();

  
    
  //lista de constrains y nombres de las features
  tiposconstrains:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','Xor','Xand','doubleImpliesTerm']
  tablachips:Array<string>=[]
  nombresFeatures:Array<string>=[]
  nombreschips:Array<string>=[]
  crearConstrains:Array<string>=[]
  //otros
  item:string ='MobileMedia.xml';
  texto1="Ocultar Constrains";
  texto3="Ocultar chips";
  texto4="Ocultar Arbol";
  texto2=this.item;
  jsonconstrainTexto: Array<string>=[]
  // modificar o crear arbol
  nombre:string="";
  optional:boolean=false;
  abstract:boolean=false;
  type:string ="";
  card_min:number=0;
  card_max:number=0;
  ncons:string="";

  
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
    jsonfeatures=this.articulos.features,
    jsonconstrain=this.articulos.constraints

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
    jsonfeatures=this.articulos.features,
    jsonconstrain=this.articulos.constraints
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

//cambios manuales un boton para enviar al server 

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
}
borrarRama(){
  this.actual.borrar(this.padre)
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
  aux2=0
  if(true){    //Porque hace falta poner el if para que no de error la siguiente linea?
  [jsonconstrain,this.jsonconstrainTexto]=aux[0].CrearConstrain(aux3)
  while(aux2<jsonconstrain.length){
  jsonconstrain[aux2]=aux[0].CreanuevaConstrain(jsonconstrain[aux2])
  aux2++}
  this.cons=aux[0].crearListaBuena(jsonconstrain)
  jsonconstrain=aux[0].buscar(jsonconstrain)
  console.log(jsonconstrain)
  this.constraindataSource.data=this.cons
  this.texto3="Mostrar chips"
  this.texto1="Ocultar Constrains"
  this.texto4="Ocultar Arbol"
  this.tablachips=[]
  this.nombreschips=[]
}
  
}

crearArbol(){
  console.log("creo arbol")
  this.tree.splice(0,this.tree.length)
  this.tree=[new Arbol()]
  this.tree[0].borrarLista();
  this.tree=this.tree[0].CrearArbol(jsonfeatures)
  this.nombresFeatures=this.tree[0].listanombres();
  this.tree[0]=this.tree[0].meterHijos(jsonfeatures);
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
        jsonfeatures=aux
        jsonconstrain=aux2
        aux3=aux2
        this.crearCons()
        this.crearArbol()}
      },
      2000);
      this.item=file.name;
      this.texto2=this.item;
  }
  
/* fuera de uso pero funciona
seleccionar2Opcional(id:string,lista?:Array<any>,padre?:any){  
  aux2=this.tree[0].name
  if(lista==null){lista=this.tree}
  if(lista.filter(x=> x.name==id)[0]==undefined){
    lista.forEach(element => {
      if(element.children){
      if(element.children.length>0){
        this.seleccionar2Opcional(id,element.children,element)
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
    this.tree[0].name=aux2
  }
  }*/
  seleccionar(objeto:any){
    this.actual=objeto
    this.nombre=this.actual.name
    this.type=this.actual.type
    this.optional=this.actual.optional
    this.abstract=this.actual.abstract
    this.card_max=this.actual.card_max
    this.card_min=this.actual.card_min
    this.buscarPadreArbol(objeto)
    console.log(this.actual)
  }
 
  buscarPadreArbol(objeto:any,lista?:Array<any>,padre?:any){
    if(lista==null){lista=this.tree}
    if(lista.filter(x=> x==objeto)[0]==undefined){
      lista.forEach(element => {
        if(element.children){
        if(element.children.length>0){
          this.buscarPadreArbol(objeto,element.children,element)
        }}
      });
    }else{
      this.padre=padre
    }
  }
  seleccionarCons(objeto:any){
    this.buscarPadreConst(objeto)
    aux2=0
    while (aux2<this.cons.length) {
    if(this.cons[aux2]==objeto ){posicion=aux2}
    aux2++
  }
  this.consactual=objeto
  
  this.ncons=this.jsonconstrainTexto[posicion]
  console.log(this.consactual)
  }
  buscarPadreConst(objeto:any,lista?:Array<any>,padre?:any){
    if(lista==null){lista=this.cons}
    if(lista.filter(x=> x==objeto)[0]==undefined){
      lista.forEach(element => {
        if(element.operands){
        if(element.operands.length>0){
          this.buscarPadreConst(objeto,element.operands,element)
        }}
      });
    }else{
      this.conspadre=padre
    }
  }

  borrarCons(){
    if(this.consactual!=undefined){
      if(this.conspadre!=undefined){
        aux2=0
      while(aux2<this.conspadre.operands.length){
        if(this.conspadre.operands[aux2]==this.consactual){
          aux=aux2
          aux2++
        }
        else{aux2++}
      }
        this.conspadre.operands.splice(aux,1)
      }
      else{
        this.cons.splice(posicion,1)
        this.borrarConsText()
      }
    }
    this.borrarArbol()
    this.recargarArbol()
  }

  Crearlistaconstrain(){
    if(listaconstrain.length==2){
      listaconstrain[0].operands.push(listaconstrain[1]);
      listaconstrain[0].operands.splice(0,1);
    }
    if(listaconstrain.length>2){
      this.consactual.listaConstrains(listaconstrain)
    }
    return listaconstrain[0]
  }

  ModificarCons(){
    if(listaconstrain.length!=0&&listaconstrain!=undefined){
      this.Crearlistaconstrain()

    if(this.conspadre==undefined){
      this.cons[posicion]=listaconstrain[0]}

    if(this.conspadre!=undefined){
      aux2=0
      while(aux2<this.conspadre.operands.length){
        if(this.conspadre.operands[aux2]==this.consactual){
          aux=aux2
          aux2++
        }
        else{aux2++}
      }
      this.conspadre.operands[aux]=listaconstrain[0]}
    }
    this.borrarArbol()
    this.recargarArbol()
    listaconstrain=[]
  }


togglevisibility(){
  if(this.texto1=="Ocultar Constrains"){
  this.texto1="Mostrar Constrains"
  this.constraindataSource.data=[]
  }
  else{
    this.texto1="Ocultar Constrains"
    this.constraindataSource.data=this.cons
  } 
}

togglevisibilityarbol(){
  if(this.texto4=="Ocultar Arbol"){
  this.texto4="Mostrar Arbol"
  this.texto2=""
  this.dataSource.data=[]
  }
  else{
    this.texto4="Ocultar Arbol"
    this.texto2=this.item
    this.dataSource.data=this.tree
  }
}
togglevisibilitychips(){
  if(this.texto3=="Ocultar chips"){
  this.texto3="Mostrar chips"
  this.tablachips=[]
  this.nombreschips=[]
  }
  else{
    this.texto3="Ocultar chips"
    this.tablachips=this.tiposconstrains
    this.nombreschips=this.nombresFeatures
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
  jsonfeatures=JSON.stringify(jsonfeatures, (key, value) => {
    if (value !== null) return value
  })
  //jsonfeatures='"'+'name'+'"'+':'+'"'+ this.item+'"'+','+'"'+"features"+'"'+':'+jsonfeatures
  //jsonconstrain=JSON.stringify(jsonconstrain, (key, value) => {if (value !== null) return value})
  //jsonconstrain=jsonconstrain.slice(1,jsonconstrain.length-1)
  console.log(jsonconstrain)
  alert("PARA LAs COnstrians USAR LA QUE MANTIENE EL TYPOE FEATURE MODEL")
  //alert("a los json les faltaria incluir el nombre y el features;--constrains:--")
  //alert("en los constrains habria que mirar el tema de diccionario key-value")

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
/*
onRightClick($event) {
  alert("hola")
  return true
}*/
cambioseleccionado(v){
  aux2=0
  while (aux2<this.jsonconstrainTexto.length) {
    if(this.jsonconstrainTexto[aux2]==v ){posicion=aux2}
    aux2++
  }
  constrainTexto=v;
  this.ncons=v
  console.log(this.ncons)
}
ModificarConsText(){
  aux=-1
  this.jsonconstrainTexto.forEach(element => {
    aux++;
    if(element==constrainTexto){
      this.jsonconstrainTexto[aux]=this.ncons
    }
  });
}
CrearConslista(){
  if(listaconstrain!=undefined && listaconstrain.length!=0){
    this.Crearlistaconstrain()
    jsonconstrain.push(listaconstrain[0])
  }
  listaconstrain=[]
  this.constraindataSource.data=this.cons
}

CrearConshermano(){
  if(this.conspadre!=undefined){
  if(listaconstrain!=undefined && listaconstrain.length!=0){
    this.Crearlistaconstrain()
    this.conspadre.operands.push(listaconstrain[0])
  }}
  else{this.CrearConslista(); alert("no habia padre por lo que se creo una nueva")}
  listaconstrain=[]
  this.borrarArbol()
  this.recargarArbol()
}

CrearConshijo(){
  if(this.consactual!=undefined){
  if(listaconstrain!=undefined && listaconstrain.length!=0){
    this.Crearlistaconstrain()
    if(this.consactual.operands==null || this.consactual.operands==undefined ){
      this.consactual.operands=[]
      this.consactual.operands.push(listaconstrain[0])
    }
    else{
    this.consactual.operands.push(listaconstrain[0])}
  }}
  else{this.CrearConslista(); alert("no habia padre por lo que se creo una nueva")}
  listaconstrain=[]
  this.borrarArbol()
  this.recargarArbol()
}


borrarConsText(){
  this.jsonconstrainTexto[posicion]=""
  this.jsonconstrainTexto=this.jsonconstrainTexto.filter(x=>x!="")
  this.borrarArbol()
  this.recargarArbol()
}


eligochiplogic(texto:string){
  aux=new Const()
  aux.type=texto
  if(texto=="NotTerm"){
    aux.operands=[new Const()]
  }else{
    aux.operands=[new Const(),new Const()]
  }
  listaconstrain.push(aux)
  console.log(listaconstrain)
}

eligochipfeature(texto:string){
  aux=new Const()
  aux.type=texto
  aux.operands=[]
  listaconstrain.push(aux)
  console.log(listaconstrain)
}

}
@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: './dialog-content-example-dialog.html',
})
export class DialogContentExampleDialog {
  sirvo(texto:string){
    alert(texto)
  }
}
