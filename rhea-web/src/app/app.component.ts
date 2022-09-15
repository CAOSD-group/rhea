import {Component} from '@angular/core';
import {HttpClient, HttpParams } from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {FMTree} from './components/FMTree_pruebas/FMTree';
import{Const} from './components/constraint/const';
import {MatDialog} from '@angular/material/dialog';
import * as saveAs from 'file-saver';




var aux:any;
var aux2:any=""
var aux3: any;
let symbol:any; // evita solapar valores en los auxiliares 
var jsonconstraint: Array<Const>=[new Const()] 
var jsonfeatures:string
var dictionary:any
var listofconstraint:Array<Const>=[]
var position:number;

var listnamesconstraints:Array<string>=[]
var listnamestext:Array<string>=[]
var json:string



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  urlsave="http://172.16.51.94:5000/saveFM" //servidor guardar datos
  urldownload="http://172.16.51.94:5000/downloadFM"  //servidor cargar datos
  urlupload="http://172.16.51.94:5000/uploadFM"  //servidor cargar datos
  urldownload2="http://172.16.51.94:5000/downloadFM2"  //servidor cargar datos
  urldelete="http://172.16.51.94:5000/deleteFM"  //servidor cargar datos
  urlcreate="http://172.16.51.94:5000/createFM" //servidor guardar datos
  documents:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];
  //file: File | null = null;
  title:string ='rhea-web' // evita un error en app.component.spec.ts
  declare actual:FMTree      //valor actual del FMTree
  consactual:Const =new Const()     //valor actual del FMTree
  declare actualfather:FMTree      //valor actual del actualfather del actual FMTree
  consactualfather:Const =new Const()     //valor actual del actualfather del actual FMTree
  tree:Array<FMTree> =[new FMTree()]  // el FMTree de datos 
  cons:Array<Const>=[new Const()]   // El FMTree de constraints con el name en la rama final
  //declare json_nombre:any;    //guardo los valores de las features
  //declare json_const:any;     //guardo los valores de las constraints
  treeControl = new NestedTreeControl<FMTree>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FMTree>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();

  
    
  //list de constraints y nombres de las features
  typesofcons:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','Xor','Xand','doubleImpliesTerm']
  tablechips:Array<string>=[]
  namesFeatures:Array<string>=[]
  nameschips:Array<string>=[]
  //otros
  titulo:string='';
  item:string ='Pizzas.uvl';
  text1="Hide Constraints";
  text3="Hide chips";
  text4="Hide Tree";
  text2=this.item;
  jsonconstraintTexto: Array<string>=[]
  // modificar o crear FMTree
  name:string="";
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



saveFile(text?:string){ // envio el nuevo archivo y el nuvo name opcional
  this.TransformJSON()  //actualizo los valores del json
  if(text==undefined || text==""){
    console.log("sin cambio de name")
    this.http.post(this.urlsave,[jsonfeatures,jsonconstraint],{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)})}
  else{
    console.log("el name se cambia")
    this.http.post(this.urlsave,[text,jsonfeatures,jsonconstraint],{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)
  })}
}






sendJSON(){
  console.log(aux)
  this.http.post(this.urldownload2,aux,{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)})
}





sendUVL(uvl:any){
  let body ={'inputFM': uvl}
  console.log(uvl)
  console.log(body)
  this.http.post(this.urlupload,uvl,{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)})

}




returnValues(text?:string){
  if(text==""){text=this.item}
  if(text==undefined){text=this.item}
  this.http.post(this.urldownload,text,{responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado,text)
  })
}
CreateData(object:any,name?:string){
    aux = object;
    this.item=name||"";
    this.text2=this.item
    aux=JSON.parse(aux)
    this.titulo=aux.name
    console.log(this.titulo)
    jsonfeatures=aux.features,
    jsonconstraint=aux.constraints
    aux2=""
    dictionary = Object.assign({}, object);
    for( const[key] of Object.entries(dictionary)){
      aux2=aux2+dictionary[key]
  }
    aux=JSON.parse(aux2)
    aux3=aux.constraints
    this.CreateCons()
    this.CreateFMTree()
}

