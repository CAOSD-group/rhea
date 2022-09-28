import {Component} from '@angular/core';
import {HttpClient, HttpParams ,HttpHeaders} from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {FMTree} from './components/FMTree/FMTree';
import{Const} from './components/constraint/const';
import {MatDialog} from '@angular/material/dialog';
import * as saveAs from 'file-saver';
import {TooltipPosition} from '@angular/material/tooltip';
import { Refactoring } from './components/refactor/refactoring';
import {drawFMFactLabel as fm} from './fm_fact_label.js';



var aux:any;
var aux2:any=""
var aux3: any;
let aux4:any;
var jsonconstraint: Array<Const>=[new Const()] 
var jsonrefactors: Array<Refactoring>=[new Refactoring()] 
var jsonfeatures:string
var ListOfConstraint:Array<Const>=[]
var position:number;
var ListOfRefactors:Array<Refactoring>=[]
var listnamesconstraints:Array<string>=[]
var listnamestext:Array<string>=[]
var json:string



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  urlsave="http://172.16.51.94:5000/saveFM" 
  urldownload="http://172.16.51.94:5000/downloadFM"  
  urlupload="http://172.16.51.94:5000/uploadFM"  
  urldownload2="http://172.16.51.94:5000/downloadFM2" 
  urldelete="http://172.16.51.94:5000/deleteFM" 
  urlcreate="http://172.16.51.94:5000/createFM" 
  urlrefactor="http://172.16.51.94:5000/refactor" 

  declare actual:FMTree     
  declare actualfather:FMTree 
  tree:Array<FMTree> =[new FMTree()]  

  consactual:Const =new Const()     
  consactualfather:Const =new Const()     
  cons:Array<Const>=[new Const()]  

  refactor:Refactoring =new Refactoring()



  treeControl = new NestedTreeControl<FMTree>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FMTree>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();
    
  //list de constraints y nombres de las features
  typesofcons:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','Xor','Xand','DoubleImpliesTerm']
  namesFeatures:Array<string>=[]
  //otros
  title:string='';
  item:string ='Pizzas.uvl';
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
  myfile:any
  documents:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl','Pizzas.json', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];

constructor(private http: HttpClient ,public dialog: MatDialog) { }  



ngOnInit() {
  console.log("determinar diseño final")
  console.log("¿¿mandar lista refactoring al JSON??")
  console.log("cambiar comentarios a ingles o borrarlos")
  this.returnValues("JHipster.uvl")
  
}


saveFile(text?:string){ 
  this.TransformJSON()  
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
  console.log(uvl)
  
  const httpOptions = {
    headers: new HttpHeaders({
  //  'Content-Type': 'multipart/form-data',
  //  'Content-Disposition': 'form-data',
  //  name:"file",
  //  filename:"download.jpg",
  //  responseType:'text',
  //  Authorization: 'my-auth-token',
  //  withCredentials:'true',
      })
  };
  const formData: FormData = new FormData();
  formData.append('file', uvl, uvl.name);
  this.http.post(this.urlupload,formData,{responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    json=resultado}
    )
}

casFMTree(object:any){ fm(object)}












Refactor(typeref:string){
  let object
  let ref =this.refactoring
  if( this.refactoring==undefined ||this.refactoring.name==""){console.log("no tiene refactoring")}
  else{
    if(typeref=="node"){object=this.actual.name}
    if(typeref=="cons"){object=listnamesconstraints[position]}
    //if(typeref=="all"){this.TransformJSON();object=json}
    if(typeref=="node"||typeref=="cons"
    //||typeref=="all"
    ){
    console.log(object)
    console.log(this.refactoring)
  this.http.post(this.urlrefactor,{object, ref},{responseType:'text'}).subscribe(resultado => {
    console.log(resultado)
  })}
  else{
    console.log("error in type of refactor")
  }
}
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
    aux=JSON.parse(aux)
    this.title=aux.name
    console.log(this.title)
    jsonfeatures=aux.features,
    jsonconstraint=aux.constraints
    alert ("linea 203 aux.refactors como se llamara??")
    //jsonrefactors=aux.refactors
    aux2=""
    let dictionary = Object.assign({}, object);
    for( const[key] of Object.entries(dictionary)){
      aux2=aux2+dictionary[key]
  }
    aux=JSON.parse(aux2)
    aux3=aux.constraints
    this.CreateCons()
    this.CreateFMTree()
    this.CreateRefactor()
}

