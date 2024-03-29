import {Component,Input,Output,EventEmitter} from '@angular/core';

import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';

import { FMTree } from '../../FMTree/FMTree';
import { Refactoring } from '../../refactor/refactoring';


let aux:any

@Component({

  selector: 'FeatureTree',
    templateUrl: './FeatureTree.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class FeatureTree {
  
  node:FMTree=new FMTree()
  show_refacts_features_only=false 

  @Input() my_session=""
  @Input() name=""
  @Input() type=""
  @Input() optional=true
  @Input() abstract=true
  @Input() card_max=1
  @Input() card_min=0
  @Input() attributes:Array<any>=[];
  @Input() declare actualfather:FMTree 
  @Input() ListOfRefactors:Array<Refactoring>=[]
  @Input() declare actual:FMTree    
  @Input() tree:Array<FMTree> =[new FMTree()]  
  @Input() treeControl = new NestedTreeControl<FMTree>(node => node.children);
  @Input() dataSource = new MatTreeNestedDataSource<FMTree>();

  @Output() newItemEventlogRoot = new EventEmitter<string>();
  @Output() newItemEventactual = new EventEmitter<FMTree>();
  @Output() newItemEventrefactor = new EventEmitter<Array<any>>();
  @Output() newItemEventroot = new EventEmitter<FMTree>();
  @Output() newItemEventDelete = new EventEmitter<FMTree>();

  hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;

  treeHideen(node:any){
    if(node.children!=undefined){
    if(node.children.length==0){return true}
    else{return false}
    }
    else{return false }
  }


  HiddenRefacfeature(node:FMTree){
  let hiddensymbolfeature=false
  let color=""
  this.ListOfRefactors.forEach(element => {
    if(node.name!=undefined){
    if(element.instances.includes(node.name)){
      if(this.show_refacts_features_only){
      hiddensymbolfeature=true
      if(this.show_refacts_features_only){
        color='refactorColor'
      } 
    }
    }}
  });
  return [hiddensymbolfeature,color]
  }
  ToolTip(node?:FMTree){
    if(node==undefined){
      this.node=new FMTree()
    }
    else{
      this.node=node
    }
  }
  ToolTipText(node:FMTree){
    let bool=false
    let text=""
    if(this.node!=undefined){
      if(this.node==node){
        bool=true
        aux=this.GetFather(node,this.tree)
        if(aux==undefined){
          text="root"
        }
        else{
        if(aux.type!=undefined){
          text=aux.type
        }
        else{
          if(node.type!=undefined){
            text=node.type
          }
        }
      }
      }
    }
    return [bool,text]
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
    console.log(this.actual)
    this.newItemEventactual.emit(this.actual);
    return this.actual==this.tree[0]
  }

  SelectChipRefactor(ref:Refactoring){
    this.newItemEventrefactor.emit([ref,this.actual.name]);
  }

  ToolTipRefa(nodetooltiprefa:FMTree){
    let bool=false
    this.ListOfRefactors.forEach(element => {
      if(nodetooltiprefa.name!=undefined){
      if(element.instances.includes(nodetooltiprefa.name)){
      bool=true
      }}
    });
  return bool
  }

  RefactorvisibleFeature(ref:Refactoring){
    if(this.actual!=undefined){
      if(this.actual.name!=undefined){
      if(ref.instances.includes(this.actual.name)){return false}
    else return(true)}
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

RelationFeature(node:any){
    if(node.type=="MANDATORY" || node.type=="OPTIONAL" ){
      if(node.children!=undefined){
        this.treeControl.expand(node)}
    return true}
    else{return false }
}
CreateRoot(){
  let root =new FMTree()
  let relation =new FMTree()
  root.name="root"
  root.abstract=true
  root.children=[]
  root.children.push(relation)
  relation.type="MANDATORY"
  relation.card_max=1
  relation.card_min=1
  relation.children=[]
  relation.children.push(this.tree[0])
  this.tree[0]=root
  this.newItemEventlogRoot.emit("Created a root for all the tree");
  this.newItemEventroot.emit();
}

ScrollIntoView(elem:string) {
  let view
  if(document!=null){
    if(elem!=undefined && elem!= null){
      view=document.body.querySelector("#"+elem)
      if(view!=null){
        setTimeout(() => {
          view.scrollIntoView({block: "center", behavior: "auto"}) 
        }, 1);
      }}}
}
EmptyTree(){
  this.actual=this.tree[0]
  console.log(this.actual)
  if(this.actual!=this.tree[0]){ this.actual=this.tree[0];this.newItemEventDelete.emit()}
  if(this.actual==this.tree[0]){ this.newItemEventDelete.emit()}
}
Delete(){
  this.newItemEventDelete.emit()
}

}