import {AppComponent } from './app.component';
import {Const} from './components/constraint/const';
import {FMTree } from './components/FMTree/FMTree';
import {Refactoring } from './components/refactor/refactoring';
import { globalhtml } from './components/globalhtml/globalhtml';
import { about } from './components/about/about';
import { mainpage } from './components/mainpage/mainpage';
import { card1 } from './components/mainpage/Card_1/card1';
import { card2 } from './components/mainpage/Card_2/card2';
import { card3 } from './components/mainpage/Card_3/card3';



import {MatTreeModule} from '@angular/material/tree';
import {MatIconModule} from '@angular/material/icon';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';
import {BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule } from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {MatListModule} from '@angular/material/list';
import {HttpClientModule} from "@angular/common/http";
import {NgModule } from '@angular/core';
import {BrowserModule } from '@angular/platform-browser';
import {FormsModule } from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatDialogModule} from '@angular/material/dialog';
import {MatChipsModule} from '@angular/material/chips';
import {ScrollingModule} from '@angular/cdk/scrolling';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatPaginatorModule} from '@angular/material/paginator';

@NgModule({
  declarations: [
    AppComponent,
    FMTree,
    Const, 
    Refactoring, 
    globalhtml,
    about,
    mainpage,
    card1,
    card2,
    card3,
  ],


  
  imports: [
    BrowserModule,
    MatDialogModule,
    MatPaginatorModule,
    MatTooltipModule,
    ScrollingModule,
    MatToolbarModule,
    MatChipsModule,
    MatSidenavModule,
    HttpClientModule,
    MatTreeModule,
    MatMenuModule,
    MatIconModule,
    MatListModule,
    MatCheckboxModule,
    MatInputModule,
    MatSelectModule,
    FormsModule,
    MatButtonModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
 
})
export class AppModule { }
