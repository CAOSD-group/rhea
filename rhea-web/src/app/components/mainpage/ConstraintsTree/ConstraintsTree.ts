import {Component} from '@angular/core';
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
    visible_Constraint_list=true

    menuoptionsconstraintree=0
    position=0
    npos=0

    ncons=""
    jsonconstraintTexto:Array<string>=[]

    constraintreeControl = new NestedTreeControl<Const>(constrainnode => constrainnode.operands);
    constraindataSource = new MatTreeNestedDataSource<Const>();

    consactual=new Const
    consactualfather=new Const
    cons:Array<Const>=[]


    constrainthasChild = (_: number, constrainnode: any) => !!constrainnode.children && constrainnode.children.length >= 0;
    hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;

    treeConsHideen(node:any){
      if(node.operands==null){return true}
      else{return false }
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

}