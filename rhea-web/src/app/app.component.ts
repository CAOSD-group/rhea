import {Component,ElementRef,inject, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import {FMTree} from './components/FMTree/FMTree';
import{Const} from './components/constraint/const';
import{Data, Repository} from './components/Repository/Repository';
import * as saveAs from 'file-saver';
import { Refactoring } from './components/refactor/refactoring';
import { Language } from './components/Language/Language';
import { Semantics } from './components/Semantics/Semantics';
import { ToolsExtension } from './components/ToolsExtension/ToolsExtension';
import { FeatureTree } from './components/mainpage/FeatureTree/FeatureTree';
import {MatSnackBar, MatSnackBarRef} from '@angular/material/snack-bar';
import { DrawerComponent } from './components/drawer/drawer.component';
import { DataServices } from 'src/data.services';

//const mariadb = require('mariadb');
// const pool = mariadb.createPool({
//   host: "localhost", 
//   user: "caosd", 
//   password: "password",
//   database:"rhea"});

//   async function sendQuery() {
//     let conn;
//     try { 
//       conn = await pool.getConnection();
//       const rows = await conn.query("SELECT * FROM Repository");       // rows: [ {val: 1}, meta: ... ]
//       //const res = await conn.query("INSERT INTO myTable value (?, ?)", [1, "mariadb"]);       // res: { affectedRows: 1, insertId: 1, warningStatus: 0 }
//     } finally {
//       if (conn) conn.release(); //release to pool
//     }
//   }

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
  selector: 'snack-bar-annotated-component-example-snack',
  templateUrl: './components/snackbar.html',
  styleUrls: ['./app.component.css']
})
export class PizzaPartyAnnotatedComponent {
  snackBarRef = inject(MatSnackBarRef);
}



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent {

  
  
  // urldownload="http://127.0.0.1:5000/api/downloadFM"  
  // urldocuments="http://127.0.0.1:5000/api/getExampleFMs"
  // urluploadExampleFM="http://127.0.0.1:5000/api/uploadExampleFM"  
  // urlupload="http://127.0.0.1:5000/api/uploadFM"  
  // urlrefactor="http://127.0.0.1:5000/api/refactor" 
  // urlupdate="http://127.0.0.1:5000/api/updateFM" 
  // urlcur="http://127.0.0.1:5000/api/getCur"                     //<---"https://rhea.caosd.lcc.uma.es/getCur"     
  // urlinsertcur="http://127.0.0.1:5000/api/insertIntoRepository" //<---"https://rhea.caosd.lcc.uma.es/insertIntoRepository"
  // urlgetfile="http://127.0.0.1:5000/api/getFile" 
  // urltextcons="http://127.0.0.1:5000/api/checktextcons"         //<--- "https://rhea.caosd.lcc.uma.es/checktextcons" 
  // urlnewcons="http://127.0.0.1:5000/api/createcons"             //<--- https://rhea.caosd.lcc.uma.es/

 // FOR DEVELOPER: for any new url the backend get , it must be update in the apache2 file for the web to work in de sites-available domain.conf, then restart apache, and the frontend and backend"

  urldownload="https://rhea.caosd.lcc.uma.es/api/downloadFM"  
  urldocuments="https://rhea.caosd.lcc.uma.es/api/getExampleFMs"
  urluploadExampleFM="https://rhea.caosd.lcc.uma.es/api/uploadExampleFM"  
  urlupload="https://rhea.caosd.lcc.uma.es/api/uploadFM"  
  urlrefactor="https://rhea.caosd.lcc.uma.es/api/refactor" 
  urlupdate="https://rhea.caosd.lcc.uma.es/api/updateFM" 
  urlcur="https://rhea.caosd.lcc.uma.es/api/getCur"                             //404
  urlinsertcur="https://rhea.caosd.lcc.uma.es/api/insertIntoRepository"         //404 
  urlgetfile="https://rhea.caosd.lcc.uma.es/api/getFile" 
  urltextcons="https://rhea.caosd.lcc.uma.es/api/checktextcons"                 //404
  urlnewcons="https://rhea.caosd.lcc.uma.es/api/createcons"                     //404
  
  declare actual:FMTree     
  declare actualfather:FMTree 
  tree:Array<FMTree> =[new FMTree()]  

  consactual:Const =new Const()     
  consactualfather:Const =new Const()     
  cons:Array<Const>=[new Const()]  

  ListOfRefactors:Array<Refactoring>=[]



  treeControl = new NestedTreeControl<FMTree>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FMTree>();
  constraintreeControl = new NestedTreeControl<Const>(node => node.operands);
  constraindataSource = new MatTreeNestedDataSource<Const>();
    
  //list of constraints and feature names
  typesofcons:Array<string>=['NOT','OR','AND','IMPLIES','XOR','REQUIRES','EXCLUDES','EQUIVALENCE']
  typesofconsparan:Array<string>=['NOT','OR','AND','IMPLIES','XOR','REQUIRES','EXCLUDES','EQUIVALENCE','(',')']
  typesofconsTerm:Array<string>=['NotTerm','OrTerm','AndTerm','ImpliesTerm','XorTerm','RequiresTerm','ExcludesTerm','EquivalenceTerm']
  textnewcons=""
  namesFeatures:Array<string>=[]
  listFeatures:Array<FMTree>=[]
 
  //other
  title:string='';
  item:string ='';
  jsonconstraintTexto: Array<string>=[]

  // modify or create FMTree
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
  documents:string[]= [""];
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
  loadingtext=""

  mainhidden=true//(mainhidden)="windowFM_Editor_drawer($event)"
  windowFM_Editor=true
  windowAbout=false
  windowRepository=false
  windowGuide=false

  @ViewChild(DrawerComponent) drawer;

  updatable=false
  page=0;
  range=10;
  loadingmodal=true
  jsonconstraintextshort: Array<string>=[]
  listnamesconstraints:Array<string>=[]
  jsonlanguage:Array<Language>=[]
  jsonLanguageextension:Array<ToolsExtension>=[]
  toolsExtension=new ToolsExtension()

  ListLanguage:Array<string>=[]
  language:Language=new Language()
  ListOfConstraint:Array<Const>=[]
  position:number=0
  my_session=""
  jsonsemantic:Array<Semantics>=[]
  semantic:Semantics=new Semantics()
  loglist: Array<string>=[];
  logselect: Array<number>=[];
  myArticle=new Data(0,'','','','',0,'','','',0,0,'','','','','')

  logposition=-1
  loghash:Array<string>=[]
  data

  Namerepo=""
  Author=""
  Owner=""
  Ref=""
  Year=""
  Domain=""
  Version=""
  Language_level=""
  declare Filerepo:File
  Rating=""
  Description=""
  Organization=""


  textconsvalid=false
  url_src:any


constructor(private http: HttpClient,private _snackBar: MatSnackBar, private dataService:DataServices) { }  



ngOnInit() {
this.getDocumentName()
this.dataService.querySQL()
//sendQuery()
}


SelectFilerepo($event){

  this.Filerepo=$event.target.files[0];
  var myReader: FileReader = new FileReader();
  myReader.readAsText(this.Filerepo);
  myReader.onloadend = function (e) {
  aux=myReader.result;}
  console.log(this.Filerepo)
}


InsertIntoRepo(){ //Request not posted when File is empty

  //console.log(this.Filerepo)
  const formData: FormData = new FormData();
  formData.append('Name', this.Namerepo);
  formData.append('Author', this.Author);
  formData.append('Owner', this.Owner);
  formData.append('Ref', this.Ref);
  formData.append('Year', this.Year);
  formData.append('Domain', this.Domain);
  formData.append('Version', this.Version);
  formData.append('Language_level', this.Language_level);
  formData.append('File', this.Filerepo);
  formData.append('Hash', this.my_session);
  formData.append('Rating', this.Rating);
  formData.append('Description', this.Description);
  formData.append('Organization', this.Organization);

  this.http.post(this.urlinsertcur,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado=>{console.log(resultado)})
}

getFile(){ 
  
  if(this.myArticle.Id!=undefined){

    const formData: FormData = new FormData();
    
    formData.append('Id', this.myArticle.Id.toString());
    formData.append('Format', this.myArticle.Format || "");
    
    this.http.post(this.urlgetfile,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado=>{
      this.loadingtext="Server responded"
      let file = new Blob([resultado], { type: this.myArticle.Format });
      saveAs(file, this.myArticle.Name + "."+ this.myArticle.Format)
    })
  }
}


Movehistory(reundo:number){
  this.loadingmodal=false
  this.logposition=this.logposition+reundo
  const formData: FormData = new FormData();
  formData.append('fm_hash',this.loghash[this.logposition])
  formData.append('fm_format', 'json');
  this.loadingtext="Sending hash to server"
  this.http.post(this.urldownload,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado=>{
    this.loadingtext="Server responded"
    this.CreateData(resultado)
    json=resultado
  })
}
  
showFM_Editor(){
  this.windowFM_Editor=true
  this.windowAbout=false
  this.windowRepository=false
  this.windowGuide=false
}
showAbout(){
  this.windowFM_Editor=false
  this.windowAbout=true
  this.windowRepository=false
  this.windowGuide=false
}
showRepository(){
  this.windowFM_Editor=false
  this.windowAbout=false
  this.windowRepository=true
  this.windowGuide=false
}
showGuide(){
  this.windowFM_Editor=false
  this.windowAbout=false
  this.windowRepository=false
  this.windowGuide=true
}

Name(name:string){
  this.myfile_name=name;
}

Save(text:number){
  if(this.myfile_name==""){
    this.myfile_name=this.title
  }
  console.log(this.myfile_name)
  this.loglist.unshift("File "+this.myfile_name+" download as ."+this.jsonLanguageextension[text].extension)
  this.loadingmodal=false
  const formData: FormData = new FormData();
  formData.append('fm_format', this.jsonLanguageextension[text].extension);
  formData.append('fm_hash',this.my_session);
  this.loadingtext="Sending file to the server"
  this.http.post(this.urldownload,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {  
    this.loadingtext="Server responded"
    let file = new Blob([resultado], { type: this.jsonLanguageextension[text].extension });
    saveAs(file, this.myfile_name+ "."+this.jsonLanguageextension[text].extension)
      }
    )
  
}

sendFile(uvl:any){
  const formData: FormData = new FormData();
  this.logselect=[]
  formData.append('file', uvl, uvl.name);
  this.loadingtext="Sending file to the server"
  this.http.post(this.urlupload,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {  
    this.loadingtext="Server responded"
    this.CreateData(resultado)
    json=resultado
      }
    )
}

getDocumentName(){
    this.http.get(this.urldocuments).subscribe(resultado => {
    aux=resultado
    this.documents=aux 
    this.returnValues(this.documents[0])
      }
    )

}

LogRoot(text:string){
  this.loglist.unshift(text);
}

sendUpdate(myjson?:boolean){
  if(myjson==undefined){ this.TransformJSON()}
  let file = new Blob([json], { type: 'json' });
  const formData: FormData = new FormData();
  formData.append('file', file,this.title+'.json')
  formData.append('fm_hash',this.my_session);
  this.loadingtext="Sending information to the server"
  this.loadingmodal=false
  this.http.post(this.urlupdate,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.loadingtext="Server responded"
    this.CreateData(resultado)
    json=resultado
      }
    )
}


