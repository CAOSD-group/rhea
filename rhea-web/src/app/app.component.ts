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
  rama:Rama = new Rama();    //para poder llamar metodos Rama
  children: Array<AppComponent> =[] ;
  treeControl = new NestedTreeControl<AppComponent>(node => node.children);
  dataSource = new MatTreeNestedDataSource<AppComponent>();

  
constructor(private http: HttpClient) { }  
ngOnInit() {this.getValues();}

getValues(){
  this.http.get(this.url,{responseType:'text'})   //direccion de donde saca los datos 
    .subscribe(resultado => {this.articulos = resultado});
    this.item=this.articulos;
}

returnValues(texto?:string){
  if(texto==""){texto="te he escuchado"}
  this.http.post(this.url,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.mijson=this.articulos
    console.log(this.articulos)
    this.item=texto||"";
    this.dataSource.data=[]
    this.dataSource.data=[this.articulos]})
}
getArchivo(texto?:string){
  this.http.post(this.url,texto,{responseType:'text'}).subscribe(resultado => {
    this.articulos = resultado;
    this.mijson=this.articulos
    console.log(this.mijson)
    this.item=texto||"";
    this.dataSource.data=[]
    this.dataSource.data=[this.articulos]})
   
}
getRama(){
  this.rama.crearRamaControlada(this.mijson)
  //this.rama.saveAsProject(this.mijson)
}
hasChild = (_: number, node: AppComponent) => !!node.children && node.children.length >= 0;
}