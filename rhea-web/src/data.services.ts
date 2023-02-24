import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { each } from "jquery";

// const mariadb = require('mariadb');
// const pool = mariadb.createPool({
//     host: "localhost", 
//     user: "caosd", 
//     password: "password",
//     database:"rhea"});

@Injectable()
export class DataServices{
    constructor(private httpClient:HttpClient){    }
    
  querySQL(){
      //this.httpClient.post('http://localhost/phpmyadmin/index.php?route=/database/structure&server=1&db=rhea');
      
      var pr = this.httpClient.get('http://localhost/phpmyadmin/index.php?route=/database/structure&server=1&db=rhea/datos.json')
  }

}


// async function Function() {
//     let conn;
//     try {
  
//       conn = await pool.getConnection();
//       const rows = await conn.query("SELECT * FROM Repository");       // rows: [ {val: 1}, meta: ... ]
//       //const res = await conn.query("INSERT INTO myTable value (?, ?)", [1, "mariadb"]);       // res: { affectedRows: 1, insertId: 1, warningStatus: 0 }
  
//     } finally {
//       if (conn) conn.release(); //release to pool
//     }
//   }