Refactor(typeref:string){
  let object
  this.loadingmodal=false
  const formData: FormData = new FormData();
  if( typeref!="all" &&( refactor==undefined ||refactor.name=="")){}
  else{
    if(typeref=="node"){object=this.actual.name;formData.append('instance_name',object);}
    if(typeref=="cons"){object=this.listnamesconstraints[this.npos];formData.append('instance_name',object);}
    if(typeref=="node"||typeref=="cons"||typeref=="all"){
    if(refactor.id=="CardinalityGroupRefactoring"|| (typeref=="all"&&( refactor.id=="EliminationSimpleConstraintsRequires"||refactor.id=="EliminationSimpleConstraintsExcludes"))){
    }
    formData.append('refactoring_id',refactor.id);
    formData.append('fm_hash',this.my_session);
    this.loadingtext="Sending information to the server"
    this.http.post(this.urlrefactor,formData,{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.loadingtext="Server responded"
    this.CreateData(resultado)
    json=resultado
    })
  }
  }
}


returnValues(text?:string){
  this.loglist=[]
  this.logselect=[]
  this.loglist=[]
  this.loghash=[]
  this.loadingmodal=false
  if(text==""|| text==undefined){text=this.item;this.loadingmodal=true}
  const formData: FormData = new FormData();
  formData.append('filename',text);
  this.loadingtext="Sending data to the server"
  this.http.post(this.urluploadExampleFM,formData,{ withCredentials:true,responseType:'text'}).subscribe(resultado => {
    this.loadingtext="Server responded"
    try{this.CreateData(resultado,text)
    }
    catch{
    this.loadingmodal=true
    this.loglist.unshift("fail to load the model")
  }
  })
  
  
}
CreateData(object:any,name?:string){
  this.treeControl.collapseAll()
  aux = object;
  this.item=name||"";
  if(this.item!=""){this.loglist.unshift(this.item+" was loaded")}
  aux=JSON.parse(aux)
  this.title=aux.name
  jsonfeatures=aux.features,
  jsonconstraint=aux.constraints
  jsonrefactors=aux.refactorings
  this.jsonsemantic=aux.semantics_metrics
  this.jsonlanguage=aux.language_constructs
  this.jsonLanguageextension=aux.tools_info
  this.my_session=aux.hash
  this.textnewcons=""
  this.ListOfConstraint=[]
  if(this.my_session!=this.loghash[this.logposition]){
    if(this.loghash.indexOf(this.my_session)==-1){
      this.loghash.splice(this.logposition+1)
      this.loghash.push(this.my_session)
      this.logposition=this.loghash.length-1
    }
    else{
      this.logposition=this.loghash.indexOf(this.my_session)
    }
  }

  aux2="" 
  try{
  let dictionary = Object.assign({}, object);
  for( const[key] of Object.entries(dictionary)){
    aux2=aux2+dictionary[key]
  }
  aux=JSON.parse(aux2)
  }
  catch{}
  this.CreateSemantics()
  this.loadingtext="Semantics created"
  aux3=aux.constraints
  setTimeout(() => {
  this.CreateCons() 
  this.loadingtext="Constraints created" }, 1);
  setTimeout(() => {
  this.CreateFMTree()  
  this.loadingtext="Features tree created"}, 1);
  if(jsonrefactors!=undefined){
  setTimeout(() => {this.CreateRefactor()}, 1);}
  setTimeout(() => {
  this.loadingtext="Possibles Refactorings added"
  this.CreateLanguage()    
  this.loadingtext="Lenguages details loaded"
  this.CreateToolsExtensions()  }, 1);
  this.mainhidden=false
  setTimeout(() => {
  this.loadingtext="Tree opening"
  this.treeControl.expand(this.tree[0])
  this.OpenTree(this.tree[0])
  this.loadingmodal=true}, 1);
  this.loadingtext="Creating data"
}

