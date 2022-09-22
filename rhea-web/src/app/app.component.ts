import {Component} from '@angular/core';
import {HttpClient, HttpParams } from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {FMTree} from './components/FMTree/FMTree';
import{Const} from './components/constraint/const';
import {MatDialog} from '@angular/material/dialog';
import * as saveAs from 'file-saver';
import {TooltipPosition} from '@angular/material/tooltip';
import { Refactoring } from './components/refactor/refactoring';




var aux:any;
var aux2:any=""
var aux3: any;
var aux4:any;
let symbol:any; // evita solapar valores en los auxiliares 
var jsonconstraint: Array<Const>=[new Const()] 
var jsonfeatures:string
var dictionary:any
var ListOfConstraint:Array<Const>=[]
var position:number;

var listnamesconstraints:Array<string>=[]
var listRefactorconstraints:Array<Refactoring>=[]
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
  urlrefactor="http://172.16.51.94:5000/refactor" //servidor guardar datos
  documents:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl','Pizzas.json', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];
  //file: File | null = null;
  title:string ='rhea-web' // evita un error en app.component.spec.ts
  declare actual:FMTree      //valor actual del FMTree
  consactual:Const =new Const()     //valor actual del FMTree
  declare actualfather:FMTree      //valor actual del actualfather del actual FMTree
  consactualfather:Const =new Const()     //valor actual del consactual del actual cons
  tree:Array<FMTree> =[new FMTree()]  // el FMTree de datos 
  cons:Array<Const>=[new Const()]   // El FMTree de constraints con el name en la rama final
  //declare json_nombre:any;    //guardo los valores de las features
  //declare json_const:any;     //guardo los valores de las constraints
  treeControl = new NestedTreeControl<FMTree>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FMTree>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();

  
    
  //list de constraints y nombres de las features
  ejemplo:Array<object>=[{name:1},{name:2},{name:2}]
  typesofcons:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','Xor','Xand','DoubleImpliesTerm']
  namesFeatures:Array<string>=[]
  //otros
  titulo:string='';
  item:string ='Pizzas.uvl';
  text1="Hide Constraints";
  text4="Hide Tree";
  text2=this.item;
  jsonconstraintTexto: Array<string>=[]
  // modificar o crear FMTree
  name:string="";
  optional:boolean=false;
  abstract:boolean=false;
  type:string ="";
  attributes:Array<any>=[];
  declare refactoring:Refactoring;
  card_min:number=0;
  card_max:number=0;
  ncons:string="";
  
constructor(private http: HttpClient,public dialog: MatDialog) { }  



ngOnInit() {
  console.log("Comprobar iteracion en json cual usa")
  console.log("determinar diseño final")
  console.log("cambiar comentarios a ingles o borrarlos")
  console.log("cambiar CSS a ingles")
  this.returnValues()
  
}
//orden : saveFM;downloadFM (2 ways) ;createFM;
// metodos de modificacion,creacion y eliminacion de valores
// otros metodos



saveFile(text?:string){ // envio el nuevo archivo y el nuevo name opcional
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

refactor(refac?:any){
  if(refac==""|| refac==undefined){refac=this.refactoring}
  if(refac.name==""){console.log("no tiene refactoring")}
  else{
  this.TransformJSON()
  this.http.post(this.urlrefactor,{json,refac},{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)
  })}
}


returnValues(text?:string){
  if(text==""|| text==undefined){text=this.item}
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
//  documentacion explicar que hace cada metodo, las referencias que tiene
//  explicar los elementos y que parametros tienen y los codigos que se usan
// 
//  Consultas de visualicacion de la pagina web
//    Que formato final se va a aplicar
//        Diseño grafico estatico y dinamico
//        Paleta de colores
//        Imagenes y simbolos
  


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
  
  if(this.actual.type=="CARDINALITY"){
  this.actual.card_max=this.card_max
  this.actual.card_min=this.card_min
  }

}}
  this.actual.optional=this.optional
  this.actual.abstract=this.abstract

