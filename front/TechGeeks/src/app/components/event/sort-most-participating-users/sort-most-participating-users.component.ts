import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Event } from 'src/app/models/event';
import { User } from 'src/app/models/user';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-sort-most-participating-users',
  templateUrl: './sort-most-participating-users.component.html',
  styleUrls: ['./sort-most-participating-users.component.css']
})
export class SortMostParticipatingUsersComponent implements OnInit {
  mostPartUsersEvents:any;
  orm:boolean=false;
   event!:Event
   closeResult!:string;
   user!:User;
  constructor(private eventService: EventService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.sortParticipatingUsers();
    this.user = {
     
        id:null,
        firstName:null,
        lastName:null,
      
      
   }
  }


  sortParticipatingUsers(){
    this.eventService.sortParticipatingUsers().subscribe(res => this.mostPartUsersEvents = res)
    console.log(this.mostPartUsersEvents)
  }
}
