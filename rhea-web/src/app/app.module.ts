import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FMEditor } from './components/fm-editor/fm-editor.component';

import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';


@NgModule({
  declarations: [
    AppComponent,
    FMEditor,
  ],
  imports: [
    BrowserModule,
    MatTreeModule,
    MatIconModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
