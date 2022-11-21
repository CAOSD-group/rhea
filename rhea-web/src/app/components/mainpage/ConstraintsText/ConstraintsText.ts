import {Component,Input,Output,EventEmitter} from '@angular/core';
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

    @Input() visible_Constraint_list:boolean =true;
    @Input() show_refacts_cons_only:boolean =false;
    @Input() listnamesconstraints:Array<string>=[] 
    @Input() jsonconstraintTexto:Array<string>=[]
    @Input() cons:Array<Const>=[]
    @Input() constraindataSource = new MatTreeNestedDataSource<Const>();
    @Input() ListOfRefactors:Array<Refactoring>=[]
    @Input() consactual=new Const
    @Input() jsonconstraintextshort:Array<string>=[]

    @Output() newItemEventreturnValues = new EventEmitter<string>();
    @Output() newItemEventposition = new EventEmitter<number>();
    @Output() newItemEventrefactor = new EventEmitter<Refactoring>();
    

    position=0
    npos=0
    page=0
    range=10

    ConstraintListautocomplete=""
    ncons=""
    

    
    


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
        this.page=0
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

    onSelectionChanged(event){
      this.page=event.pageIndex
      this.range=event.pageSize
     }

     SelectedChange(v){
      aux=0
      while (aux<this.jsonconstraintTexto.length) {
        if(this.jsonconstraintTexto[aux]==v ){this.position=aux}
        aux++
      }
      this.ncons=v
      
      if(v==""){
        this.position=-1
      }
      this.npos=this.position
      this.consactual=this.cons[this.position]
      console.log(this.consactual)
      this.newItemEventposition.emit(this.position);
      this.constraindataSource.data=this.cons.filter(x=>this.cons.indexOf(x)==this.position)
    }

    listOfContraint(text:string){
      if(text.length<100){
        return text
      }
      else{
        return text.slice(0,100)+"..."
      }
    }

    RefactorvisibleCons(ref:Refactoring){
      if(this.consactual!=undefined){
      if(ref.instances.includes(this.listnamesconstraints[this.npos])){return false}
      else{return true}}
      else{return true}
    }

    SelectChipRefactor(ref:Refactoring){
      this.newItemEventrefactor.emit(ref);
    }
}