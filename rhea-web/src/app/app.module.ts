import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule,ReactiveFormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { FMEditor } from './components/fm-editor/fm-editor.component';
import {TreeChecklistExample} from './components/fm-editor/tree/tree-checklist-example';
import {Rama} from './components/miarbol/miarbol';

import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatCardModule} from '@angular/material/card';
import {MatRadioModule} from '@angular/material/radio';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatMenuModule} from '@angular/material/menu';




@NgModule({
  declarations: [
    AppComponent,
    FMEditor,
    TreeChecklistExample,
    Rama,
    
    
  ],
  imports: [
    BrowserModule,
    MatTreeModule,
    MatMenuModule,
    MatIconModule,
    MatCheckboxModule,
    MatCardModule,
    MatRadioModule,
    FormsModule,
    MatFormFieldModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
 
})
export class AppModule { }
