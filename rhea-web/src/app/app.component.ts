import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {FMTree} from './components/FMTree/FMTree';
import{Const} from './components/constraint/const';
import * as saveAs from 'file-saver';
import { Refactoring } from './components/refactor/refactoring';
import { Language } from './components/Language/Language';
import { Cons } from 'rxjs';




var aux:any;
var aux2:any=""
var aux3: any;
let aux4:any;
var jsonconstraint: Array<Const>=[new Const()] 
var jsonrefactors: Array<Refactoring>=[new Refactoring()] 
var jsonfeatures:string


var listnamestext:Array<string>=[]
var json:string
var refactor:Refactoring =new Refactoring()



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
  urlupdate="http://172.16.51.94:5000/updateFeature" 

  declare actual:FMTree     
  declare actualfather:FMTree 
  tree:Array<FMTree> =[new FMTree()]  

  consactual:Const =new Const()     
  consactualfather:Const =new Const()     
  cons:Array<Const>=[new Const()]  

  ListOfRefactors:Array<Refactoring>=[]



  treeControl = new NestedTreeControl<FMTree>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FMTree>();
  constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();
    
  //list de constraints y nombres de las features
  typesofcons:Array<string>=['NOT','OR','AND','IMPLIES','XOR','REQUIRES','EXCLUDES','EQUIVALENCE']
  typesofconsTerm:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','XorTerm','RequiresTerm','ExcludesTerm','EquivalenceTerm']
  namesFeatures:Array<string>=[]
  //otros
  title:string='';
  item:string ='JHipster.uvl';
  jsonconstraintTexto: Array<string>=[]
  // modificar o crear FMTree
  name:string="";
  optional:boolean=false;
  abstract:boolean=false;
  type:string ="";
  attributes:Array<any>=[];

  card_min:number=0;
  card_max:number=1;
  ncons:string="";
  npos:number=-1;
  myfile:any
  myfile_name:string=""
  documents:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];
  listOfTypes=["XOR","OR","MUTEX","CARDINALITY","FEATURE"]
  visiblechipsfeatures=false
  visible_Constraint_list=true;
  bdrawer=true
  show_refacts_features_only=false;
  show_refacts_cons_only=false;
  featureautocomplete=""
  ConstraintListautocomplete=""
  search_name=true 
  mattooltipconstraint=this.search_name?"Search by name":"Search by text";
  windowFM_Editor=true
  windowAbout=false
  window3=true
  updatable=false
  page=0;
  range=10;
  loadingmodal=true
  jsonconstraintextshort: Array<string>=[]
  listnamesconstraints:Array<string>=[]
  jsonlanguage:Array<Language>=[]
  ListLanguage:Array<string>=[]
  language:Language=new Language()
  ListOfConstraint:Array<Const>=[]
  position:number=0
  my_session=""
constructor(private http: HttpClient ) { }  



ngOnInit() {
  console.log("separar html en partes funcionales || falta enviar informacion a cada componente || Errores en algunas funciones que estan en ambos sitios(?)")
  console.log("posible implementacion de mejora en visualicacion arbol constraint y eliminar el paso de quitar el operands y type de  createListForTree  y de createListForFile")
  //alert("falla el modal de las constraints el crear un hijo")
  this.returnValues("JHipster.uvl")
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
  
showFM_Editor(){
  this.windowFM_Editor=true
  this.windowAbout=false
  this.window3=false
}
showAbout(){
  this.windowFM_Editor=false
  this.windowAbout=true
  this.window3=false
}


sendJSON(){
  console.log(aux)
  this.http.post(this.urldownload2,aux,{withCredentials:true,responseType:'text'}).subscribe(resultado => {
    console.log(resultado)})
   
}


sendUVL(uvl:any){
  console.log(uvl)
  const formData: FormData = new FormData();
  formData.append('file', uvl, uvl.name);
  console.log("llego")
  this.http.post(this.urlupload,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    json=resultado
      }
    )
}



sendUpdate(){
  const formData: FormData = new FormData();
  formData.append('fm_hash',this.my_session);
  formData.append('old_name',this.actual.name);
  formData.append('new_name',this.name);
  formData.append('type',this.type);
  formData.append('card_min',this.card_min.toString());
  formData.append('card_max',this.card_max.toString());
  formData.append('abstract',JSON.stringify(this.abstract));
  formData.append('optional',JSON.stringify(this.optional));
  formData.append('attributes',JSON.stringify(this.attributes))



  this.http.post(this.urlupdate,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    json=resultado
      }
    )
}