CreateFile(text:string){  // envia el name del archivo a crear y el archivo a crear (1 o 2 pasos?)
  this.TransformJSON()
  console.log("valores que se van a crear")
  console.log(jsonfeatures)
  console.log(jsonconstraint)
  this.http.post(this.urlcreate,[text,jsonfeatures,jsonconstraint],{responseType:'text'}).subscribe(resultado => {
    //¿que pasa si el name ya existe?
    console.log(resultado)
  })
}



//SymbolPerType esta constantemente llamandose, alguna opcion?

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
  


ModifySelecction(){
  aux=this.actual.name
  if(this.actual.name!=this.name && this.actual.AvoidDuplicates(this.name)){
    alert("this name is already in use")
  }
  else{
  this.actual.name=this.name
  if(this.actual.children==undefined){}
  if(this.actual.children!=undefined){
  if(this.actual.children.length<2){
  }
  else{
  this.actual.type=this.type
  this.actual.card_max=this.card_max
  this.actual.card_min=this.card_min
}}
  this.actual.optional=this.optional
  this.actual.abstract=this.abstract

this.namesFeatures=this.tree[0].ListOfNamesModified(this.actual.name,aux)
this.cons[0].checkName(this.cons,this.actual.name,aux)
}
}
DeleteNode(){
  this.actual.Delete(this.actualfather)
  this.ReloadFMTree()
}
CreateChildren(){
  if(this.actual.AvoidDuplicates(this.name)){
    alert("this name is already in use")
  }
  else{
  if(this.actual.children==undefined){this.actual.children=[]}
  this.actual.children.push(this.actual.CreateDefault(this.name))
  this.ReloadFMTree()
  console.log(this.name)
  this.tree[0].ExpandList(this.name)}
}
CreateBrother(){
  if(this.actual.AvoidDuplicates(this.name)){
    alert("this name is already in use")
  }
  else{
  if(this.actualfather==undefined){
    alert("You are trying to create a new root")
  }
  else{
  this.actualfather.children.push(this.actual.CreateDefault(this.name))
  this.ReloadFMTree()
  console.log(this.name)
  this.tree[0].ExpandList(this.name)
}}
}





constrainthasChild = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;


CreateCons(){
  console.log("creo constraints")
  position=-1
  this.cons.splice(0,this.cons.length)
  aux2=0
  if(true){    //Porque hace falta poner el if para que no de error la siguiente linea?
  [jsonconstraint,this.jsonconstraintTexto,listnamesconstraints]=this.consactual.CreateConstraint(aux3)
  while(aux2<jsonconstraint.length){
  jsonconstraint[aux2]=this.consactual.CreateNewConstraint(jsonconstraint[aux2])
  aux2++}


  this.cons=this.consactual.createListForTree(jsonconstraint)
  //console.log(jsonconstraint)
  jsonconstraint=this.consactual.TransformToCons(jsonconstraint)
  jsonconstraint=aux3
  console.log(this.cons)
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==position)
  this.text3="Show chips"
  this.text1="Hide Constraints"
  this.text4="Hide FMTree"
  this.tablechips=[]
  this.nameschips=[]
}
  
}

CreateFMTree(){
  console.log("creo FMTree")
  this.tree.splice(0,this.tree.length)
  this.tree=[new FMTree()]
  this.tree[0].DeleteList();
  this.tree=this.tree[0].CrearNewFMTree(jsonfeatures)
  this.namesFeatures=this.tree[0].ListOfNames();
  this.tree[0]=this.tree[0].IncorporateChildren(jsonfeatures);
  this.tree.splice(1,this.tree.length)
  this.tree[0].CleanFMTree()
  console.log(this.tree)
  this.dataSource.data=this.tree
}

DeleteFMTree(){
  this.dataSource.data=[]
  this.constraindataSource.data=[]
}

