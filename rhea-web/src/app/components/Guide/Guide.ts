import {Component} from '@angular/core';



@Component({

  selector: 'guide',
    templateUrl: './Guide.html',
    styleUrls: ['../../app.component.css' ]
  })
  export class Guide {

    ScrollToElement(element: HTMLElement){
      element.scrollIntoView({block: "start", behavior: "smooth"})
    }
  }