import {Component} from '@angular/core';


@Component({

  selector: 'globalhtml',
    templateUrl: './globalhtml.html',
    styleUrls: ['./globalhtml.css' ]
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