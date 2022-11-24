import {AppComponent } from './app.component';
import {Const} from './components/constraint/const';
import {FMTree } from './components/FMTree/FMTree';
import {Refactoring } from './components/refactor/refactoring';
import { Language } from './components/Language/Language';
import { Semantics } from './components/Semantics/Semantics';
import { ToolsExtension } from './components/ToolsExtension/ToolsExtension';

import { globalhtml } from './components/globalhtml/globalhtml';
import { about } from './components/about/about';
import { Repository } from './components/Repository/Repository';
import { mainpage } from './components/mainpage/mainpage';
import { card1 } from './components/mainpage/Card_1/card1';
import { card3 } from './components/mainpage/Card_3/card3';
import { card4 } from './components/mainpage/Card_4/card4';
import { FeatureTree } from './components/mainpage/FeatureTree/FeatureTree';
import { Information } from './components/mainpage/Information/Information';
import { semantics_metrics } from './components/mainpage/Semantics metrics/Semantics metrics';
import { ConstraintsText } from './components/mainpage/ConstraintsText/ConstraintsText';
import { ConstraintsTree } from './components/mainpage/ConstraintsTree/ConstraintsTree';


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
import {MatTableModule} from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';


@NgModule({
  declarations: [
    AppComponent,
    FMTree,
    Const, 
    Refactoring, 
    Language,
    Semantics,
    ToolsExtension,

    
    globalhtml,
    about,
    Repository,
    mainpage,
    card1,
    card3,
    card4,
    FeatureTree,   
    Information,
    semantics_metrics,
    ConstraintsText,
    ConstraintsTree,
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
    MatTableModule,
    MatSortModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
 
})
export class AppModule { }
