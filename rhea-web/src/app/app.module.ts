import {AppComponent } from './app.component';
import {FMEditor } from './components/fm-editor/fm-editor.component';
import {Rama} from './components/miarbol/miarbol';
import{Const} from './components/constrain/const';
import { Arbol } from './components/arbol_pruebas/arbol';


import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatCardModule} from '@angular/material/card';
import {MatRadioModule} from '@angular/material/radio';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatMenuModule} from '@angular/material/menu';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule } from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {DragDropModule} from '@angular/cdk/drag-drop';
import {HttpClientModule} from "@angular/common/http";
import {NgModule } from '@angular/core';
import {BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatDialogModule} from '@angular/material/dialog';


@NgModule({
  declarations: [
    AppComponent,
    FMEditor,
    Arbol,
    Rama,  
    Const,  
  ],


  
  imports: [
    BrowserModule,
    MatDialogModule,
    DragDropModule,
    MatToolbarModule,
    MatGridListModule,
    
    MatSidenavModule,
    HttpClientModule,
    MatTreeModule,
    MatMenuModule,
    MatIconModule,MatListModule,
    MatCheckboxModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    MatRadioModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatButtonModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
 
})
export class AppModule { }
