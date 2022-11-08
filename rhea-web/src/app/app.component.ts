import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {FMTree} from './components/FMTree/FMTree';
import{Const} from './components/constraint/const';
import{Data} from './components/Repository/Repository';
import * as saveAs from 'file-saver';
import { Refactoring } from './components/refactor/refactoring';
import { Language } from './components/Language/Language';
import { Semantics } from './components/Semantics/Semantics';



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

  urldownload="http://127.0.0.1:5000/downloadFM"  
  urlupload="http://127.0.0.1:5000/uploadFM"  
  urldelete="http://127.0.0.1:5000deleteFM" 
  urlcreate="http://127.0.0.1:5000createFM" 
  urlrefactor="http://127.0.0.1:5000/refactor" 
  urlupdate="http://127.0.0.1:5000/updateFM" 

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
  item:string ='';
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
  documents:string[]= ['Pizzas_completo_new.json','GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];
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


  mainhidden=true
  windowFM_Editor=false
  windowAbout=false
  windowRepository=true

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
  jsonsemantic:Array<Semantics>=[]
  semantic:Semantics=new Semantics()
  loglist: Array<string>=[];
  myArticle=new Data('','','',0,'',"",'',0,0,'','');

constructor(private http: HttpClient ) { }  



ngOnInit() {
  console.log("separar html en partes funcionales || falta enviar informacion a cada componente || Errores en algunas funciones que estan en ambos sitios(?)")
  console.log("posible implementacion de mejora en visualicacion arbol constraint y eliminar el paso de quitar el operands y type de  createListForTree  y de createListForFile")
  console.log("En information poner que el value 0 oculte la linea, dejar para lidia")
  console.log("create chiled y create brother no tienen sentido para el constraint")
  this.returnValues('Pizzas_completo_new.json')
}


  
showFM_Editor(){
  this.windowFM_Editor=true
  this.windowAbout=false
  this.windowRepository=false
}
showAbout(){
  this.windowFM_Editor=false
  this.windowAbout=true
  this.windowRepository=false
}
showRepository(){
  this.windowFM_Editor=false
  this.windowAbout=false
  this.windowRepository=true
}


sendUVL(uvl:any){
  console.log(uvl)
  const formData: FormData = new FormData();
  formData.append('file', uvl, uvl.name);
  console.log("llego")
  this.http.post(this.urlupload,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    this.loglist.unshift(uvl.name+" was loaded")
    json=resultado
      }
    )
}



sendUpdate(){
  this.TransformJSON()
  let file = new Blob([json], { type: 'json' });
  const formData: FormData = new FormData();
  formData.append('file', file,this.title+'.json')
  formData.append('fm_hash',this.my_session);
  console.log(this.title+'.json')
  this.http.post(this.urlupdate,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    json=resultado
      }
    )
}


Refactor(typeref:string){
  let object
  this.loadingmodal=true
  const formData: FormData = new FormData();
  if( typeref!="all" &&( refactor==undefined ||refactor.name=="")){console.log("error in type of refactor")}
  else{
    if(typeref=="node"){object=this.actual.name;formData.append('instance_name',object);}
    if(typeref=="cons"){object=this.listnamesconstraints[this.npos];formData.append('instance_name',object);}
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
    formData.append('fm_hash',this.my_session);
    this.http.post(this.urlrefactor,formData,{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.CreateData(resultado)
    json=resultado
    })
  }
  }
}