Refactor(typeref:string){
  let object
  const formData: FormData = new FormData();
  if( typeref!="all" &&( refactor==undefined ||refactor.name=="")){console.log("error in type of refactor")}
  else{
    if(typeref=="node"){object=this.actual.name}
    if(typeref=="cons"){object=this.listnamesconstraints[this.npos]}
    /*if(typeref=="all"){
      this.TransformJSON();
      object=json;
      let my_refac=""
      console.log(this.ListOfRefactors);
      this.ListOfRefactors.forEach(element => {
        my_refac=my_refac+element.id+";"
      });
      my_refac=my_refac.slice(0,-1)
      formData.append('refactoring_id',my_refac);
  }*/
    if(typeref=="node"||typeref=="cons"||typeref=="all"){
      
    formData.append('refactoring_id',refactor.id);
    formData.append('instance_name',object);
    formData.append('fm_hash',this.my_session);
    this.http.post(this.urlrefactor,formData,{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    json=resultado
  })}
}
}


returnValues(text?:string){
  this.loadingmodal=false
  if(text==""|| text==undefined){text=this.item}
  this.http.post(this.urldownload,text,{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
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
  jsonrefactors=aux.refactorings
  this.jsonlanguage=aux.language_constructs
  this.my_session=aux.hash
  aux2="" 
  try{
  let dictionary = Object.assign({}, object);
  for( const[key] of Object.entries(dictionary)){
    aux2=aux2+dictionary[key]
  }
  aux=JSON.parse(aux2)
  }
  catch{}
  if(aux2=="" ){
    console.log(aux)
  }
  aux3=aux.constraints
  this.CreateCons()
  this.CreateFMTree()
  if(jsonrefactors!=undefined){
  this.CreateRefactor()}
  this.CreateLanguage()
  this.loadingmodal=true
  this.page=0
  this.range=10
}
showModal(){
  if(!this.loadingmodal){
    return ["../assets/img/loading.gif",true]
  }
  else{
  return ["a",false]}
}

CreateFile(text:string){  
  this.TransformJSON()
  console.log("valores que se van a crear")
  console.log(jsonfeatures)
  console.log(jsonconstraint)
  this.http.post(this.urlcreate,[text,jsonfeatures,jsonconstraint],{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
    console.log(resultado)
  })
}



ChangeType(ty:string){
  console.log(this.type)
  this.type=ty;
}
checkNameFeature(){
  if(this.actual!=undefined){
    let bol
    bol=this.actual.AvoidDuplicates(this.name)&& (this.name!=this.actual.name)
    this.updatable=bol
  return [bol,this.updatable] }
  return [false,this.updatable]
}
checkcard_min_max(){
  if(this.card_min>=this.card_max){
    this.card_max=this.card_min;
    return false
  }
  if(this.card_min<=0){
    this.card_min=0
    return false
  }
  return true
}


ModifySelecction(){
this.loadingmodal=false
/*try{
 this.sendUpdate()}
 catch{
  this.loadingmodal=true
 }*/
  
  this.actual.name=this.name
  if(this.actual.children==undefined){}
  if(this.actual.children!=undefined){
  if(this.actual.children.length<2){
  }
  else{
  this.actual.type=this.type
  if(this.actual.type=="CARDINALITY"){
  this.actual.card_max=this.card_max
  this.actual.card_min=this.card_min
  }
}}
this.actual.optional=this.optional
this.actual.abstract=this.abstract
this.actual.attributes=this.attributes
this.namesFeatures=this.tree[0].ListOfNamesModified(this.actual.name,aux)
this.cons[0].checkName(this.cons,this.actual.name,aux)
this.loadingmodal=true
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
  console.log("create constraints")
  this.position=-1
  this.cons.splice(0,this.cons.length)
  aux2=0
  if(true){    
  [jsonconstraint,this.jsonconstraintTexto,this.listnamesconstraints]=this.consactual.CreateConstraint(aux3)
  while(aux2<jsonconstraint.length){
  jsonconstraint[aux2]=this.consactual.CreateNewConstraint(jsonconstraint[aux2])
  aux2++}
  this.cons=this.consactual.createListForTree(jsonconstraint)
  jsonconstraint=this.consactual.TransformToCons(jsonconstraint)
  console.log(this.cons)
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
}
this.jsonconstraintextshort=this.jsonconstraintTexto
}

CreateFMTree(){
  console.log("create FMTree")
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
listOfContraint(text:string){
  if(text.length<100){
    return text
  }
  else{
    return text.slice(0,100)+"..."
  }

}
CreateRefactor(){
  console.log("create Refactor")
  refactor.DeleteList()
  this.ListOfRefactors=refactor.Create(jsonrefactors);
  console.log(this.ListOfRefactors)
}
CreateLanguage(){
  console.log("create Language")
  this.jsonlanguage=this.language.CreatLanguage(this.jsonlanguage)
  this.ListLanguage=this.language.CreatLanguage2()
  console.log(this.jsonlanguage)
  console.log(this.ListLanguage)
}

DeleteFMTree(){
  this.dataSource.data=[]
  this.constraindataSource.data=[]
}

ReloadFMTree(){
  this.DeleteFMTree()
  this.dataSource.data=this.tree
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
  if(this.consactual==undefined){ this.consactual=new Const()}
}

changeListener($event): void {
  if($event.target.files[0].name!=undefined){
  this.myfile_name=$event.target.files[0].name
  this.myfile=$event.target}
}

readThis(inputValue: any): void { 
  if(inputValue!=undefined){
    if(inputValue.files[0]!=undefined){
    this.loadingmodal=false
    aux=""
    this.dataSource.data=[]
    this.constraindataSource.data=[]
    listnamestext=[]
    this.jsonconstraintTexto=[]
    this.ListOfConstraint=[]
    var file: File = inputValue.files[0];
    var myReader: FileReader = new FileReader();
    myReader.readAsText(file);
    myReader.onloadend = function (e) {
    aux=myReader.result;}
  
    if(file.name.endsWith('.json')){
      console.log("json file detected")
      setTimeout(() => {
      this.sendUVL(file)
      //this.CreateData(aux,"hola")
      },100)
    }
    if(file.name.endsWith('.uvl')){
      console.log("uvl file detected")
      setTimeout(() => {
        this.sendUVL(file)
        },100)
    }
    if(file.name.endsWith('.xml')){
      console.log("xml file detected")
      setTimeout(() => {
        this.sendUVL(file)
        },100)
    }
    if(!(file.name.endsWith('.xml')||file.name.endsWith('.uvl')||file.name.endsWith('.json'))){
      alert("not valid file type")
    }
  }
  }
}

  abrir(){
    console.log(this.actual)
    this.GetFather(this.actual,this.tree)
    this.treeControl.expand(this.actualfather)
    this.treeControl.expand(this.actual)
  }
  select(object:any){
    this.actual=object
    this.name=this.actual.name
    this.type=this.actual.type
    this.optional=this.actual.optional
    this.abstract=this.actual.abstract
    this.card_max=this.actual.card_max||1
    this.card_min=this.actual.card_min||0
    this.attributes=this.actual.attributes||[]
    this.actualfather=this.GetFather(this.actual,this.tree)
    console.log(this.actual)
  }


  deleteAttributes(value:any){
    setTimeout(() => {
      this.actual.attributes?.forEach(element => {
        if(element.name==value.name && element.value==value.value){
          this.actual.attributes?.splice(this.actual.attributes?.indexOf(element),1)
        }
      });
      },1)
  }
  CreateAttribtues(){
    let newvalue={name:"new name",value:"new value"}
    if(this.attributes==undefined){this.attributes=[]}
    this.attributes.push(newvalue)
  }

  SelectCons(object:any){
    this.GetFatherCons(object)
    if(this.cons.indexOf(object)!=-1){this.position=this.cons.indexOf(object)}
    this.consactual=object
    this.ncons=this.jsonconstraintTexto[this.position]
    this.npos=this.position
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
      this.position=this.cons.indexOf(this.consactualfather)
    }
  }

  updatePosition(a:any){
    this.position=a
    console.log(a)
  }
  DeleteCons(){
    console.log(this.position)
    if( this.consactual.type=='' && this.position!= undefined && this.position!=-1){
      this.cons.splice(this.position,1)
      this.DeleteConsText()
      this.position=-1
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
        this.consactualfather.operands.splice(aux,1)
        this.jsonconstraintTexto[this.position]="New value at " +(this.position+1)+"º"
      }
      else{
        if(this.position!=-1){
        this.DeleteConsText()
        this.cons.splice(this.position,1)
        this.position=-1}
      }
    }
    if(this.cons.length==0){this.cons.push(new Const);console.log("7")}
    this.SelectedChange(this.ncons)
    this.ReloadFMTree()
  }

  CreateListCons(){
    if(this.ListOfConstraint.length==2){
      this.ListOfConstraint[0].operands=[]
      this.ListOfConstraint[0].operands.push(this.ListOfConstraint[1]);
    }
    if(this.ListOfConstraint.length>2){
      this.ListOfConstraint[0]=this.consactual.ListOfNewConstraint(this.ListOfConstraint)
    }
    return this.ListOfConstraint[0]
  }

  ModifyCons(){
    if(this.ListOfConstraint.length!=0&&this.ListOfConstraint!=undefined){
      this.CreateListCons()

    if(this.consactualfather==undefined ||  this.consactualfather.type==""){
      this.cons[this.position]=this.ListOfConstraint[0]
    }

    if(this.consactualfather!=undefined  ){
      aux2=0
      while(aux2<this.consactualfather.operands.length){
        if(this.consactualfather.operands[aux2]==this.consactual){
          aux=aux2
          aux2++
        }
        else{aux2++}
      }
      this.consactualfather.operands[aux]=this.ListOfConstraint[0]
    }
    this.jsonconstraintTexto[this.position]="New value at " +(this.position+1)+"º"
    }
    this.ReloadFMTree()
    this.ListOfConstraint=[]
  }

cardhidden(){
  let bool =true
  if(this.type=="CARDINALITY"){bool=false}
  return bool
}

treeConsHideen(node:any){
  if(node.operands==null){return true}
  else{return false }
}
treeHideen(node:any){
  if(node.children.length==0){return true}
  else{return false }
}

HiddenRefacCons(type:string){
  let hiddensymbol=false
  let color=""
  let temporalposition
  let count=0
  while (count<this.jsonconstraintTexto.length) {
    if(this.jsonconstraintTexto[count]==type ){temporalposition=count}
    count++
  }
  this.ListOfRefactors.forEach(element => {
    if(element.instances.includes(this.listnamesconstraints[temporalposition])){
    hiddensymbol=true
    if(this.show_refacts_cons_only){
    color='refactorColor'}
    }
  });  
  return [hiddensymbol,color]
}
HiddenRefacfeature(node:FMTree){
  let hiddensymbolfeature=false
  let color=""
  this.ListOfRefactors.forEach(element => {
    if(element.instances.includes(node.name)){
      if(this.show_refacts_features_only){
      hiddensymbolfeature=true
      if(this.show_refacts_features_only){
        color='refactorColor'
      } 
    }
    }
  });
  if(node.abstract){
    if(color==""){
      color='cursive'
    }
    else{
      color='refactorColorcursive'
    }
  }
  return [hiddensymbolfeature,color]
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
  let bool=false
  this.ListOfRefactors.forEach(element => {
    if(element.instances.includes(nodetooltiprefa.name)){
    text="Refactoring: "+element.name
    bool=true
    }
  });
return [bool,text]
}



SymbolPerType(nodechild:FMTree){ 
  let symbol=""
  let text=""
  let symbol2=""
  let text2=""

  if(this.GetFather(nodechild,this.tree)==undefined){symbol="../assets/img/featuretree.ico";text="root"}
  else{
    if(nodechild.type.toUpperCase().startsWith("FEATURE")){
      if(nodechild.optional){ symbol="../assets/img/optional.gif";text="optional"}
      else{symbol="../assets/img/mandatory.gif";text="mandatory"}
      return [symbol,text]
    }
    else{
    if(nodechild.type=="OR"){symbol="../assets/img/or.gif";text="or <1..*>"}
    if(nodechild.type=="XOR"){symbol="../assets/img/xor.gif";text="xor <1..1>"}
    if(nodechild.type=="MUTEX"){symbol="../assets/img/mutex.gif";text="mutex  <0..1>"}
    if(nodechild.type=="CARDINALITY"){symbol="../assets/img/cardinality.gif";text="cardinality " +nodechild.card_min+".."+nodechild.card_max}
    if(text=="" && symbol==""){symbol="../assets/img/icon_error.gif";text="error"}

    if(nodechild.optional){ symbol2="../assets/img/optional.gif";text2="optional"}
      else{symbol2="../assets/img/mandatory.gif";text2="mandatory"}
    return [symbol,text,symbol2,text2]
  }
  }
  return [symbol,text]
}

onRightClick($event) {
  return true
}
SelectedChange(v){
  aux2=0
  while (aux2<this.jsonconstraintTexto.length) {
    if(this.jsonconstraintTexto[aux2]==v ){this.position=aux2}
    aux2++
  }
  this.ncons=v
  this.npos=this.position
  this.consactual=this.cons[this.position]
  console.log(this.consactual)
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
}
CreateConsList(){
  if(this.ListOfConstraint!=undefined && this.ListOfConstraint.length!=0){
    this.CreateListCons()
    this.position=this.jsonconstraintTexto.length
    this.jsonconstraintTexto.push("New constraint at " +(this.position+1)+"º")
    this.cons.push(this.ListOfConstraint[0])
    aux=1
    while(this.listnamesconstraints.indexOf("CTC"+aux)!=-1){
      aux++
    }
    console.log(aux)
    console.log(this.listnamesconstraints)
    this.listnamesconstraints.push("CTC"+aux)
  }
  this.ListOfConstraint=[]
  this.ReloadFMTree()
}
Writelist(){
  let textlista=""
  this.ListOfConstraint.forEach(element => {
    textlista=textlista+element.type+" "
  })
  return textlista
}
DeleteList(){
  console.log(this.listnamesconstraints)
  this.ListOfConstraint=[]
}

CreateConsBrother(){
  if(this.consactualfather!=undefined && this.consactualfather.type!=""){
  if(this.ListOfConstraint!=undefined && this.ListOfConstraint.length!=0){
    this.CreateListCons()
    if(this.consactualfather.type.toLowerCase().startsWith("feature")){}
    else{
    if(this.consactualfather.type.toLowerCase().startsWith("not") && this.consactualfather.operands.length==1){}
    else{
    if(this.consactualfather.operands.length==2){}
    else{this.consactualfather.operands.push(this.ListOfConstraint[0])
    }}}
  }}
  else{
  this.CreateConsList(); 
  alert("there was no father so a new one was created")
}
  this.ListOfConstraint=[]
  this.ReloadFMTree()
}

CreateConsSon(){
  if(this.ListOfConstraint!=undefined && this.ListOfConstraint.length!=0){this.CreateListCons()}
  if(this.consactual!=undefined){
  if(this.consactual.operands!=null||this.consactual.operands!=undefined){
  if(this.consactual.operands.length!=0 ){
    if(this.consactual.operands[0].type==""){this.consactual.operands.slice(0,1)}}

  if(this.typesofconsTerm.indexOf(this.consactual.type)==-1){}
    else{
      if(this.consactual.type.toLowerCase().startsWith("not") && this.consactual.operands.length==1){}
        else{
          if(this.consactual.operands.length==2){}
          else{this.consactual.operands.push(this.ListOfConstraint[0])
            console.log("hijo valido")
          }
      }
    }
  }
}
  this.ListOfConstraint=[]
  this.ReloadFMTree()
}


DeleteConsText(){
  this.jsonconstraintTexto.splice(this.position,1)
  this.listnamesconstraints.splice(this.position,1)
  this.ReloadFMTree()
}


SelectChipLogic(text:string){
  aux=this.typesofcons.indexOf(text)
  if(aux!=-1){
    text=this.typesofconsTerm[aux]
  aux=new Const()
  aux.type=text
  if(text.toLowerCase().startsWith("not")){
    aux.operands=[new Const()]
    aux.operands.splice(0,1)
  }else{
    aux.operands=[new Const(),new Const()]
  }
  this.ListOfConstraint.push(aux)
  console.log(this.ListOfConstraint)
}
}

SelectChipFeature(text:string){
  aux=new Const()
  aux.type=text
  aux.operands=[]
  if(this.typesofconsTerm.indexOf(text)==-1){
    aux.operands=null
  }
  this.ListOfConstraint.push(aux)
  console.log(this.ListOfConstraint)
}
SelectChipRefactor(ref:Refactoring,tipo:string){
  refactor=ref
  this.loadingmodal=false
  console.log(ref)
  try{
  this.Refactor(tipo)
}
  catch{
    this.loadingmodal=true
  }
}
AutocompleteFeatureTermChip(name:string){
  let showfeature=false
  if(this.featureautocomplete!="" && !(name.toLowerCase().indexOf(this.featureautocomplete.toLowerCase())!=-1)){showfeature=true}
  return showfeature
}





RefactorvisibleFeature(ref:Refactoring){
  if(this.actual!=undefined){
  if(ref.instances.includes(this.actual.name)){return false}
  else{return true}}
  else{return true}
}
RefactorvisibleCons(ref:Refactoring){
  if(this.consactual!=undefined){
  if(ref.instances.includes(this.listnamesconstraints[this.npos])){return false}
  else{return true}}
  else{return true}
}

TransformJSON(){

  aux=this.consactual.createListForFile(this.cons,this.typesofconsTerm)
  jsonfeatures=JSON.stringify(this.tree[0], (key, value) => {
      if(value!==null) return value  
  })
  aux=0
  while( aux<this.cons.length){
    
    listnamestext[aux]=JSON.stringify(this.cons[aux], (key, value) => {
    if(value!==null) return value  

    
  })
  console.log(listnamestext[aux])
  aux++
  }
  jsonfeatures= '"name"'+':"'+this.title+'",'+'"features"'+':'+ jsonfeatures
  aux=0
  if(this.listnamesconstraints.length<listnamestext.length){
  alert("not enough names, so new ones are given, Refactoring may fail if not checked")
  aux2=this.listnamesconstraints[this.listnamesconstraints.length-1]
  if(aux2==undefined){aux2="CTC1"}
  else{this.listnamesconstraints.splice(0,this.listnamesconstraints.length)}
  while(this.jsonconstraintTexto.length>this.listnamesconstraints.length){
  aux2=this.listnamesconstraints[this.listnamesconstraints.length-1]
  if(aux2==undefined){aux2="CTC1"}
  aux=0
  aux3=""
  while(!Number.parseInt(aux2[aux])){
    aux3=aux3+aux2[aux]
    aux++
  }
  aux3=aux3+(this.listnamesconstraints.length+1)
  this.listnamesconstraints.push(aux3)
}}
  aux=0
  aux2=""
  while (aux<listnamestext.length){
  aux2=aux2+'{"name":"'+this.listnamesconstraints[aux]+'","expr":"'+this.jsonconstraintTexto[aux]+'","ast":'+listnamestext[aux]+'},'
  console.log(listnamestext[aux])
  aux++
  
  }
  aux2=aux2.slice(0,aux2.length-1)
  aux2='"constraints": ['+aux2+']'
  json='{'+jsonfeatures+','+aux2
  aux=0
  aux2=""
  while (aux<this.ListOfRefactors.length){
  aux2=aux2+'{"id":"'+this.ListOfRefactors[aux].id+'","name":"'+this.ListOfRefactors[aux].name+'","description":"'+this.ListOfRefactors[aux].description
  +'","type":"'+this.ListOfRefactors[aux].type+'","instances":[';
  this.ListOfRefactors[aux].instances.forEach(element => {
    aux2=aux2+'"'+element+'",'
  });
  if(aux2[aux2.length-1]!="["){aux2=aux2.slice(0,aux2.length-1)}
  aux2=aux2+']},'
  aux++
  }
  aux2=aux2.slice(0,aux2.length-1)
  aux2='"refactorings": ['+aux2+']'
  json=json+','+aux2+'}'
  this.cons=this.consactual.createListForTree(this.cons)
}



updatevalues(){
  aux=this.consactual.createListForFile(this.cons,this.typesofconsTerm)
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

SaveJson() {
  this.TransformJSON()
  let file = new Blob([json], { type: 'json' });
  saveAs(file, this.title+'.json')
}
SaveUVL() {
  this.TransformJSON()
  console.log("llego")
  aux = new Blob([json], { type: 'json' });
  console.log(aux)
  this.sendJSON()
  //this.CreateData(resultado)
  alert("I should send the json file to the server,and then download the data as an UVL file")
  let file2 = new Blob(["resultado"], { type: 'uvl' });
  saveAs(file2, this.title+'.uvl') 
}
 ShowPages(){
  let values
  values=this.jsonconstraintextshort.slice(this.page*this.range,(this.page+1)*this.range)
  return [values,this.jsonconstraintextshort.length]
 }
 
 onSelectionChanged(event){
  this.page=event.pageIndex
  this.range=event.pageSize
 }
 
 AutocompleteConstraintList(){
  this.jsonconstraintextshort=[]
  if(this.ConstraintListautocomplete!=""){
    this.jsonconstraintTexto.forEach(element => {
    if(element.toLowerCase().indexOf(this.ConstraintListautocomplete.toLowerCase())!=-1){
      this.jsonconstraintextshort.push(element)
    }
    if((this.listnamesconstraints[this.jsonconstraintTexto.indexOf(element)].toLowerCase().indexOf(this.ConstraintListautocomplete.toLowerCase())!=-1)){
      if(this.jsonconstraintextshort.indexOf(element)==-1){
      this.jsonconstraintextshort.push(element)}
    }
  });
  }
  else{
    this.jsonconstraintextshort=this.jsonconstraintTexto}
}

}

