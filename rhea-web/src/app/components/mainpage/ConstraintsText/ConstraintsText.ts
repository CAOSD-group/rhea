import {Component} from '@angular/core';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { Refactoring } from '../../refactor/refactoring';
import { Const } from '../../constraint/const';


  let aux :any

@Component({

  selector: 'ConstraintsText',
    templateUrl: './ConstraintsText.html',
    styleUrls: ['../../../app.component.css' ]
  })

  export class ConstraintsText {

    visible_Constraint_list=true
    show_refacts_cons_only=true

    position=0
    npos=0
    page=0
    range=0

    ConstraintListautocomplete=""
    ncons=""
    jsonconstraintTexto:Array<string>=[]
    jsonconstraintextshort:Array<string>=[]
    listnamesconstraints:Array<string>=[]

    consactual=new Const
    cons:Array<Const>=[]
    constraindataSource = new MatTreeNestedDataSource<Const>();
    
    ListOfRefactors:Array<Refactoring>=[]

    ShowPages(){
      let values
    values=this.jsonconstraintextshort.slice(this.page*this.range,(this.page+1)*this.range)
    return [values,this.jsonconstraintextshort.length]
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

    HiddenRefacCons(text:string){
      let hiddensymbol=false
      let color=""
      let temporalposition
      let count=0
      while (count<this.jsonconstraintTexto.length) {
        if(this.jsonconstraintTexto[count]==text ){temporalposition=count}
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

    onSelectionChanged(event){
      this.page=event.pageIndex0
      this.range=event.pageSize
    }

    SelectedChange(select){
      aux=0
      while (aux<this.jsonconstraintTexto.length) {
        if(this.jsonconstraintTexto[aux]==select ){this.position=aux}
        aux++
      }
      this.ncons=select
      this.npos=this.position
      this.consactual=this.cons[this.position]
      console.log(this.consactual)
      this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
    }

    RefactorvisibleCons(refac:Refactoring){}

    SelectChipRefactor(text:Refactoring,type:string){}
}