OpenTree(node:FMTree){
  let newnode
  if(this.logselect[0]!=undefined){
    if(node.children!=undefined){
    newnode=node.children[this.logselect[0]]
    this.treeControl.expand(newnode)
    this.logselect.splice(0,1)
    this.OpenTree(newnode)
    }
  }
}

showModal(){
  if(!this.loadingmodal){
    return ["../assets/img/loading.gif",true]
  }
  else{
  return ["",false]}
}
web(Article:Data){
  if(Article.Ref!=undefined){
  window.open(Article.Ref);}
}

ChangeType(ty:string){
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

/* ====== Modal de Features (edit)  ====== */ 

selectedOption = ''
minRandomize!: number
maxRandomize!: number
randomValue: number = 0

Randomize_attributes(attr, option){
  this.randomValue = Math.random() * (attr.maxRandomize - attr.minRandomize) + attr.minRandomize 
  
  if(option == 'boolean') { attr.value = Math.random() < 0.5 ? 'true' : 'false'}
  else if((attr.minRandomize <= attr.maxRandomize) && (attr.minRandomize != null) && (attr.maxRandomize != null)){
    if(option == 'int'){
      attr.value = Math.floor(this.randomValue).toString()
    }else if(option == 'double'){
      attr.value = this.randomValue.toFixed(2).toString()
    }
  }
}

Randomize(){
  for (let attr of this.attributes){
    this.Randomize_attributes(attr, attr.selectedOption)
  }
}

ModifySelection(){
this.loadingmodal=false
if(this.isFeature()){
  aux=this.actual.name
  if(this.actual.name!=this.name){
    this.loglist.unshift(this.actual.name+" was modify and its new name is: "+ this.name)
  }
  else{
    this.loglist.unshift(this.actual.name+" was modify ")
  }
this.actual.name=this.name
this.actual.abstract=this.abstract
this.actual.attributes=this.attributes
if(this.actualfather!=undefined){
  if(this.actualfather.type=="MANDATORY"||this.actualfather.type=="OPTIONAL"){
  if(this.optional){
    this.actualfather.type="OPTIONAL"
  }
  else{
    this.actualfather.type="MANDATORY"
  }}
}
this.namesFeatures=this.tree[0].ListOfNamesModified(this.actual.name,aux)
if(this.cons[0]!=undefined){
this.cons[0].checkName(this.cons,this.actual.name,aux)}
}
else{
  this.actual.type=this.type
  if(this.type=="FEATURE" || this.type=="MANDATORY" ||this.type=="OPTIONAL"){
    if(!this.optional){
      this.actual.type="MANDATORY"
      this.actual.card_max=1
      this.actual.card_min=1
    }
    else{
      this.actual.type="OPTIONAL"
      this.actual.card_max=1
      this.actual.card_min=0
    }
    if(this.actual.children!=undefined){
    if(this.actual.children?.length>1){
      let list:Array<FMTree>=[]
      this.actual.children.forEach(element => {
        aux=new FMTree()
        aux.type=this.actual.type
        aux.card_max=this.actual.card_max
        aux.card_min=this.actual.card_min
        aux.children=[]
        aux.children.push(element)
        list.push(aux)
      });
      aux=list.length-1
      while(aux!=-1){
        this.actualfather.children?.unshift(list[aux])
        aux--
      }
      this.actualfather.children=this.actualfather.children?.filter(x=>x!=this.actual)
    }}
  }
  else{
    if(this.actual.children!=undefined){
    if(this.actual.children.length<2){
      aux=new FMTree()
      aux.name="AutoChild"
      aux.abstract=false;
      aux.children=[]
      this.actual.children.push(aux)
    }}
    if(this.type=="CARDINALITY"){
      if(this.actual.children!=undefined){
        if(this.card_max>this.actual.children.length){
          this.card_max=this.actual.children.length
          if(this.card_min>this.card_max){
            this.card_min=this.card_max
          }
        }
      }
      this.actual.card_max=this.card_max
      this.actual.card_min=this.card_min
    }
  }
}
try{
  this.sendUpdate()}
catch{
  this.loadingmodal=true
  }
}

CreateAttribtues(){
  let newvalue={name:"new name",value:"new value", selectedOption:'', minRandomize: 0, maxRandomize: 0}
  if(this.attributes==undefined){this.attributes=[]}
  this.attributes.push(newvalue)
}

/* ====== fin de Modal de Features (edit)  ====== */ 


DeleteNode(){
  console.log(this.actual)
  this.loadingmodal=false
  this.actualfather=this.GetFather(this.actual,this.tree)
  if(this.actualfather==undefined){
    json='{"name":"Empty","features":{"name":"Empty","abstract":false,"attributes":[],"relations":[]},"constraints": []}'
    try{
      this.loglist.unshift("Empty tree was created")
      this.sendUpdate(false)}
    catch{
      this.loadingmodal=true
      }
  }
  else{
  if(this.isFeature() && this.actualfather.children?.length==1){
      aux3=this.actual.name
      this.actual=this.actualfather
      this.logselect.splice(-1,1)
      this.DeleteNode()
  }
  else{
  if(this.isFeature() && this.actualfather.children?.length==2){
    if(this.actualfather.type=="MUTEX" ||( this.actualfather.type=="CARDINALITY" && this.actualfather.card_min==0)){
      this.actualfather.type="OPTIONAL"
      this.actualfather.card_max=1
      this.actualfather.card_min=0
    }
      else{this.actualfather.type="MANDATORY"
      this.actualfather.card_max=1
      this.actualfather.card_min=1
    }
  }
  this.namesFeatures=this.actual.Delete(this.actualfather)
  let count =0
  while(count<jsonconstraint.length){
    this.checkedconst(jsonconstraint[count],jsonconstraint[count])
    if(!aux2){
    count++
    }
    else{aux2=false}
  }
  if(this.actual.name!=""){this.loglist.unshift(this.actual.name+" was deleted")}
  else{this.loglist.unshift(this.actualfather.name+" deleted one of its relations")}
  this.logselect.splice(-1,1)
  try{
    this.sendUpdate()}
  catch{
    this.loadingmodal=true
    }}}
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
isRelationFeature(){
  let bool=true
  if(this.actualfather!=undefined){
  if(this.actualfather.type!=undefined){
    if(this.actualfather.type=="MANDATORY"||this.actualfather.type=="OPTIONAL"){
      bool=false
    }
  }}
  return bool
}

CreateChildren(){
  this.loadingmodal=false
  if(this.type==undefined||this.type==""||this.type=="MANDATORY"||this.type=="OPTIONAL"){
    this.type="FEATURE"
  }
  if(this.actual.children==undefined){this.actual.children=[]}
  if(this.isFeature()){
  let relations = new FMTree()
  relations.type=this.type
  relations.card_max=1;
  relations.card_min=0;
  relations.children=[]
  if(this.type=="FEATURE"){
    if(this.optional){
      relations.type="OPTIONAL"
      relations.card_max=1
      relations.card_min=0
    }
    else{
      relations.type="MANDATORY"
      relations.card_max=1
      relations.card_min=1
    }
    aux=new FMTree()
    aux.name="AutoChild"
    aux.abstract=false;
    aux.children=[]
    relations.card_max=0
    relations.children.push(aux)
  }
  else{
    if(this.type=="CARDINALITY"){relations.card_max=2;}
    aux=new FMTree()
    aux.abstract=false;
    aux.children=[]
    aux2=new FMTree()
    aux2.abstract=false;
    aux2.children=[]
    aux.name="AutoChild1"
    aux2.name="AutoChild2"
    relations.children.push(aux)
    relations.children.push(aux2)
  }
  this.loglist.unshift(this.actual.name+" insert "+relations.type+" as a child ")
  this.actual.children.push(relations)
  }
  else{
    let feature = new FMTree()
    feature.name=this.name
    feature.abstract=false;
    feature.children=[]
    this.actual.children.push(feature)
    this.loglist.unshift(this.actual.type+" insert "+feature.name+" as a child ")
    this.tree[0].ExpandList(feature)
  }
  if(this.actualfather!=undefined){
    if(this.actualfather.children!=undefined){
    this.logselect.push(this.actualfather.children?.indexOf(this.actual))
  }}
  try{
    this.sendUpdate()}
  catch{
    this.loadingmodal=true}
}
CreateBrother(){
  this.loadingmodal=false
  if(this.actualfather==undefined){
    this.loadingmodal=true
    alert("you can not create a brother")
  }
  else{
  if(this.actualfather.children!=undefined){
  if(!this.isFeature()){
    let relations = new FMTree()
    relations.type=this.type
    relations.card_max=1;
    relations.card_min=0;
    relations.children=[]
    if(this.type=="FEATURE"){
      if(this.optional){
        relations.type="OPTIONAL"
        relations.card_max=1
        relations.card_min=0
      }
      else{
        relations.type="MANDATORY"
        relations.card_max=1
        relations.card_min=1
      }
      aux=new FMTree()
      aux.name="FEATURE_child"
      aux.abstract=false;
      aux.children=[]
      relations.card_max=0
      relations.children.push(aux)
    }
    else{
      if(this.type=="CARDINALITY"){relations.card_max=2;}
      aux=new FMTree()
      aux.abstract=false;
      aux.children=[]
      aux2=new FMTree()
      aux2.abstract=false;
      aux2.children=[]
      aux.name=this.type+"_child1"
      aux2.name=this.type+"_child2"
      relations.children.push(aux)
      relations.children.push(aux2)
    }
    this.loglist.unshift(this.actual.type+" create "+relations.type+" as a brother ")
    this.actualfather.children.push(relations)
    }
    else{
      let feature = new FMTree()
      feature.name=this.name
      feature.abstract=false;
      feature.children=[]
      if(this.actualfather.type=="MANDATORY"||this.actualfather.type=="OPTIONAL"){
        let relation=new FMTree()
        relation.margin=this.actualfather.margin
        relation.symbol=this.actualfather.symbol
        relation.symbol2=this.actualfather.symbol2
        relation.abstract=this.actualfather.abstract
        relation.optional=this.actualfather.optional
        relation.relations=this.actualfather.relations
        relation.type=this.actualfather.type
        relation.card_max=this.actualfather.card_max
        relation.card_min=this.actualfather.card_min
        relation.children=[]
        relation.children.push(feature)
        aux=this.actualfather.GetFather(this.actualfather,this.tree)
        aux.children.push(relation)
      }
      else{
        this.actualfather.children.push(feature)
      }
      this.loglist.unshift(this.actual.name+" insert "+feature.name+" as a brother ")
      this.tree[0].ExpandList(feature)
    }
  try{
    this.sendUpdate()}
  catch{this.loadingmodal=true}
  }}
  
}


constrainthasChild = (_: number, constrainnode: Const) => !!constrainnode.operands && constrainnode.operands.length >= 0;
hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;


CreateCons(){
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
  this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
}
this.jsonconstraintextshort=this.jsonconstraintTexto
}
nameFeatures(){
  let listname:Array<string>=[]
  this.namesFeatures.forEach(element => {
    if(listname.indexOf(element)==-1){
      listname.push(element)
    }
  });
  return listname
}

CreateFMTree(){
  this.tree.splice(0,this.tree.length)
  this.tree=[new FMTree()]
  this.tree[0].DeleteList();
  this.tree[0]=this.tree[0].CreateNewFMTree(jsonfeatures)
  aux= this.tree[0].GiveValues(this.tree[0])
  aux.forEach(element => {
    this.treeControl.expand(element)
  });
  this.namesFeatures=this.tree[0].ListOfNames();
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
  refactor.DeleteList()
  this.ListOfRefactors=refactor.Create(jsonrefactors);
}
CreateLanguage(){
  this.jsonlanguage=this.language.CreatLanguage(this.jsonlanguage ,jsonrefactors)
  this.ListLanguage=this.language.CreatLanguage2()
}
CreateSemantics(){
  this.jsonsemantic=this.semantic.CreateSemantics(this.jsonsemantic)
}

CreateToolsExtensions(){
this.jsonLanguageextension=this.toolsExtension.CreateTools(this.jsonLanguageextension)
}

DeleteFMTree(){
  this.dataSource.data=[]
  this.constraindataSource.data=[]
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
      setTimeout(() => {
      this.sendFile(file)
      },100)
    }
    if(file.name.endsWith('.uvl')){
      setTimeout(() => {
        this.sendFile(file)
        },100)
    }
    if(file.name.endsWith('.xml')){
      setTimeout(() => {
        this.sendFile(file)
        },100)
    }
    if(!(file.name.endsWith('.xml')||file.name.endsWith('.uvl')||file.name.endsWith('.json'))){
      alert("not valid file type")
    }
  }
  
  }
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
    if(this.actual.type!=undefined && this.actual.type!=""){this.type=this.actual.type}

    if(this.actual.card_max!=undefined){this.card_max=this.actual.card_max}
    if(this.actual.card_min!=undefined){this.card_min=this.actual.card_min}
    this.actualfather=this.GetFather(this.actual,this.tree)
    setTimeout(() => {
    if(this.actualfather!=undefined){
    if(this.actualfather.type!=undefined && this.actualfather.type!=""){this.type=this.actualfather.type}}
    this.optional=true

    if(this.type=="MANDATORY"){
      this.optional=false
    }
    if(this.type=="CARDINALITY" && this.card_min!=0){
      this.optional=false
    }
    if(this.actualfather!=undefined){
    this.listOpen(this.actual,this.actualfather)}
    }, 1);
    this.attributes=this.actual.attributes||[]
    this.logselect=[]
    console.log(this.actual)
  }
  listOpen(child:FMTree,father:FMTree){
    if(father.children!=undefined){
    this.logselect.unshift(father.children?.indexOf(child))}
    if(this.GetFather(father,this.tree)!=undefined){
      this.listOpen(father,this.GetFather(father,this.tree))
    }
  }

  deleteAttributes(value:any){
    this.actual.attributes=this.attributes
    setTimeout(() => {
      this.actual.attributes?.forEach(element => {
        if(element.name==value.name && element.value==value.value){
          this.actual.attributes?.splice(this.actual.attributes?.indexOf(element),1)
        }
      });
      },1)
  }
 

  SelectCons(object:any){
    this.GetFatherCons(object)
    if(this.cons.indexOf(object)!=-1){this.position=this.cons.indexOf(object)}
    this.consactual=object
    this.ncons=this.jsonconstraintTexto[this.position]
    this.npos=this.position
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
    if(this.cons.length==0){this.cons.push(new Const)}
    try{
      this.sendUpdate()}
    catch{
      this.loadingmodal=true
      }}
      else{this.loadingmodal=true}
  }

  CreateListCons(){
    if(this.consactual==undefined){this.consactual=new Const()}
    if(this.ListOfConstraint.length==2 && this.ListOfConstraint[0].type=="NotTerm"){
      this.ListOfConstraint[0].operands=[]
      this.ListOfConstraint[0].operands.push(this.ListOfConstraint[1]);
    }
    if(this.ListOfConstraint.length>2 && this.ListOfConstraint[0].type!="NotTerm"){
      this.ListOfConstraint[0]=this.consactual.ListOfNewConstraint(this.ListOfConstraint)
    }
    aux4=true
    this.checkListofconstraint(this.ListOfConstraint[0])
    return this.ListOfConstraint[0]
  }

  checkListofconstraint(list:Const){
    let color='#6d0202'
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
    if(aux4){
      color="#17700b"
    }
    return [aux4,color]
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



checkCons(){
  const formData: FormData = new FormData();
  formData.append('text', this.textnewcons);

  this.http.post(this.urltextcons,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado=>{
    this.textconsvalid=(resultado.toLowerCase()=="true")

    return this.textconsvalid
  })  
  //return false
}


CreateNewCons(){

  const formData: FormData = new FormData();
  formData.append('text', this.textnewcons);
  formData.append('fm_hash', this.my_session);

  if(this.listnamesconstraints[this.position]!=undefined){formData.append('name', this.listnamesconstraints[this.position]);}
  else{    formData.append('name',"");  }

  /**AQUÍ */
  this.http.post(this.urlnewcons,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado=>{
    console.log("resultado: "+resultado)
    //this.CreateData(resultado)
  })
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

  if(this.GetFather(nodechild,this.tree)==undefined){symbol="./assets/img/featuretree.ico";text="root"}
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
  this.ListOfConstraint=[]
}

CreateConsNew(){
  this.loadingmodal=false
  this.CreateConsList(); 
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
  this.textnewcons=this.textnewcons+" "+text
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
}
setTimeout(() => {
  this.checkListofconstraint(this.ListOfConstraint[0])
}, 1);
}

