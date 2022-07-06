import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FMEditor } from './components/fm-editor/fm-editor.component';

import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';

import { FMFileUploadComponent } from './components/fm-file-upload/fm-file-upload.component';

@NgModule({
  declarations: [
    AppComponent,
    FMEditor,
    FMFileUploadComponent
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
