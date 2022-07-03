import { Component } from '@angular/core';
import {NestedTreeControl} from '@angular/cdk/tree';
import {MatTreeNestedDataSource} from '@angular/material/tree';

interface FeatureNode {
    name: string;
    children?: FeatureNode[];
}

const TREE_DATA: FeatureNode[] = [
    {
        "name": "truck",
        "children": [
          {
            "name": "weight",
            "children": [
              {
                "name": "lightweight",
                "children": [
                  {
                    "name": "12tons"
                  },
                  {
                    "name": "18tons"
                  }
                ]
              },
              {
                "name": "heavyweight",
                "children": [
                  {
                    "name": "23tons"
                  },
                  {
                    "name": "40tons"
                  }
                ]
              }
            ]
          },
          {
            "name": "type",
            "children": [
              {
                "name": "semitrailer"
              },
              {
                "name": "tank"
              },
              {
                "name": "flatbed",
                "children": [
                  {
                    "name": "dumper"
                  }
                ]
              }
            ]
          },
          {
            "name": "engine",
            "children": [
              {
                "name": "160kw"
              },
              {
                "name": "280kw"
              },
              {
                "name": "400kw"
              }
            ]
          },
          {
            "name": "cabin",
            "children": [
              {
                "name": "highroof"
              },
              {
                "name": "sleepercabin",
                "children": [
                  {
                    "name": "1bed"
                  },
                  {
                    "name": "2beds"
                  }
                ]
              }
            ]
          },
          {
            "name": "axles",
            "children": [
              {
                "name": "count",
                "children": [
                  {
                    "name": "2axles"
                  },
                  {
                    "name": "multiplerearaxles",
                    "children": [
                      {
                        "name": "3axles"
                      },
                      {
                        "name": "4axles"
                      }
                    ]
                  }
                ]
              },
              {
                "name": "additionalsteeringaxle"
              },
              {
                "name": "drivetrain",
                "children": [
                  {
                    "name": "1drivenaxle"
                  },
                  {
                    "name": "2drivenaxles"
                  },
                  {
                    "name": "3drivenaxles"
                  }
                ]
              }
            ]
          }
        ]
      },
  ];


@Component({
    selector: 'fm-editor',
    templateUrl: './fm-editor.component.html',
    styleUrls: ['./fm-editor.component.css'],
})
export class FMEditor {
    treeControl = new NestedTreeControl<FeatureNode>(node => node.children);
    dataSource = new MatTreeNestedDataSource<FeatureNode>();

    constructor() {
        this.dataSource.data = TREE_DATA;
    }

    hasChild = (_: number, node: FeatureNode) => !!node.children && node.children.length > 0;
}