SelectChipFeature(text:string){
  aux=new Const()
  this.textnewcons=this.textnewcons+" "+text
  aux.type=text
  aux.operands=[]
  if(this.typesofconsTerm.indexOf(text)==-1){
    aux.operands=null
  }
  this.ListOfConstraint.push(aux)
  setTimeout(() => {
    this.checkListofconstraint(this.ListOfConstraint[0])
  }, 1);
}

SearchFeature(text:string){
  let feature
  let father
  this.listFeatures=this.tree[0].ListOfFeatures()
  this.listFeatures.forEach(element => {
    if(element.name==text){
      feature=element
    }
  });
  setTimeout(() => {
    father=this.GetFather(feature,this.tree)
    if(father!=undefined){
    this.OpenToSearch(father)
    let ft = new FeatureTree()
    setTimeout(() => {
    ft.ScrollIntoView(feature.name)  
    this._snackBar.openFromComponent(PizzaPartyAnnotatedComponent, {
      duration: 1500,
      horizontalPosition: 'center',
      verticalPosition: 'top',
      panelClass: ['trasnparent-snackbar']
    });
    }, 1);
    }
  }, 1);
}

OpenToSearch(node:FMTree){
  this.treeControl.expand(node)
  let father 
  father=this.GetFather(node,this.tree)
  if(father!=undefined){
    
    this.OpenToSearch(father)
  }
}

SelectChipRefactor(object:any,tipo:string){
  let name=""
  if(object[1]==undefined){
    refactor=object
  }
  else{
    refactor=object[0]
    name=object[1]
  }
  this.logselect=[]
  if(tipo == "all"){this.loglist.unshift(refactor.name+" was made for all instances")}
  if(tipo == "node"){this.loglist.unshift(refactor.name+" was made for node: "+name)}
  if(tipo == "cons"){this.loglist.unshift(refactor.name+" was made for a cross tree constraint")}
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
  if(this.consactual==undefined){this.consactual =new Const()}
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

