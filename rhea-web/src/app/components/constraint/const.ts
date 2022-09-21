import { Component } from '@angular/core'
import { Refactoring } from '../refactor/refactoring'



let aux :any 
let aux2:any
let aux3:any
let aux4:any

let constraintTree :Array<Const> =[]
let constraintText :Array<any> =[]
let constraintName :Array<any> =[]
let constraintRefactoring :Array<Refactoring> =[]
let refac=new Refactoring()

@Component({
    selector: 'const',
    templateUrl: './const.html',
})

 export class Const  {
    type:string=""
    operands:Array<any>=[];
    constructor() {}
  


    CreateConstraint(list2:any){
        constraintTree=[]
        constraintText=[]
        constraintName=[]
        constraintRefactoring=[]
        for( const[key2] of Object.entries(list2)){
            aux2=this.CreateNewConstraint(list2[key2].ast)
            constraintTree.push(list2[key2].ast)
            constraintText.push(list2[key2].expr)
            constraintName.push(list2[key2].name)
            if(list2[key2].refactoring!=undefined){
            constraintRefactoring.push(refac.create(list2[key2].refactoring)||undefined)}
            else{
                constraintRefactoring.push(list2[key2].refactoring)||undefined
            }
            
        }
        return [constraintTree,constraintText,constraintName,constraintRefactoring]
    }


    CreateNewConstraint(value:any){
        if(value.type!=undefined || value.type!=""){
        aux=new Const()
        aux.type=value.type
        aux.operands=value.operands
        }
        else{aux=value}
        return aux
    }
    TransformToCons(list:Array<any>){
        if(list!=undefined && list.length>0 && list!= null){
            list.forEach(element => {
                this.CreateNewConstraint(element)
                list.push(aux)
                if(element.operands!=undefined && element.operands.length>0 && element.operands!= null){
                    this.TransformToCons(element.operands)
                }
            });
        }
        list.splice(0,list.length/2)
        return list
    }
    checkName(list:Array<any>,newname:string,oldname:string){
        list.forEach(element => {
            if(element.type==oldname){element.type=newname}
            if(element.operands!=null){if (element.operands.length>0){
                element.checkName(element.operands,newname,oldname)
            }}
        });
    }


    createListForTree(list:Array<any>){
        list.forEach(element => {
            if(element.type=='FeatureTerm'){
            element.type=element.operands[0]
            element.operands=null
            }
            else{this.createListForTree(element.operands)}
        });
        return list
    }

    createListForFile(list:Array<any>,values:Array<string>){
        if(list!=undefined){
        list.forEach(element => {
            if(values.indexOf(element.type)==-1){
            element.operands=[]
            element.operands.push(element.type)
            element.type='FeatureTerm'
            }
            else{this.createListForFile(element.operands,values)}
        });}
        else {list=[new Const]}
        return list
    }

    ListOfNewConstraint(list:Array<any>){
        aux=0
        aux2=0
        aux3=true
        aux4=0
        
        while(aux<list.length){
            if(list[aux].operands.length==1){ 
                list[aux].operands.push(list[aux+1]);
                list[aux].operands.splice(0,1);
                aux++}
            if(list[aux].operands.length>=2){
                list[aux].operands.push(list[aux+1]);
                aux4=aux+1
                aux2=aux+1
                while(aux3){
                    aux4=aux4+list[aux2].operands.length
                    aux2++
                    if(aux2>aux4){
                        aux3=false
                    }
                }
                aux3=true
                list[aux].operands.push(list[aux2])
                list[aux].operands.splice(0,2);
                aux++}

                if(list[aux].operands.length!=undefined && list[aux].operands.length==0){
                    aux++
                }
        }
        return list[0]
    }
  
        
   
}