this.namesFeatures=this.tree[0].ListOfNamesModified(this.actual.name,aux)
this.cons[0].checkName(this.cons,this.actual.name,aux)
}
}
DeleteNode(){
  this.namesFeatures=this.actual.Delete(this.actualfather)
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
  [jsonconstraint,this.jsonconstraintTexto,listnamesconstraints,listRefactorconstraints]=this.consactual.CreateConstraint(aux3)
  while(aux2<jsonconstraint.length){
  jsonconstraint[aux2]=this.consactual.CreateNewConstraint(jsonconstraint[aux2])
  aux2++}
  this.cons=this.consactual.createListForTree(jsonconstraint)
  //console.log(jsonconstraint)
  jsonconstraint=this.consactual.TransformToCons(jsonconstraint)
  jsonconstraint=aux3
  console.log(this.cons)
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==position)
  this.text1="Hide Constraints"
  this.text4="Hide Tree"
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
    this.card_max=this.actual.card_max||0
    this.card_min=this.actual.card_min||0
    this.attributes=this.actual.attributes||[]
    if(this.actual.refactoring!=undefined){this.refactoring=this.actual.refactoring}
    else{this.refactoring=new Refactoring}
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
    this.GetFatherCons(object)
    this.consactual=object
    this.ncons=this.jsonconstraintTexto[position] // se supone que siempre que lo podre obtener cuando se actualice con los valores del server
    console.log(this.consactual)
  }

  GetFatherCons(object:any,list?:Array<any>,cactualfather?:any){
    if(list==null){list=this.cons}
    if(list.filter(x=> x==object)[0]==undefined){
      list.forEach(element => {
        if(element.operands){
        if(element.operands.length>0){
          this.GetFatherCons(object,element.operands,element)
        }}
      });
    }else{
      this.consactualfather=cactualfather
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
        this.jsonconstraintTexto[position]="New value at " +(position+1)+"º"
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
    if(ListOfConstraint.length==2){
      ListOfConstraint[0].operands.push(ListOfConstraint[1]);
      ListOfConstraint[0].operands.splice(0,1);
    }
    if(ListOfConstraint.length>2){
      console.log(ListOfConstraint)
      
      ListOfConstraint[0]=this.consactual.ListOfNewConstraint(ListOfConstraint)
    }
    console.log(ListOfConstraint[0])
    return ListOfConstraint[0]
  }

  ModifyCons(){
    if(ListOfConstraint.length!=0&&ListOfConstraint!=undefined){
      this.CreateListCons()

    if(this.consactualfather==undefined ||  this.consactualfather.type==""){
      console.log("1")
      this.cons[position]=ListOfConstraint[0]
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
      this.consactualfather.operands[aux]=ListOfConstraint[0]
    }
    this.jsonconstraintTexto[position]="New value at " +(position+1)+"º"
    }
    this.ReloadFMTree()
    ListOfConstraint=[]
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
  if(this.text4=="Hide Tree"){
  this.text4="Show Tree"
  this.text2=""
  this.dataSource.data=[]
  }
  else{
    this.text4="Hide Tree"
    this.text2=this.item
    this.dataSource.data=this.tree
  }
}




openDialog() {
  const dialogRef = this.dialog.open(DialogContentExampleDialog);
  dialogRef.afterClosed().subscribe(result => {
    console.log(`Dialog result: ${result}`);
  });
}

cardhidden(){
  let bool =true
  let dis =true
  if(this.actual!=undefined){
  if(this.actual.card_max!=undefined || this.actual.card_min!=undefined){
    bool=false
    if(this.actual.type=="CARDINALITY"){dis=false}
  }}
  return [bool,dis]
}
SymbolPerTypeCons2(type:string){
  symbol=this.jsonconstraintTexto.indexOf(type)
  if(listRefactorconstraints[symbol]!=undefined){
    symbol=true
  }
  else{symbol=false}
  return symbol
}

SymbolPerTypeCons(type:string){
  symbol=this.jsonconstraintTexto.indexOf(type)
  if(listRefactorconstraints[symbol]!=undefined){
    symbol='more_vert'
  }
  else{symbol=''}
  return symbol
}
GetFather(nodechild:FMTree,list:any){
    list.forEach(element => {
      if(element==nodechild){aux4=undefined}
      else{
        if(element.children.length>0){
          if(element.children.indexOf(nodechild)!=-1){
            aux4=element
          }
          else{this.GetFather(nodechild,element.children)}
      }
    }
    });
  
return aux4;
}


ToolTip(nodetooltip:FMTree){
  let text
  if(nodetooltip.description!=undefined){
    text="Description: "
    text=text+nodetooltip.description.toString()+" \n"
  }
if(nodetooltip.attributes!=undefined){
  text=text+ "Attributes: "
  nodetooltip.attributes.forEach(element => {
    text=text+" "+element.name+": "+element.value+"; "
  })
}
return text
}
ToolTipRefa(nodetooltiprefa:FMTree){
  let text
  if(nodetooltiprefa.refactoring!=undefined){
    text="Refactoring: "
    text=text+"Id: "+nodetooltiprefa.refactoring.id+" Name: "+nodetooltiprefa.refactoring.name+" Description: "+nodetooltiprefa.refactoring.description
  }
return text
}
SymbolPerType2(nodeRefactor:FMTree){
  if(nodeRefactor.refactoring!=undefined){
  return true}
  else{
    return false}
 }
SymbolPerType(nodechild:FMTree){ 
  this.actualfather=this.GetFather(nodechild,this.tree)
  let text
  if(this.actualfather==undefined){
    symbol="../assets/img/featuretree.ico"
    text="root"
  }
  else{
    if(this.actualfather.type.toUpperCase().startsWith("FEATURE")){
      if(nodechild.optional){ symbol="../assets/img/optional.gif";text="optional"}
      else{symbol="../assets/img/mandatory.gif";text="mandatory"}
      
    }
    if(this.actualfather.type=="OR"){symbol="../assets/img/or.gif";text="or <1..*>"}
    if(this.actualfather.type=="XOR"){symbol="../assets/img/xor.gif";text="xor <1..1>"}
    if(this.actualfather.type=="MUTEX"){symbol="../assets/img/mutex.gif";text="mutex  <0..1>"}
    if(this.actualfather.type=="CARDINALITY"){symbol="../assets/img/cardinality.gif";text="cardinality " +this.actualfather.card_min+".."+this.actualfather.card_max}
    if(this.actualfather.type!="OR"&&  this.actualfather.type!="CARDINALITY"&&this.actualfather.type!="MUTEX"&& this.actualfather.type!="XOR" && !this.actualfather.type.toUpperCase().startsWith("FEATURE") )
    {symbol="../assets/img/icon_error.gif";text="error"}
  }
  return [symbol,text]
}

onRightClick($event) {
  return true
}
SelectedChange(v){
  this.text1="Hide Constraints"
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
  if(ListOfConstraint!=undefined && ListOfConstraint.length!=0){
    this.CreateListCons()
    position=this.jsonconstraintTexto.length
    this.jsonconstraintTexto.push("New constraint at " +(position+1)+"º")
    this.cons.push(ListOfConstraint[0])
  }
  ListOfConstraint=[]
  this.ReloadFMTree()
}
Writelist(){
  let textlista=""
  ListOfConstraint.forEach(element => {
    textlista=textlista+element.type+" "
  })
  return textlista
}
DeleteList(){
  ListOfConstraint=[]
  console.log(ListOfConstraint)
}

CreateConsBrother(){
  if(this.consactualfather!=undefined && this.consactualfather.type!=""){
  if(ListOfConstraint!=undefined && ListOfConstraint.length!=0){
    this.CreateListCons()
    if(this.consactualfather.type.toLowerCase().startsWith("feature")){}
    else{
    if(this.consactualfather.type.toLowerCase().startsWith("not") && this.consactualfather.operands.length==1){}
    else{
    if(this.consactualfather.operands.length==2){}
    else{this.consactualfather.operands.push(ListOfConstraint[0])
      console.log("hermano valido")
    }}}
  }}
  else{
  this.CreateConsList(); 
  alert("there was no father so a new one was created")
}
  ListOfConstraint=[]
  this.ReloadFMTree()
}

CreateConsSon(){
  if(ListOfConstraint!=undefined && ListOfConstraint.length!=0){this.CreateListCons()}
  if(this.consactual!=undefined){
  if(this.consactual.operands!=null||this.consactual.operands!=undefined){
  if(this.consactual.operands.length!=0 ){
    if(this.consactual.operands[0].type==""){this.consactual.operands.slice(0,1)}}

  if(this.typesofcons.indexOf(this.consactual.type)==-1){}
    else{
      if(this.consactual.type.toLowerCase().startsWith("not") && this.consactual.operands.length==1){}
        else{
          if(this.consactual.operands.length==2){}
          else{this.consactual.operands.push(ListOfConstraint[0])
            console.log("hijo valido")
          }
      }
    }
  }
}
  ListOfConstraint=[]
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
  ListOfConstraint.push(aux)
  console.log(ListOfConstraint)
}

SelectChipFeature(text:string){
  aux=new Const()
  aux.type=text
  aux.operands=[]
  ListOfConstraint.push(aux)
  console.log(ListOfConstraint)
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
  aux2=listnamesconstraints[listnamesconstraints.length-1]
  if(aux2==undefined){aux2="CTC 1"}
  else{listnamesconstraints.splice(0,listnamesconstraints.length)}
  while(this.jsonconstraintTexto.length>listnamesconstraints.length){
  aux2=listnamesconstraints[listnamesconstraints.length-1]
  if(aux2==undefined){aux2="CTC 1"}
  aux=0
  aux3=""
  while(!Number.parseInt(aux2[aux])){
    aux3=aux3+aux2[aux]
    aux++
  }
  aux3=aux3+(listnamesconstraints.length+1)
  listnamesconstraints.push(aux3)
}
  aux=0
  aux2=""
  while (aux<listnamestext.length){
  aux2=aux2+'{"name":"'+listnamesconstraints[aux]+'","expr":"'+this.jsonconstraintTexto[aux]+'","ast":'+listnamestext[aux]+'},'
  aux++
  }
  aux2=aux2.slice(0,aux2.length-1)
  aux2='"constraints": ['+aux2+']'
  json='{'+jsonfeatures+','+aux2+'}'
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
