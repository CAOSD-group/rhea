import {Component} from '@angular/core';


let aux:any

@Component({

  selector: 'card1',
    templateUrl: './card1.html',
    styleUrls: ['./card1.css' ]
  })
  
  export class card1 {
    myfile_name=""
    myfile:any
    changeListener($event){
        if($event.target.files[0].name!=undefined){
            this.myfile_name=$event.target.files[0].name
            this.myfile=$event.target}
    }
    readThis(inputValue: any){
        if(inputValue!=undefined||inputValue!=""){
            aux=""
            var file: File = inputValue.files[0];
        
            var myReader: FileReader = new FileReader();
            myReader.readAsText(file);
            myReader.onloadend = function (e) {
            aux=myReader.result;}
          
            if(file.name.endsWith('.json')){
              console.log("json file detected")
              setTimeout(() => {
              this.sendUVL(file)

              },100)
            }
            if(file.name.endsWith('.uvl')){
              console.log("uvl file detected")
              setTimeout(() => {
                this.sendUVL(file)
                },100)
            }
            if(file.name.endsWith('.xml')){
              console.log("xml file detected")
              setTimeout(() => {
                this.sendUVL(file)
                },100)
            }
            if(!(file.name.endsWith('.xml')||file.name.endsWith('.uvl')||file.name.endsWith('.json'))){
              alert("not valid file type")
            }
          }

    }
    sendUVL(uvl:any){
        alert("no hago nada aun")
      }

  }