CreateFile(text:string){  
  this.TransformJSON()
  console.log("valores que se van a crear")
  console.log(jsonfeatures)
  console.log(jsonconstraint)
  this.http.post(this.urlcreate,[text,jsonfeatures,jsonconstraint],{responseType:'text'}).subscribe(resultado => {
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
  this.actualfather=this.GetFather(this.actual,this.tree)
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
  if(true){    
  [jsonconstraint,this.jsonconstraintTexto,listnamesconstraints]=this.consactual.CreateConstraint(aux3)
  while(aux2<jsonconstraint.length){
  jsonconstraint[aux2]=this.consactual.CreateNewConstraint(jsonconstraint[aux2])
  aux2++}
  this.cons=this.consactual.createListForTree(jsonconstraint)
  jsonconstraint=this.consactual.TransformToCons(jsonconstraint)
  console.log(this.cons)
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==position)
}
  
}

CreateFMTree(){
  console.log("creo FMTree")
  this.tree.splice(0,this.tree.length)
  this.tree=[new FMTree()]
  this.tree[0].DeleteList();
  this.tree=this.tree[0].CreateNewFMTree(jsonfeatures)
  this.namesFeatures=this.tree[0].ListOfNames();
  this.tree[0]=this.tree[0].IncorporateChildren(jsonfeatures);
  this.tree.splice(1,this.tree.length)
  this.tree[0].CleanFMTree()
  console.log(this.tree)
  this.dataSource.data=this.tree
}

CreateRefactor(){
  console.log("creo Refactor")
  this.refactor.DeleteList()
  ListOfRefactors=this.refactor.Create(jsonrefactors);
  console.log(ListOfRefactors)
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

changeListener($event): void {this.readThis($event.target);this.myfile=$event.target
}

readThis(inputValue: any): void { 
    aux=""
    var file: File = inputValue.files[0];
    console.log(file)
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
    if(file.name.endsWith('.xml')){
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
    this.actualfather=this.GetFather(this.actual,this.tree)
    console.log(this.actual)
  }
 

  SelectCons(object:any){
    this.GetFatherCons(object)
    this.consactual=object
    this.ncons=this.jsonconstraintTexto[position] 
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
treeConsHideen(node:any){
  if(node.operands==null){return true}
  else{return false }
}
treeHideen(node:any){
  if(node.children.length==0){return true}
  else{return false }
}

SymbolPerTypeCons(type:string){
  let hiddensymbol=true
  let symbol
  symbol=this.jsonconstraintTexto.indexOf(type)
  if(true!=undefined){
    symbol='more_vert'

  }
  else{symbol='';hiddensymbol=false}
  return [symbol,hiddensymbol]
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
  let text=""
  
if(nodetooltip.attributes!=undefined&&nodetooltip.attributes.length>0){
  text=text+ "Attributes"
  nodetooltip.attributes.forEach(element => {
    if(element.name!= undefined){text=text+":"+element.name}
    if(element.value!= undefined){text=text+":"+element.value}
    
  })
  text=text+" ;"
}
return text
}
ToolTipRefa(nodetooltiprefa:FMTree){
  let text
  if(false){
    text="Refactoring: "
    text=text
  
return [true,text]}
else{return false}
}

SymbolPerType(nodechild:FMTree){ 
  let symbol="../assets/img/mandatory.gif"
  let text="mandatory"

  if(this.GetFather(nodechild,this.tree)==undefined){symbol="../assets/img/featuretree.ico";text="root"}
  else{
    if(nodechild.type.toUpperCase().startsWith("FEATURE")){
      if(nodechild.optional){ symbol="../assets/img/optional.gif";text="optional"}
      else{symbol="../assets/img/mandatory.gif";text="mandatory"}
      
    }
    if(nodechild.type=="OR"){symbol="../assets/img/or.gif";text="or <1..*>"}
    if(nodechild.type=="XOR"){symbol="../assets/img/xor.gif";text="xor <1..1>"}
    if(nodechild.type=="MUTEX"){symbol="../assets/img/mutex.gif";text="mutex  <0..1>"}
    if(nodechild.type=="CARDINALITY"){symbol="../assets/img/cardinality.gif";text="cardinality " +nodechild.card_min+".."+nodechild.card_max}
    if(nodechild.type!="OR"&& nodechild.type!="CARDINALITY"&&nodechild.type!="MUTEX"&& nodechild.type!="XOR" && !nodechild.type.toUpperCase().startsWith("FEATURE") )
    {symbol="../assets/img/icon_error.gif";text="error"}
  }
  return [symbol,text]
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
  if(true){}
  else{this.refactoring=new Refactoring}
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
  jsonfeatures= '"name"'+':"'+this.title+'",'+'"features"'+':'+ jsonfeatures
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
  jsonfeatures= '"name"'+':"'+this.title+'",'+'"features"'+':'+ jsonfeatures
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
  saveAs(file, this.title+'.json')
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
  saveAs(file2, this.title+'.uvl') 

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
