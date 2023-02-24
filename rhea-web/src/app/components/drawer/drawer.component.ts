import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-drawer',
  templateUrl: './drawer.component.html',
  styleUrls: ['./drawer.component.css'],
  
})

export class DrawerComponent implements OnInit {


  @Output() showFM_Editor_drawer_event = new EventEmitter<void>()
  @Output() showAbout_drawer_event = new EventEmitter<void>()
  @Output() showRepository_drawer_event = new EventEmitter<void>()
  @Output() showGuide_drawer_event = new EventEmitter<void>()
  
  constructor() { }

  ngOnInit(): void {
  }
//NOT CONNECTED
  showFM_Editor_drawer(){
    this.showFM_Editor_drawer_event.emit();
  }
  showAbout_drawer(){
    this.showAbout_drawer_event.emit()
  }
  showRepository_drawer(){
    this.showRepository_drawer_event.emit()
  }
  showGuide_drawer(){
    this.showGuide_drawer_event.emit()

  }

}