ReloadFMTree(){
  this.DeleteFMTree()
  this.dataSource.data=this.tree
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==position)
  if(this.consactual==undefined){ this.consactual=new Const()}
}

changeListener($event): void {this.readThis($event.target);}

readThis(inputValue: any): void { 
    aux=""
    var file: File = inputValue.files[0];
    var myReader: FileReader = new FileReader();
    myReader.readAsText(file);
    myReader.onloadend = function (e) { aux=myReader.result }
    if(file.name.endsWith('.json')){
      console.log("llega json")
      setTimeout(() => {
      this.CreateData(aux,"hola")
      },100)
    }
    if(file.name.endsWith('.uvl')){
      console.log("llega uvl")
      setTimeout(() => {
        this.sendUVL(file)
        },100)
    }

  
  
}
  
  select(object:any){
    this.actual=object
    this.name=this.actual.name
    this.type=this.actual.type
    this.optional=this.actual.optional
    this.abstract=this.actual.abstract
    this.card_max=this.actual.card_max
    this.card_min=this.actual.card_min
    this.TransformToConsPadreFMTree(object)
    console.log(this.actual)
  }
 
  TransformToConsPadreFMTree(object:any,list?:Array<any>,actualfather?:any){
    if(list==null){list=this.tree}
    if(list.filter(x=> x==object)[0]==undefined){
      list.forEach(element => {
        if(element.children){
        if(element.children.length>0){
          this.TransformToConsPadreFMTree(object,element.children,element)
        }}
      });
    }else{
      this.actualfather=actualfather
    }
  }
  SelectCons(object:any){
    this.TransformToConsPadreConst(object)
    position=this.cons.indexOf(object) 
    this.consactual=object
    this.ncons=this.jsonconstraintTexto[position] // se supone que siempre que lo podre obtener cuando se actualice con los valores del server
    console.log(this.consactual)
  }

  TransformToConsPadreConst(object:any,list?:Array<any>,actualfather?:any){
    if(list==null){list=this.cons}
    if(list.filter(x=> x==object)[0]==undefined){
      list.forEach(element => {
        if(element.operands){
        if(element.operands.length>0){
          this.TransformToConsPadreConst(object,element.operands,element)
        }}
      });
    }else{
      this.consactualfather=actualfather
    }
  }

  DeleteCons(){
    if( this.consactual.type=='' && position!= undefined && position!=-1){
      this.cons.splice(position,1)
      this.DeleteConsText()
      position=-1
    }
    if(this.consactual!=undefined){
      if(this.consactualfather!=undefined &&this.consactualfather.type!=""){
        aux2=0
      while(aux2<this.consactualfather.operands.length){
        if(this.consactualfather.operands[aux2]==this.consactual){
          aux=aux2
          aux2++
        }
        else{aux2++}
      }
        console.log(aux)
        this.consactualfather.operands.splice(aux,1)
        
      }
      else{
        if(position!=-1){
        this.cons.splice(position,1)
        this.DeleteConsText()
        position=-1}
      }
    }
    if(this.cons.length==0){this.cons.push(new Const)}
    this.SelectedChange(this.ncons)
    this.ReloadFMTree()
  }

  CreateListCons(){
    if(listofconstraint.length==2){
      listofconstraint[0].operands.push(listofconstraint[1]);
      listofconstraint[0].operands.splice(0,1);
    }
    if(listofconstraint.length>2){
      console.log(listofconstraint)
      
      listofconstraint[0]=this.consactual.ListOfNewConstraint(listofconstraint)
    }
    console.log(listofconstraint[0])
    return listofconstraint[0]
  }

  ModifyCons(){
    if(listofconstraint.length!=0&&listofconstraint!=undefined){
      this.CreateListCons()

    if(this.consactualfather==undefined ||  this.consactualfather.type==""){
      console.log("1")
      this.cons[position]=listofconstraint[0]
      this.jsonconstraintTexto[position]="New value" +position
    }

    if(this.consactualfather!=undefined  ){
      console.log("2")
      aux2=0
      while(aux2<this.consactualfather.operands.length){
        console.log("3")
        if(this.consactualfather.operands[aux2]==this.consactual){
          aux=aux2
          aux2++
        }
        else{aux2++}
      }
      console.log(position)
      this.consactualfather.operands[aux]=listofconstraint[0]
    }
    }
    this.ReloadFMTree()
    listofconstraint=[]
  }


