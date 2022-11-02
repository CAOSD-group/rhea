import { Component, ViewChild ,Input,Output,EventEmitter} from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort} from '@angular/material/sort';



@Component({

  selector: 'Repository',
    templateUrl: './Repository.html',
    styleUrls: ['../../app.component.css' ]
  })
  export class Repository {

  @Output() newItemEventopendModal = new EventEmitter<Data>(); 
  @Input() myArticle=new Data('','','',0,'',"",'',0,0,'','');
  columns: string[] = [       
    "Name",
    "Author",
    "Owner",
    "Ref",
    "Year",
    "Domain",
    "Version",
    "Language_level",
    "nFeatures",
    "nConfigs",
    "Rating",
    "Format",
  ]

  data: Data[] = [
  new Data('Pizzas','Horcas','Horcas',3322,'Food',"1.2",'professional',5,2,'easy','text',"https://www.uma.es/"),
  new Data('JHipster','Horcas','Acebal',1960,'party',"5.9.3",'numericalfm',10,8,'hard','party',"https://www.uma.es/"),
  new Data('AAAA','Acebal','Acebal',2002,'something',"Original",'radiofm',1,9,'easy','music'),
  
  ];

  dataSource:any; 
  
    @ViewChild(MatSort, {static: true}) sort!: MatSort;
  
    ngOnInit() {
      this.dataSource = new MatTableDataSource<Data>(this.data);
      this.dataSource.sort = this.sort;
    }
    filter(event: Event) {
      const filtro = (event.target as HTMLInputElement).value;
      this.dataSource.filter = filtro.trim().toLowerCase();
    } 
    modal(Article:Data){
      this.newItemEventopendModal.emit(Article);
      console.log(Article)
    }
    web(Article:Data){
      if(Article.Ref!=undefined){
      window.open(Article.Ref);}
    }
  }
  
  export class Data {
    constructor(
      public Name: string,
      public Author: string,
      public Owner: string,
      public Year: number,
      public Domain: string,
      public Version: string,
      public Language_level: string,
      public nFeatures: number,
      public nConfigs: number,
      public Rating: string,
      public Format: string,
      public Ref?: string,
      ) {}
  }