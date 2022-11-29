import { Component } from '@angular/core'




let aux :any=0 
let MyTree :Array<FMTree> =[]
let nlist:Array<string> =[]
let listopen:Array<FMTree> =[]
@Component({
    selector: 'FMTree',
    templateUrl: './FMTree.html',
})

 export class FMTree  {
    margin:number=0
    symbol:string=""
    symbol2:string=""
    name?:string
    abstract?:boolean ;
    optional?:boolean ;
    attributes?:Array<any>
    relations?:Array<FMTree> 
    type?:string
    card_max?:number
    card_min?:number
    children?:Array<FMTree>
    constructor() {}

    Delete(list:FMTree){
        if(this.children!=undefined){
            if(this.children.length>0){
                this.children.forEach(element => {
                    element.Delete(this)
                    console.log("1")
                });
            }
        }
        if(this.name!=undefined){
        aux=nlist.indexOf(this.name)
        nlist.splice(aux,1)}
        list.children=list.children?.filter(x=> x!=this)
        this.margin=-1
        this.name=""
        this.abstract=false;
        this.attributes=[]
        this.relations=[];
        this.type=""
        this.card_max=-1
        this.card_min=-1
        this.children=[];
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
        let actualtree=new FMTree()
        actualtree.name=value.name;
        actualtree.abstract=value.abstract;
        if(value.attributes!=undefined &&value.attributes.length>0){actualtree.attributes=value.attributes}
        actualtree.children=[]
        nlist.push(value.name)
        if(value.relations!=undefined){
        if(value.relations.length>0){
            aux=0
            value.relations.forEach(element => {
                if(actualtree.children!=undefined){
                actualtree.children.push(this.CreateRelation(element))}
            });
        }}
        return actualtree
    }

    CreateRelation(a:any){
        let actualRelation=new FMTree()
        actualRelation.type=a.type;
        actualRelation.card_max=a.card_max;
        actualRelation.card_min=a.card_min;
        actualRelation.children=[]
        if(a.children.length>0){
            a.children.forEach(feature=> {
                if(actualRelation.children!=undefined){
                actualRelation.children.push(this.CreateNewFMTree(feature))}
            });
        }
        return actualRelation
    }

    GiveValues(node:FMTree){
        this.GiveMargin(node,node.margin) 
        this.GiveSymbols(node,-1)
        node.symbol="../assets/img/featuretree.ico";
        listopen.push(node)
        return listopen
    }
    
    GiveMargin(node:FMTree, current:number){
        node.margin=current
        if(node.type=="MANDATORY" || node.type=="OPTIONAL"){
            node.margin=current-32.5
            listopen.push(node)
        }
        if(node.children!=undefined){
            if(node.children.length>0){
                node.children.forEach(element => {
                  this.GiveMargin(element,node.margin)  
                });
            }
        }
    }
    GiveSymbols(node:FMTree,cardmin:number){
        if(node.type!=undefined){
            if(node.type=="MUTEX"){
            node.symbol="../assets/img/mutex.gif"
            node.symbol2="<"+node.card_min+".."+node.card_max+">"}
            if(node.type=="OR"){
                node.symbol="../assets/img/or.gif"
                node.symbol2="<"+node.card_min+".."+node.card_max+">"}
            if(node.type=="XOR"){
                node.symbol="../assets/img/xor.gif"
                node.symbol2="<"+node.card_min+".."+node.card_max+">"}
            if(node.type=="CARDINALITY"){
                node.symbol="../assets/img/cardinality.gif"
                node.symbol2="<"+node.card_min+"..."+node.card_max+">"
            }
        }
        else{
            if(cardmin==1){node.symbol="../assets/img/mandatory.gif"}
            else{node.symbol="../assets/img/optional.gif"}
        }
        if(node.children!=undefined){
            if(node.children.length>0){
                node.children.forEach(element => {
                    if(node.type=="MANDATORY"){this.GiveSymbols(element,1)}
                    else{this.GiveSymbols(element,0)}
                });
            }
        }
    }


    Relations(object:FMTree){
        if(object.type==undefined){
            object.relations=object.children
            object.children=undefined
            if(object.relations!=undefined){
            object.relations.forEach(element => {
                element=this.Relations(element)
            });}
        }
        else{
            if(object.children!=undefined){
                object.children.forEach(element => {
                    element=this.Relations(element)
                });}

        }
        return object
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
}