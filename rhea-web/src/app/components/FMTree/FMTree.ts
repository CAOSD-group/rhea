import { Component } from '@angular/core'
import { Refactoring } from '../refactor/refactoring';




let Newchildren:Array<FMTree>;
let aux :any=0 
let MyTree  :Array<FMTree> =[]
let nlist:Array<string> =[]
@Component({
    selector: 'FMTree',
    templateUrl: './FMTree.html',
})

 export class FMTree  {
    name:string ="";
    card_min?:number;
    card_max?:number;
    type:string ="";
    optional:boolean =false;
    abstract:boolean =false;
    attributes?:Array<any>
    children:Array<FMTree> =[];
    constructor() {}

    Delete(list:FMTree){
        if(list!=undefined){
        if(list.children!=undefined){
        list.children=list.children.filter(x=>x.name!=this.name)
        }}
        if(this.children!=undefined){
            this.children.forEach(element => {
                aux=nlist.indexOf(element.name)
                nlist.splice(aux,1)
            });
        }
        this.name=""
        this.abstract=false;
        this.optional=false;
        this.type="";
        this.attributes=[]
        this.children=[];
        this.card_max=-1;
        this.card_min=-1;
        return nlist
    }

    DeleteList(){nlist.splice(0,nlist.length)}
    ListOfNames(){return nlist}
    ListOfNamesModified(newname:string,oldname:string){
        aux=nlist.indexOf(oldname)
        if(newname==""){nlist.splice(aux,1)}
        else{
        nlist[aux]=newname}
        return nlist}
    ExpandList(name:string){
        nlist.push(name)
        return nlist
    }

    CreateNewFMTree(value: any){            
        aux=new FMTree()
        aux.name=value.name;
        aux.abstract=value.abstract;
        aux.optional=value.optional;
        aux.type=value.type;
        if(value.card_max!=undefined){aux.card_max=value.card_max}
        if(value.card_min!=undefined){aux.card_min=value.card_min}
        if(value.attributes!=undefined &&value.attributes.length>0){aux.attributes=value.attributes}
        aux.children=[]
        if(value.children!=undefined ){
        Newchildren=value.children}
        if(value.children==undefined || value.children.length==0){
        Newchildren=[] 
        nlist.push(value.name)}
        MyTree[MyTree.length]=aux
        if(value.children!=undefined){
        if(value.children.length>0){
            aux=0
            value.children.forEach(element => {
                this.CreateNewFMTree(element);
            });
        }}
        return MyTree
    }


    IncorporateChildren(value: any ,father?:any, control?:boolean){ 
        if(value.children!=undefined){  
        value.children.forEach(element => {
            if(control==undefined){
                MyTree.forEach(rama=> {
                if(rama.name==value.name){
                    this.CreateNewChildren(element)
                    rama.children.push(aux)
                    this.IncorporateChildren(element,rama,true)
                } })}
            if(control){
                father.children.forEach(rama=> {
                    if(rama.name==value.name){
                        this.CreateNewChildren(element)
                        rama.children.push(aux)
                        this.IncorporateChildren(element,rama,true)
                    } 
                    }) 
            }
        });}
        return MyTree[0]
    }



    CleanFMTree(list?:Array<FMTree>){
        
        if(list==undefined){list=MyTree}
        list=list.filter(x=> x instanceof FMTree)
        list.forEach(element => {
            if(element.children!=undefined){
                element.children=this.CleanFMTree(element.children)}
        });
        return list
    }
    AvoidDuplicates(duplicated:string,list?:Array<FMTree>){
        if(list==undefined){
            aux=false
            list=MyTree
        }
        list.forEach(element => {
            if(element.name==duplicated){aux=true}
            else{
            if(element.children!=undefined){
            this.AvoidDuplicates(duplicated,element.children)}}
        });
        return aux
    }
   
  
    CreateNewChildren(value:any){  
        let children
        children=new FMTree()
        children.name=value.name;
        children.abstract=value.abstract;
        children.optional=value.optional;
        if(value.card_max!=undefined){children.card_max=value.card_max}
        if(value.card_min!=undefined){children.card_min=value.card_min}
        if(value.attributes!=undefined && value.attributes.length>0){children.attributes=value.attributes}
        children.type=value.type;
        children.children=[]
        aux=children
    }
    CreateDefault(name:string){  
        aux=new FMTree()
        aux.name=name
        aux.abstract=false;
        aux.optional=true
        aux.type="FEATURE"
        aux.children=[]
        return aux
    }
}