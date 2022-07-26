import {Component} from '@angular/core';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';
import { waitForAsync } from '@angular/core/testing';

let auxiliar: any
let auxiliar2: any

class FeatureNode {
    declare name: string;               // El nombre
    declare feature_type: string;       // El tipo de condiciones que tiene
    declare optional: boolean;          // Si el valor es opcional o no
    children?: FeatureNode[];   // Los datos que estan enlacados a este 
    constraints?: FeatureNode[];  // Las restricciones del modelo 
    algo?:String[]=["optional","mandatory","or","xor","mutex","card","null"];
    segundoalgo?:String[]=["abstract","concrete","null"];



    constructor(nombre:string){
        this.name=nombre;             
        this.feature_type= "";      
        this.optional=true; 
        this.children=[] ;
       
    }
}

var TREE_DATA: FeatureNode[] = [
    {
      "name": "Pizza",
      "feature_type" : "abstract",
      "optional": false,
      "children": [
          {
              "name": "Topping",
              "feature_type" : "or",
              "optional": false,
              "children": [
                  {
                      "name": "Salami",
                      "feature_type" : "concrete",
                      "optional": true,
                  },
                  {
                      "name": "Ham",
                      "feature_type" : "concrete",
                      "optional": true,
                  },
                  {
                      "name": "Mozzarella",
                      "feature_type" : "concrete",
                      "optional": true,
                  }
              ]
          },
          {
              "name": "Size",
              "feature_type" : "mandatory",
              "optional": false,
              "children": [
                  {
                      "name": "Normal",
                      "feature_type" : "concrete",
                      "optional": true,
                  },
                  {
                      "name": "Big",
                      "feature_type" : "concrete",
                      "optional": true,
                  }
              ]
          },
          {
              "name": "Dough",
              "feature_type" : "alternative",
              "optional": false,
              "children": [
                  {
                      "name": "Neapolitan",
                      "feature_type" : "concrete",
                      "optional": true,
                  },
                  {
                      "name": "Sicilian",
                      "feature_type" : "concrete",
                      "optional": true,
                  }
              ]
          },
          {
              "name": "CheesyCrust",
              "feature_type" : "optional",
              "optional": true,
          }
      ],
      "constraints": [{
              "name": "if CheesyCrust must Big",
              "feature_type" : "Constraint",
              "optional": false,}
      ],
    }
  ]
;


@Component({
    selector: 'fm-editor',
    templateUrl: './fm-editor.component.html',
    styleUrls: ['./fm-editor.component.css'],
})
export class FMEditor {
    treeControl = new NestedTreeControl<FeatureNode>(node => node.children);
    dataSource = new MatTreeNestedDataSource<FeatureNode>();
    checkededed = false;
    indeterminateeded = false;
    labelPositioneded: 'before' | 'after' = 'after';
    disablededed = false;

    constructor() {
        this.dataSource.data = TREE_DATA;
        auxiliar=TREE_DATA;
        auxiliar2=TREE_DATA;
        
    }
    nuevovalor2(nombre:string) {
        auxiliar2=auxiliar
        auxiliar= new FeatureNode(nombre)
        auxiliar2[0].children.push(auxiliar)
        console.log(auxiliar2)
        console.log(auxiliar2[0])
        console.log(auxiliar2[0].children)
    }

    hasChild = (_: number, node: FeatureNode) => !!node.children && node.children.length >= 0;
}
