import { Component } from '@angular/core'


let aux:any
let listlanguage:any
let listTools:Array<string>=[]
@Component({
    selector: 'Language',
    templateUrl: './Language.html',
})

 export class Language  {
    id=""
    name=""
    value=0
    refactorings:Array<string>=[]
    tools:Array<string>=[]
    

    constructor( nid?:String,nname?:String,nvalue?:Number,nrefactorings?:Array<string>,ntools?:Array<string>){
        if(nid!=undefined){this.id=nid.toString()}
        if(nname!=undefined){this.name=nname.toString()}
        if(nvalue!=undefined){this.value=Number(nvalue.toString())}
        if(nrefactorings!=undefined){this.refactorings=nrefactorings}
        if(ntools!=undefined){this.tools=ntools}
    }
    CreatLanguage(list:any){
        listlanguage=[]
        list.forEach(element => {
            try{
            aux=new Language(element.id,element.name,element.value,element.refactorings,element.tools)
            element.tools.forEach(element2 => {
                if(listTools.indexOf(element2)==-1){
                listTools.push(element2)}
            });
            }
            catch{}
            listlanguage.push(aux)
        });
        return listlanguage
    }
    CreatLanguage2(){
        return listTools
    }
 }