returnValues(text?:string){
  this.loglist=[]
  this.loadingmodal=false
  if(text==""|| text==undefined){text=this.item;this.loadingmodal=true}
  this.http.post(this.urldownload,text,{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
     try{this.CreateData(resultado,text)
      this.loglist.unshift(this.item+" was loaded")
    }
     catch{
    this.loadingmodal=true
    this.loglist.unshift("fail to load the model")
  }
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
  this.jsonsemantic=aux.semantics_metrics
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
  this.CreateSemantics()
  this.loadingmodal=true
  this.mainhidden=false
}
showModal(){
  if(!this.loadingmodal){
    return ["../assets/img/loading.gif",true]
  }
  else{
  return ["a",false]}
}
web(Article:Data){
  if(Article.Ref!=undefined){
  window.open(Article.Ref);}
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
  aux=this.actual.name
  if(this.actual.name!=this.name){
    this.loglist.unshift(this.actual.name+" was modify and its new name is: "+this.name)
  }
  else{
    this.loglist.unshift(this.actual.name+" was modify ")
  }
this.actual.name=this.name
this.actual.abstract=this.abstract
this.actual.attributes=this.attributes
this.namesFeatures=this.tree[0].ListOfNamesModified(this.actual.name,aux)
if(this.cons[0]!=undefined){
this.cons[0].checkName(this.cons,this.actual.name,aux)}
try{
  this.sendUpdate()}
catch{
  this.loadingmodal=true
  }
}



DeleteNode(){
  this.loadingmodal=false
  this.actualfather=this.GetFather(this.actual,this.tree)
  this.loglist.unshift(this.actual.name+" was deleted")
  
  this.namesFeatures=this.actual.Delete(this.actualfather)
  console.log(this.namesFeatures)
  let count =0
  console.log(this.namesFeatures)
  while(count<jsonconstraint.length){
    this.checkedconst(jsonconstraint[count],jsonconstraint[count])
    if(!aux2){
    count++
    }
    else{aux2=false}
  }
  console.log(jsonconstraint)
  try{
    this.sendUpdate()}
  catch{
    this.loadingmodal=true
    }
}
checkedconst(cons:Const,consInitial:Const){
  if(this.typesofconsTerm.indexOf(cons.type)!=-1){
    cons.operands.forEach(element => {
      this.checkedconst(element,consInitial)
    });
  }
  else{
  if(this.namesFeatures.indexOf(cons.type)==-1){
    aux=jsonconstraint.indexOf(consInitial)
    console.log(aux)
    if(aux!=-1){
      jsonconstraint.splice(aux,1)
      this.listnamesconstraints.splice(aux,1)
      this.jsonconstraintTexto.splice(aux,1)
      listnamestext.splice(aux,1)
      this.listnamesconstraints.splice(aux,1)
    }
    aux2=true
    //jsonconstraint=jsonconstraint.filter(x=>x!=consInitial)
  }
}
    
}
isFeature(){
  if(this.actual!=undefined){
  if(this.actual.name!=undefined){
    return true
  }
  else{
    return false
  }
  
}else{return true}
}

CreateChildren(){
  this.loadingmodal=false
  this.loglist.unshift(this.actual.name+" insert "+this.name+" as a child ")
  if(this.actual.children==undefined){this.actual.children=[]}
  if(this.isFeature()){
  let relations = new FMTree()
  relations.type=this.type
  relations.card_max=1;
  relations.card_min=0;
  relations.children=[]
  this.actual.children.push(relations)
  }
  else{
    let feature = new FMTree()
    feature.name=this.name
    feature.abstract=false;
    feature.children=[]
    this.actual.children.push(feature)
    this.tree[0].ExpandList(this.name)
  }
  try{
    this.sendUpdate()}
  catch{}
    this.loadingmodal=true
}
CreateBrother(){
  this.loadingmodal=false
  if(this.actualfather==undefined){
    console.log("You are trying to create a new root")
  }
  if(this.actualfather.children!=undefined){
  this.loglist.unshift(this.actual.name+" create "+this.name+" as a brother ")
  if(!this.isFeature()){
    let relations = new FMTree()
    relations.type=this.type
    relations.card_max=1;
    relations.card_min=0;
    relations.children=[]
    this.actualfather.children.push(relations)
    }
    else{
      let feature = new FMTree()
      feature.name=this.name
      feature.abstract=false;
      feature.children=[]
      this.actualfather.children.push(feature)
      this.tree[0].ExpandList(this.name)
    }
  try{
    this.sendUpdate()}
  catch{}
  }
  this.loadingmodal=true
}





constrainthasChild = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;


CreateCons(){
  console.log("create constraints")
  this.position=-1
  this.cons.splice(0,this.cons.length)
  aux2=0
  this.consactual=new Const()
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
  this.tree[0]=this.tree[0].CreateNewFMTree(jsonfeatures)
  this.namesFeatures=this.tree[0].ListOfNames();
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
CreateSemantics(){
  console.log("create Semantics metrics")
  this.jsonsemantic=this.semantic.CreateSemantics(this.jsonsemantic)
}

DeleteFMTree(){
  this.dataSource.data=[]
  this.constraindataSource.data=[]
}



changeListener($event): void {
  if($event.target.files[0].name!=undefined){
  this.myfile_name=$event.target.files[0].name
  this.myfile=$event.target}
}

readThis(inputValue: any): void { 
  this.loglist=[]
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
    this.name=""
    this.abstract=false

    this.type=""
    this.card_max=-1
    this.card_min=-1

    if(this.actual.name!=undefined){this.name=this.actual.name}
    if(this.actual.abstract!=undefined){this.abstract=this.actual.abstract}

    if(this.actual.type!=undefined){this.type=this.actual.type}
    if(this.actual.card_max!=undefined){this.card_max=this.actual.card_max}
    if(this.actual.card_min!=undefined){this.card_min=this.actual.card_min}
    this.attributes=this.actual.attributes||[]
    this.actualfather=this.GetFather(this.actual,this.tree)
    console.log(this.actualfather)

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
    this.npos=a
    this.consactual=this.cons[this.position]
    console.log(this.consactual)
  }
  DeleteCons(){
    this.loadingmodal=false
    this.loglist.unshift("constraint at "+(this.position+1)+"ª was deleted")
    if(this.consactualfather==undefined ||this.consactualfather.type=="" ){
    if( this.consactual.type=='' && this.position!= undefined && this.position!=-1){
      this.cons.splice(this.position,1)
      this.jsonconstraintTexto.splice(this.position,1)
      this.listnamesconstraints.splice(this.position,1)
      this.position=-1
    }
    if(this.consactual!=undefined){
      /*
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
      
      else */{
        if(this.position!=-1){
        this.jsonconstraintTexto.splice(this.position,1)
        this.listnamesconstraints.splice(this.position,1)
        this.cons.splice(this.position,1)
        this.position=-1}
      }
    }
    if(this.cons.length==0){this.cons.push(new Const);console.log("7")}
    try{
      this.sendUpdate()}
    catch{
      this.loadingmodal=true
      }}
      else{this.loadingmodal=true}
  }

  CreateListCons(){
    console.log(this.ListOfConstraint[0])
    if(this.ListOfConstraint.length==2 && this.ListOfConstraint[0].type=="NotTerm"){
      this.ListOfConstraint[0].operands=[]
      this.ListOfConstraint[0].operands.push(this.ListOfConstraint[1]);
    }
    if(this.ListOfConstraint.length>2 && this.ListOfConstraint[0].type!="NotTerm"){
      this.ListOfConstraint[0]=this.consactual.ListOfNewConstraint(this.ListOfConstraint)
    }
    aux4=true
    this.checkListofconstraint(this.ListOfConstraint[0])
    console.log(aux4)
    aux3=[]
    this.checkListofconstraint2(this.ListOfConstraint[0])
    console.log(aux3.length)
    console.log(aux4)
    console.log(this.ListOfConstraint.length)
    if(aux3.length<this.ListOfConstraint.length){
      aux4=false
    }
    console.log(aux4)
    return this.ListOfConstraint[0]
  }
  checkListofconstraint2(list:Const){
    if(list!=undefined){
    if(list.type!=""){
      aux3.push(list)
      if(list.operands!=null &&list.operands!= undefined ){
        list.operands.forEach(element => {
          this.checkListofconstraint2(element)
        });
      }
    }}
  }

  checkListofconstraint(list:Const){
    if(list==undefined){}
    else{
    if(list.operands==null){}
    else{
    if(this.typesofconsTerm.indexOf(list.type)==-1){
    }
    else{
    if(list.type=="NotTerm"){
      if(list.operands.length==1){
        this.checkListofconstraint(list.operands[0])
      }
      else {aux4=false}
    }
  else{
    if(list.operands.length==2){
      if(list.operands[0].type==""){aux4=false}
      else{this.checkListofconstraint(list.operands[0])}
      if(list.operands[1].type==""){aux4=false}
      else{this.checkListofconstraint(list.operands[1])}
    }
    else {aux4=false}
      }
    } }}
    return aux4
  }

  ModifyCons(){
    this.loadingmodal=false
    if(this.ListOfConstraint.length!=0&&this.ListOfConstraint!=undefined){
      this.CreateListCons()
    if(aux4){
    if(this.consactualfather==undefined ||  this.consactualfather.type==""){
      this.loglist.unshift("constraint at "+(this.position+1)+"ª was modify")
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
    }}
    this.ListOfConstraint=[]
    try{
      this.sendUpdate()}
    catch{
      this.loadingmodal=true
      }
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




SymbolPerType(nodechild:FMTree){ 
  let symbol=""
  let text=""
  let symbol2=""
  let text2=""

  if(this.GetFather(nodechild,this.tree)==undefined){symbol="../assets/img/featuretree.ico";text="root"}
  else{

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
  this.loadingmodal=false
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
}
  this.ListOfConstraint=[]
  try{
    this.sendUpdate()}
  catch{
    this.loadingmodal=true
    }
}

CreateConsSon(){
  this.loadingmodal=false
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
  try{
    this.sendUpdate()}
  catch{
    this.loadingmodal=true
    }
}


DeleteConsText(){
  this.jsonconstraintTexto.splice(this.position,1)
  this.listnamesconstraints.splice(this.position,1)
  this.sendUpdate()
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
  this.loglist.unshift(ref.id+" was made for a "+tipo)
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


TransformJSON(){
  aux=this.consactual.createListForFile(this.cons,this.typesofconsTerm)
  /*jsonfeatures=JSON.stringify(this.tree[0], (key, value) => {
      if(value!==undefined && value!==null) return value  
  })*/
  this.tree[0]=this.tree[0].Relations(this.tree[0])
  aux=JSON.stringify(this.tree)
  jsonfeatures=aux.slice(1,-1)
  aux=0
  while( aux<this.cons.length){
    
    listnamestext[aux]=JSON.stringify(this.cons[aux], (key, value) => {
    if(value!==null) return value  

    
  })
  aux++
  }
  jsonfeatures= '"name"'+':"'+this.title+'",'+'"features"'+':'+ jsonfeatures
  aux=0
  if(this.listnamesconstraints.length<listnamestext.length){
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
  if(this.jsonconstraintTexto.length!=0){
  while (aux<this.jsonconstraintTexto.length){
  aux2=aux2+'{"name":"'+this.listnamesconstraints[aux]+'","expr":"'+this.jsonconstraintTexto[aux]+'","ast":'+listnamestext[aux]+'},'
  aux++
  
  }
  aux2=aux2.slice(0,aux2.length-1)
  aux2='"constraints": ['+aux2+']'
  json='{'+jsonfeatures+','+aux2+'}'}
  else{
    json='{'+jsonfeatures+',"constraints": []}'
  }
  /*
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
  json=json+','+aux2+'}'*/
  this.cons=this.consactual.createListForTree(this.cons)
  console.log(json)
}


SaveFile(language:string){
  console.log(language)
  if(language.toLowerCase()=="uvl"){
    this.SaveUVL()
  }
  if(language.toLowerCase()=="json"){
    this.SaveJson()
  }
}

Save(text:string){
  this.SaveJson()
  //should go to the server directly with the lenguage for it, and then here selec it for de type of blob
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

