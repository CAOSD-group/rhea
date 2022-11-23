import {Component,Input,Output,EventEmitter} from '@angular/core';


@Component({

  selector: 'card4',
    templateUrl: './card4.html',
    styleUrls: ['../../../app.component.css']
  })
  
  export class card4 {

    @Input() loglist:string[] =[]
    selectfirst(a:any){
      if(this.loglist.indexOf(a)==0){
      return "rgba(85, 85, 85, 0.295)"}
      else{
        return "rgba(0, 0, 0, 0)"
      }
    }

}