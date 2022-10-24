import {Component,Input,Output,EventEmitter} from '@angular/core';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';

import { Const } from '../../constraint/const';


let aux:any

@Component({

  selector: 'ConstraintsTree',
    templateUrl: './ConstraintsTree.html',
    styleUrls: ['../../../app.component.css' ]
  })
  
  export class ConstraintsTree {
    @Input() visible_Constraint_list=true
    @Input() ListOfConstraint:Array<Const>=[]
    @Input() position=0
    @Input() featureautocomplete=""
    @Input() namesFeatures:Array<string>=[]
    @Input() listnamesconstraints:Array<string>=[]
    @Input() npos=0
    @Input() ncons=""
    @Input() jsonconstraintTexto:Array<string>=[]
    @Input() constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
    @Input() constraindataSource = new MatTreeNestedDataSource<Const>();
    @Input() consactual=new Const
    @Input() consactualfather=new Const
    @Input() cons:Array<Const>=[]
    @Output() newItemEventupdatecons = new EventEmitter<Const>();
    
    typesofcons:Array<string>=['NOT','OR','AND','IMPLIES','XOR','REQUIRES','EXCLUDES','EQUIVALENCE']

    constrainthasChild2 = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
    hasChild2 = (_: number, node: any) => !!node.children && node.children.length >= 0;

    treeConsHideen2(node:any){
      if(node.operands==null){return true}
      else{return false }
    }
    SelectCons2(object:any){
      this.GetFatherCons2(object)
      if(this.cons.indexOf(object)!=-1){this.position=this.cons.indexOf(object)}
      this.consactual=object
      this.ncons=this.jsonconstraintTexto[this.position]
      this.npos=this.position
      this.newItemEventupdatecons.emit(this.consactual);
    }
    GetFatherCons2(object:any,list?:Array<any>,cactualfather?:any){
      if(list==null){list=this.cons}
      if(list.filter(x=> x==object)[0]==undefined){
        list.forEach(element => {
          if(element.operands){
          if(element.operands.length>0){
            this.GetFatherCons2(object,element.operands,element)
          }}
        });
      }else{
        this.consactualfather=cactualfather
        this.position=this.cons.indexOf(this.consactualfather)
      }
    }
    AutocompleteFeatureTermChip2(name:string){
      let showfeature=false
      if(this.featureautocomplete!="" && !(name.toLowerCase().indexOf(this.featureautocomplete.toLowerCase())!=-1)){showfeature=true}
      return showfeature
    } 

    Writelist2(){
      let textlista=""
      this.ListOfConstraint.forEach(element => {
        textlista=textlista+element.type+" "
      })
      return textlista
    }
    SelectChipFeature2(text:string){
      aux=new Const()
      aux.type=text
      aux.operands=[]
      this.ListOfConstraint.push(aux)
      console.log(this.ListOfConstraint)
    }

    SelectChipLogic2(text:string){
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
    DeleteList2(){
      console.log(this.listnamesconstraints)
      this.ListOfConstraint=[]
    }
    CreateConsBrother2(){
      if(this.consactualfather!=undefined && this.consactualfather.type!=""){
      if(this.ListOfConstraint!=undefined && this.ListOfConstraint.length!=0){
        this.CreateListCons2()
        if(this.consactualfather.type.toLowerCase().startsWith("feature")){}
        else{
        if(this.consactualfather.type.toLowerCase().startsWith("not") && this.consactualfather.operands.length==1){}
        else{
        if(this.consactualfather.operands.length==2){}
        else{this.consactualfather.operands.push(this.ListOfConstraint[0])
        }}}
      }}
      else{
      this.CreateConsList2(); 
      alert("there was no father so a new one was created")
    }
      this.ListOfConstraint=[]
      this.ReloadFMTree2()
    }
    CreateListCons2(){
      if(this.ListOfConstraint.length==2){
        this.ListOfConstraint[0].operands.push(this.ListOfConstraint[1]);
      }
      if(this.ListOfConstraint.length>2){
        
        this.ListOfConstraint[0]=this.consactual.ListOfNewConstraint(this.ListOfConstraint)
      }
      return this.ListOfConstraint[0]
    }
    ReloadFMTree2(){
      this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
      if(this.consactual==undefined){ this.consactual=new Const()}
    }
    CreateConsList2(){
      if(this.ListOfConstraint!=undefined && this.ListOfConstraint.length!=0){
        this.CreateListCons2()
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
      this.ReloadFMTree2()
    }
    CreateConsSon2(){
      if(this.ListOfConstraint!=undefined && this.ListOfConstraint.length!=0){this.CreateListCons2()}
      if(this.consactual!=undefined){
      if(this.consactual.operands!=null||this.consactual.operands!=undefined){
      if(this.consactual.operands.length!=0 ){
        if(this.consactual.operands[0].type==""){this.consactual.operands.slice(0,1)}}
    
      if(this.typesofcons.indexOf(this.consactual.type)==-1){}
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
      this.ReloadFMTree2()
    }
    ModifyCons2(){
      if(this.ListOfConstraint.length!=0&&this.ListOfConstraint!=undefined){
        this.CreateListCons2()
  
      if(this.consactualfather==undefined ||  this.consactualfather.type==""){
        this.cons[this.position]=this.ListOfConstraint[0]
      }
  
      if(this.consactualfather!=undefined  ){
        aux=0
        while(aux<this.consactualfather.operands.length){
          if(this.consactualfather.operands[aux]==this.consactual){
            aux=aux
            aux++
          }
          else{aux++}
        }
        this.consactualfather.operands[aux]=this.ListOfConstraint[0]
      }
      this.jsonconstraintTexto[this.position]="New value at " +(this.position+1)+"º"
      }
      this.ReloadFMTree2()
      this.ListOfConstraint=[]
    }
    DeleteCons2(){
      if( this.consactual.type=='' && this.position!= undefined && this.position!=-1){
        this.cons.splice(this.position,1)
        this.DeleteConsText2()
        this.position=-1
      }
      if(this.consactual!=undefined){
        if(this.consactualfather!=undefined &&this.consactualfather.type!=""){
          aux=0
        while(aux<this.consactualfather.operands.length){
          if(this.consactualfather.operands[aux]==this.consactual){
            aux=aux
            aux++
          }
          else{aux++}
        }
          this.consactualfather.operands.splice(aux,1)
          this.jsonconstraintTexto[this.position]="New value at " +(this.position+1)+"º"
        }
        else{
          if(this.position!=-1){
          this.cons.splice(this.position,1)
          this.DeleteConsText2()
          this.position=-1}
        }
      }
      if(this.cons.length==0){this.cons.push(new Const)}
      this.SelectedChange2(this.ncons)
      this.ReloadFMTree2()
    }
    SelectedChange2(v){
      aux=0
      while (aux<this.jsonconstraintTexto.length) {
        if(this.jsonconstraintTexto[aux]==v ){this.position=aux}
        aux++
      }
      this.ncons=v
      this.npos=this.position
      this.consactual=this.cons[this.position]
      console.log(this.consactual)
      this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
    }
    DeleteConsText2(){
      this.jsonconstraintTexto[this.position]=""
      this.jsonconstraintTexto=this.jsonconstraintTexto.filter(x=>x!="")
      this.listnamesconstraints[this.position]=""
      this.listnamesconstraints=this.listnamesconstraints.filter(x=>x!="")
      this.ReloadFMTree2()
    }

}