import {Component} from '@angular/core';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';

import { FMTree } from '../../FMTree/FMTree';
import { Refactoring } from '../../refactor/refactoring';


let aux:any
var refactor:Refactoring =new Refactoring()

@Component({

  selector: 'FeatureTree',
    templateUrl: './FeatureTree.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class FeatureTree {
  my_session=0
  show_refacts_features_only=true
  treeControl = new NestedTreeControl<FMTree>(node => node.children);
  dataSource = new MatTreeNestedDataSource<FMTree>();

  name=""
  type=""
  optional=true
  abstract=true
  card_max=1
  card_min=0
  attributes:Array<any>=[];
  declare actualfather:FMTree 


  ListOfRefactors:Array<Refactoring>=[]
  declare actual:FMTree    
  tree:Array<FMTree> =[new FMTree()]  



  constrainthasChild = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
  hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;

  treeHideen(node:any){
    if(node.children.length==0){return true}
    else{return false }
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
  return [hiddensymbolfeature,color]
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

  select(node:any){
    this.actual=node
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

  SelectChipRefactor(ref:Refactoring,tipo:string){
    refactor=ref
    this.Refactor(tipo)
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

  RefactorvisibleFeature(ref:Refactoring){
    if(this.actual!=undefined){
      if(ref.instances.includes(this.actual.name)){return false}
      else{return true}}
      else{return true}
  }

  GetFather(nodechild:FMTree,list:any){
    list.forEach(element => {
      if(element==nodechild){aux=undefined}
      else{
        if(element.children.length>0){
          if(element.children.indexOf(nodechild)!=-1){
            aux=element
          }
          else{this.GetFather(nodechild,element.children)}
      }
    }
    });
  
return aux;
}

Refactor(typeref:string){
  alert("no hago nada")
}

}