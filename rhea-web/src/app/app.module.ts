import {AppComponent } from './app.component';
import {FMEditor } from './components/fm-editor/fm-editor.component';
import {TreeChecklistExample} from './components/tree/tree-checklist-example';
import {Rama} from './components/miarbol/miarbol';
import {arbol} from './components/arbol_pruebas/arbol';

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
import {DragDropModule,CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {HttpClientModule} from "@angular/common/http";
import {NgModule } from '@angular/core';
import {BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule } from '@angular/forms';





@NgModule({
  declarations: [
    AppComponent,
    FMEditor,
    arbol,
    TreeChecklistExample,
    Rama,
    
    
  ],
  imports: [
    BrowserModule,
    DragDropModule,
    HttpClientModule,
    MatTreeModule,
    MatMenuModule,
    MatIconModule,MatListModule,
    MatCheckboxModule,
    MatInputModule,
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
