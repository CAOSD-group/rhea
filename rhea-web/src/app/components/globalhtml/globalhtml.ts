import {Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { AppComponent } from 'src/app/app.component';

@Component({

  selector: 'globalhtml',
    templateUrl: './globalhtml.html',
    styleUrls: ['../../app.component.css' ]
  })
  
  export class globalhtml {
    bdrawer=true
    
    windowFM_Editor=false
    windowAbout=true
    window3=true



    showFM_Editor(){
        this.windowFM_Editor=false
        this.windowAbout=true
        this.window3=true
      }
    showAbout(){
        this.windowFM_Editor=true
        this.windowAbout=false
        this.window3=true
      }
      showWindow3(){
        this.windowFM_Editor=true
        this.windowAbout=true
        this.window3=false
      }
  }