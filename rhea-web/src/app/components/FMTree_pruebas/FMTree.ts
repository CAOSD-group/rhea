import { Component } from '@angular/core'




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
    card_min:number=0;
    card_max:number=0;
    type:string ="";
    optional:boolean =false;
    abstract:boolean =false;
    children:Array<FMTree> =[];
    constructor() {}

    Delete(list:FMTree){
        if(list!=undefined){
        if(list.children!=undefined){
        list.children=list.children.filter(x=>x.name!=this.name)}}
        if(this.children!=undefined){
            this.children.forEach(element => {
                element.Delete
            });
        }
        this.name=""
        this.abstract=false;
        this.optional=false;
        this.type="";
        this.children=[];
        this.card_max=-1;
        this.card_min=-1;
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

    CrearNewFMTree(value: any){            
        aux=new FMTree()
        aux.name=value.name;
        aux.abstract=value.abstract;
        aux.optional=value.optional;
        aux.type=value.type;
        aux.card_max=value.card_max
        aux.card_min=value.card_min
        aux.children=[]
        if(aux.card_min==undefined){aux.card_min=0}
        if(aux.card_max==undefined){aux.card_max=0}
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
                this.CrearNewFMTree(element);
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
        aux=new FMTree()
        aux.name=value.name;
        aux.abstract=value.abstract;
        aux.optional=value.optional;
        aux.card_max=value.card_max;
        aux.card_min=value.card_min 
        if(aux.card_min==undefined){aux.card_min=0}
        if(aux.card_max==undefined){aux.card_max=0}
        aux.type=value.type;
        aux.children=[]
        return aux
    }
    CreateDefault(name:string){  
        aux=new FMTree()
        aux.name=name
        aux.card_max=0;
        aux.card_min=0;
        aux.abstract=false;
        aux.optional=true
        aux.type="FEATURE"
        aux.children=[]
        return aux
    }
}