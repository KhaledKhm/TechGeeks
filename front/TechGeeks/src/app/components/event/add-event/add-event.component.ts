import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Event } from 'src/app/models/event';
import { EventService } from 'src/app/services/event.service';

@Component({
  selector: 'app-add-event',
  templateUrl: './add-event.component.html',
  styleUrls: ['./add-event.component.css']
})
export class AddEventComponent implements OnInit {

  constructor(private eventService : EventService, private modalService: NgbModal) { }
  listEvents: any; 
  form : boolean = false;
   event!: Event;
   closeResult! : string;
  ngOnInit(): void {
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

  addEvent(e: any){
    
    console.log("add" +e.sum);
    console.log("add" +e);
    this.eventService.addEvent(e).subscribe(() => {
      this.form = false;
      //return d;
    });
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
