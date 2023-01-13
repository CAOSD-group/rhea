import { Component, ViewChild ,Input,Output,EventEmitter} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import {SelectionModel} from '@angular/cdk/collections';
import {HttpClient} from '@angular/common/http';


let aux:any
@Component({

  selector: 'Repository',
    templateUrl: './Repository.html',
    styleUrls: ['../../app.component.css' ]
  })
  export class Repository {
  urlcur="https://rhea.caosd.lcc.uma.es/getCur" 
  urlinsertcur="https://rhea.caosd.lcc.uma.es/insertIntoRepository" 
  //urlcur="http://127.0.0.1:5000/getCur" 
  //urlinsertcur="http://127.0.0.1:5000/insertIntoRepository" 

  selection = new SelectionModel<Data>(true, []);
  myfile:any
  dataSourcerepo:MatTableDataSource<Data>=new MatTableDataSource<Data>


  
  @ViewChild(MatSort, {static: true}) sort!: MatSort;
  @Output() newItemEventopendModal = new EventEmitter<Data>(); 
  @Output() newItemEventreadThis = new EventEmitter<any>(); 
  @Input() myArticle=new Data('','','','',0,'',"",'',0,0,'','');
  data  
  @Input() bool
  bool2=true
  columns: string[] = [       
    "Name",
    "Author",
    "Owner",
    "Ref",
    "Year",
    "Domain",
    "Version",
    "Languagelevel",
    "nFeatures",
    "nConfigs",
    "Rating",
    "Format",
    "Select"
  ]


  constructor(private http?: HttpClient ) { }  
  
    ngOnInit() {
      this.getCur()
    }

    getCur(){
      this.data=[]
      this.dataSourcerepo = new MatTableDataSource<Data>(this.data);
      if(this.http!=undefined){
      this.http.get(this.urlcur).subscribe(resultado => {
        aux=resultado
        console.log(aux)
        aux.forEach(element => {
          let doc=new Data(element[0],element[1],element[2],element[3],element[4],element[5],element[6],element[7],element[8],element[9],element[10],element[11])
          this.data.push(doc)
        });
        }
      )}
    }

    Button(){
      this.dataSourcerepo.data=this.data
    }

    Insertrepository(){
      const formData: FormData = new FormData();
      formData.append('file',"hola");
      if(this.http!=undefined){
      this.http.post(this.urlinsertcur,formData,{withCredentials:true,responseType:'text'}).subscribe(resultado => {  
          console.log(resultado)
          }
        )}
    }

    filter(event: Event) {
      const filtro = (event.target as HTMLInputElement).value;
      this.dataSourcerepo.filter = filtro.trim().toLowerCase();
    } 
    modal(Article:Data){
      this.newItemEventopendModal.emit(Article);
      console.log(Article)
    }
    web(Article:Data){
      if(Article.Ref!=undefined){
      window.open(Article.Ref);}
    }

    toggleAllRows() {
      if (this.isAllSelected()) {
        this.selection.clear();
        return;
      }
      this.dataSourcerepo.data.forEach(element => {
        if(this.dataSourcerepo.filteredData.indexOf(element)!=-1){
          this.selection.select(element)
        }
      });
    }

    isAllSelected() {
      if(this.dataSourcerepo.filteredData.length<=this.selection.selected.length){
        return true
      }
      else{
        return false
      }
    }  
    
  changeListener($event){
      if($event.target.files[0].name!=undefined){
          this.myfile=$event.target
        }
  }
  readThis(){
    if(this.myfile!=undefined && this.myfile!=null){
    this.newItemEventreadThis.emit(this.myfile);
    }
  }

  }
  
  export class Data {
    constructor(
      public Name?: string,
      public Author?: string,
      public Owner?: string,
      public Ref?: string,
      public Year?: number,
      public Domain?: string,
      public Version?: string,
      public Language_level?: string,
      public nFeatures?: number,
      public nConfigs?: number,
      public Rating?: string,
      public Format?: string,
  
      ) {}
  }