togglevisibility(){
  if(this.text1=="Hide Constraints"){
  this.text1="Show Constraints"
  this.constraindataSource.data=[]
  }
  else{
    this.text1="Hide Constraints"
    this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==position)
  } 
}

togglevisibilityFMTree(){
  if(this.text4=="Hide FMTree"){
  this.text4="Show FMTree"
  this.text2=""
  this.dataSource.data=[]
  }
  else{
    this.text4="Hide FMTree"
    this.text2=this.item
    this.dataSource.data=this.tree
  }
}
togglevisibilitychips(){
  if(this.text3=="Hide chips"){
  this.text3="Show chips"
  this.tablechips=[]
  this.nameschips=[]
  }
  else{
    this.text3="Hide chips"
    this.tablechips=this.typesofcons
    this.nameschips=this.namesFeatures
    console.log(this.namesFeatures)
  }
}



openDialog() {
  const dialogRef = this.dialog.open(DialogContentExampleDialog);
  dialogRef.afterClosed().subscribe(result => {
    console.log(`Dialog result: ${result}`);
  });
}






SymbolPerType(type:string){ 
  if( type.toUpperCase().startsWith("FEATURE")){
    symbol='add'
  }
  if(type=="XAND"){
    symbol='menu'
  }
  if(type=="XOR"){
    symbol='sentiment_very_satisfied'
  }
  if(type=="OR"){
    symbol='pages'
  }
  if(type!="OR"&& type!="XOR" && !type.toUpperCase().startsWith("FEATURE") &&type!="XAND"){
    symbol='help_outline'
  }
  return symbol
}

onRightClick($event) {
  return true
}
SelectedChange(v){
  aux2=0
  while (aux2<this.jsonconstraintTexto.length) {
    if(this.jsonconstraintTexto[aux2]==v ){position=aux2}
    aux2++
  }
  this.ncons=v
  this.consactual=this.cons[position]
  console.log(this.consactual)
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==position)
}
CreateConsList(){
  if(listofconstraint!=undefined && listofconstraint.length!=0){
    this.CreateListCons()
    position=this.jsonconstraintTexto.length
    this.jsonconstraintTexto.push("New constraint"+position)
    this.cons.push(listofconstraint[0])
  }
  listofconstraint=[]
  this.ReloadFMTree()
}
Writelist(){
  aux=""
  listofconstraint.forEach(element => {
    aux=aux+element.type+" "
  })
  alert(aux)
  console.log(listofconstraint)
  console.log(position)
}
DeleteList(){
  listofconstraint=[]
  console.log(listofconstraint)
}

CreateConsBrother(){
  if(this.consactualfather!=undefined && this.consactualfather.type!=""){
  if(listofconstraint!=undefined && listofconstraint.length!=0){
    this.CreateListCons()
    if(this.consactualfather.type.toLowerCase().startsWith("feature")){}
    else{
    if(this.consactualfather.type.toLowerCase().startsWith("not") && this.consactualfather.operands.length==1){}
    else{
    if(this.consactualfather.operands.length==2){}
    else{this.consactualfather.operands.push(listofconstraint[0])
      console.log("hermano valido")
    }}}
  }}
  else{
  this.CreateConsList(); 
  alert("there was no father so a new one was created")
}
  listofconstraint=[]
  this.ReloadFMTree()
}

