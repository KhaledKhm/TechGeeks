import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { SectorService } from 'src/app/services/sector/sector.service';
import { ActivatedRoute } from '@angular/router';
import { Sector } from 'src/app/models/sector/sector';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  @Input() s:any; 
  @Output() notif = new EventEmitter();
  id : any;

  constructor(private secServ : SectorService,private activateroute: ActivatedRoute) { }

  ngOnInit(): void {
  }

  sendDataToParent(s: Sector){
    this.id =s.idSector ;
    this.notif.emit(this.id);
  }

}
