import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Event } from 'src/app/models/event';
import { User } from 'src/app/models/user';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-list-event',
  templateUrl: './list-event.component.html',
  styleUrls: ['./list-event.component.css']
})
export class ListEventComponent implements OnInit {
  listEvents:any; 
  form:boolean=false;
   event!:Event
   users:Set<User>
   closeResult!:string;
  constructor(private eventService: EventService, private modalService: NgbModal) { }

  ngOnInit(): void {

    this.getAllEvents();
    this.event = {
      idEvent: null,
      libelle: null,
    	dateStart: null,
      dateEnd: null,
      sum:null,
      price:null,
      users:{
        id:null,
        firstName:null,
        lastName:null,
      },
      
   }
  }
  getAllEvents(){
    this.eventService.retrieveAllEvents().subscribe(res => this.listEvents = res)
  }

  deleteEvent(idDonation: any) {
    this.eventService.deleteEvent(idDonation).subscribe(()=> this.getAllEvents());
  }
  editEvent(eve: Event) {
    // console.log("edit " +don.sum);
     
     console.log(eve);
     this.eventService.updateEvent(eve).subscribe();
   }


  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
    }
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return  `with: ${reason}`;
      }
    }
    closeForm(){
  
    }
    cancel(){
      this.form = false;
    }
}