CreateConsSon(){
  if(listofconstraint!=undefined && listofconstraint.length!=0){this.CreateListCons()}
  if(this.consactual!=undefined){
  if(this.consactual.operands!=null||this.consactual.operands!=undefined){
  if(this.consactual.operands.length!=0 ){
    if(this.consactual.operands[0].type==""){this.consactual.operands.slice(0,1)}}

  if(this.typesofcons.indexOf(this.consactual.type)==-1){}
    else{
      if(this.consactual.type.toLowerCase().startsWith("not") && this.consactual.operands.length==1){}
        else{
          if(this.consactual.operands.length==2){}
          else{this.consactual.operands.push(listofconstraint[0])
            console.log("hijo valido")
          }
      }
    }
  }
}
  listofconstraint=[]
  this.ReloadFMTree()
}


DeleteConsText(){
  this.jsonconstraintTexto[position]=""
  this.jsonconstraintTexto=this.jsonconstraintTexto.filter(x=>x!="")
  console.log(position)
  this.ReloadFMTree()
}


SelectChipLogic(text:string){
  aux=new Const()
  aux.type=text
  if(text=="NotTerm"){
    aux.operands=[new Const()]
  }else{
    aux.operands=[new Const(),new Const()]
  }
  listofconstraint.push(aux)
  console.log(listofconstraint)
}

SelectChipFeature(text:string){
  aux=new Const()
  aux.type=text
  aux.operands=[]
  listofconstraint.push(aux)
  console.log(listofconstraint)
}


TransformJSON(){
  aux=this.consactual.createListForFile(this.cons,this.typesofcons)
  jsonfeatures=JSON.stringify(this.tree[0], (key, value) => {
      if(value!==null) return value  
  })
  aux=0
  while( aux<this.cons.length){
     listnamestext[aux]=JSON.stringify(this.cons[aux], (key, value) => {
    if(value!==null) return value  
})
aux++
}
  jsonfeatures= '"name"'+':"'+this.titulo+'",'+'"features"'+':'+ jsonfeatures
  aux=0
  aux2=""
  while (aux<listnamesconstraints.length){
    aux2=aux2+'{"name":"'+listnamesconstraints[aux]+'","expr":"'+this.jsonconstraintTexto[aux]+'","ast":'+listnamestext[aux]+'},'
    aux++
  }
  aux2=aux2.slice(0,aux2.length-1)
  aux2='"constraints": ['+aux2+']'
  json='{'+jsonfeatures+','+aux2+'}'
  console.log(json)
  this.cons=this.consactual.createListForTree(this.cons)
}



updatevalues(){
  aux=this.consactual.createListForFile(this.cons,this.typesofcons)
  jsonfeatures=JSON.stringify(this.tree[0], (key, value) => {
      if(value!==null) return value  })
  aux=0
  while( aux<this.cons.length){
     listnamestext[aux]=JSON.stringify(this.cons[aux], (key, value) => {
    if(value!==null) return value})
  aux++
  }
  jsonfeatures= '"name"'+':"'+this.titulo+'",'+'"features"'+':'+ jsonfeatures
  aux=0
  aux2=""
  while (aux<listnamestext.length){
    aux2=aux2+'{"name":"","expr":"","ast":'+listnamestext[aux]+'},'
    aux++
  }
  aux2=aux2.slice(0,aux2.length-1)
  aux2='"constraints": ['+aux2+']'
  json='{'+jsonfeatures+','+aux2+'}'
  console.log(json)
  this.cons=this.consactual.createListForTree(this.cons)
}

SaveDemoJson() {
  this.TransformJSON()
  let file = new Blob([json], { type: 'json' });
  saveAs(file, this.titulo+'.json')
}
SaveDemo() {
  this.TransformJSON()
  console.log("llego")
  aux = new Blob([json], { type: 'json' });
  console.log(aux)
  this.sendJSON()
  //this.CreateData(resultado)
  alert("I send the json file to the server,and then download the data as an UVL file")
  let file2 = new Blob(["resultado"], { type: 'uvl' });
  saveAs(file2, this.titulo+'.uvl') 

}


}
@Component({
  selector: 'dialog-content-example-dialog',
  templateUrl: './dialog-content-example-dialog.html',
})
export class DialogContentExampleDialog {
 
  example(text:string){
    alert(text)
  }
}
