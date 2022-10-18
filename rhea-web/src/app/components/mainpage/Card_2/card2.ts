import {Component} from '@angular/core';


@Component({

  selector: 'card2',
    templateUrl: './card2.html',
    styleUrls: ['./card2.css' ]
  })
  
  export class card2 {
    item:string ='Pizzas.uvl';
    documents:string[]= ['GPL.xml', 'JHipster.uvl', 'MobileMedia.xml', 'Pizzas.uvl', 'TankWar.xml', 'Truck.uvl','WeaFQAs.uvl','Automotive2_1-basic.uvl'];

    returnValues(text?:string){
        alert("no hago nada")
  }
}