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


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  url="http://172.16.51.94:5000"  //servidor 
  articulos: any;        //atributo donde guardo las respuestas
  documentos:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl'];
  item:string ='';       //variable para el titulo 
  declare mijson:JSON    //variable que guarda el objeto tipo JSON 
  rama:Rama =new Rama();    //para poder llamar metodos Rama
  fmeditor:FMEditor =new FMEditor();
  children: Array<AppComponent> =[] ;
  treeControl = new NestedTreeControl<Arbol>(node => node.children);
  dataSource = new MatTreeNestedDataSource<Arbol>();
  showFiller = false;   //controla si se ve mas contenido
  istoggle=false;       // controla si el menu esta abierto o no
  title:string ='rhea-web' // evita un error en app.component.spec.ts
  declare json_nombre:any;
  declare json_const:any;
  tree:Array<Arbol> =[new Arbol()]


  
constructor(private http: HttpClient) { }  
ngOnInit() {}

/*getValues(){
  this.http.get(this.url,{responseType:'text'})   //direccion de donde saca los datos 
    .subscribe(resultado => {this.articulos = resultado});
    this.item=this.articulos;   
  }*/

returnValues(texto?:string){
  if(texto==""){texto="te he escuchado"}
  this.http.post(this.url,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.mijson=this.articulos
    this.item=texto||"";
    this.articulos=JSON.parse(this.articulos)
    this.actualizar_datos()})
}
getArchivo(texto?:string){
  this.http.post(this.url,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.mijson=this.articulos
    this.item=texto||"";
    this.articulos=JSON.parse(this.articulos)
    console.log(this.articulos)
    this.json_nombre=this.articulos.features,
    this.json_const=this.articulos.constraints,
    console.log(this.json_nombre)
    console.log(this.json_nombre.type)
    console.log(this.json_const)
    this.actualizar_datos() })
}

hasChild = (_: number, node: AppComponent) => !!node.children && node.children.length >= 0;

actualizar_datos(){ 
  this.dataSource.data=[]
  this.dataSource.data=[this.json_nombre]
  console.log(this.json_nombre)
}

crearArbol(){
  this.tree.splice(0,this.tree.length)
  this.tree=[new Arbol()]
  this.tree=this.tree[0].CrearArbol(this.json_nombre)
  this.tree=this.tree[0].organizarArbol(this.json_nombre,this.tree)
  console.log(this.tree)
  this.dataSource.data=[]
  this.dataSource.data=this.tree
}
borrarArbol(){
  this.dataSource.data=[]
}
}
 