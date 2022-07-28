import { Component, Type } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import{ArticulosService} from'./components/miarbol/miservidor';
import { empty, Observable } from 'rxjs';
import {MatSelectModule} from '@angular/material/select';
import {FormControl} from '@angular/forms';
import { ContentObserver } from '@angular/cdk/observers';
import{Rama} from 'src/app/components/miarbol/miarbol'
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { FMEditor } from './components/fm-editor/fm-editor.component';
import { Arbol } from './components/arbol_pruebas/arbol';
import {FlatTreeControl} from '@angular/cdk/tree';
import {MatTreeFlatDataSource, MatTreeFlattener} from '@angular/material/tree';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  url="http://172.16.51.94:5000"  //servidor 
  documentos:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl'];
 
  
  articulos: any;        //atributo donde guardo las respuestas
  item:string ='';       //variable para el titulo 
  showFiller = false;   //controla si se ve mas contenido
  istoggle=false;       // controla si el menu esta abierto o no
  title:string ='rhea-web' // evita un error en app.component.spec.ts


  tree:Array<Arbol> =[new Arbol()]  // el arbol de datos 
  declare json_nombre:any;    //guardo los valores de las features
  declare json_const:any;     //guardo los valores de las constraints
  treeControl = new NestedTreeControl<Arbol>(node => node.children);
  dataSource = new MatTreeNestedDataSource<Arbol>();

  
constructor(private http: HttpClient) { }  
ngOnInit() {}



returnValues(texto?:string){
  if(texto==""){texto="te he escuchado"}
  this.http.post(this.url,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.item=texto||"";
    this.articulos=JSON.parse(this.articulos)
    this.json_nombre=this.articulos.features,
    this.json_const=this.articulos.constraints
    this.crearArbol()
  })
}
getArchivo(texto?:string){
  this.http.post(this.url,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.item=texto||"";
    this.articulos=JSON.parse(this.articulos)
    this.json_nombre=this.articulos.features,
    this.json_const=this.articulos.constraints
    this.crearArbol()
  })
}

hasChild = (_: number, node: any) => !!node.children && node.children.length >= 0;



crearArbol(){
  this.tree.splice(0,this.tree.length)
  this.tree=[new Arbol()]
  this.tree=this.tree[0].CrearArbol(this.json_nombre)
  this.tree[0]=this.tree[0].meterHijos(this.json_nombre);
  this.tree.splice(1,this.tree.length)
  this.dataSource.data=this.tree
  console.log(this.tree)
}

borrarArbol(){
  this.dataSource.data=[]
}

recargarArbol(){
  this.dataSource.data=this.tree
}

}
 