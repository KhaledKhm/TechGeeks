import { Component, Input, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Event } from 'src/app/models/event';
import { EventService } from 'src/app/services/event.service';
import { LocalService } from 'src/app/services/local.service';

@Component({
  selector: 'app-assign-local-to-event',
  templateUrl: './assign-local-to-event.component.html',
  styleUrls: ['./assign-local-to-event.component.css']
})
export class AssignLocalToEventComponent implements OnInit {
  form:boolean=false;
  event!:Event
  closeResult!:string;
  listEvents:any;

@Input() local= {
  idLocal:null,
  city:null,
  governorate:null,	
  postalCode:null,	
  address:null,		
  name:null,			
  dateStart:null,		
  dateEnd:null,	
  
}
  constructor(private localService: LocalService, private eventService: EventService, private modalService: NgbModal) { }
  
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
      }
      
   }
  }

  getAllEvents(){
    this.eventService.retrieveAllEvents().subscribe(res => this.listEvents = res)
  }

  assignEventToLocal(idLocal:any,idEvent:any){

    
    this.localService.assignEventToLocal(idLocal,idEvent).subscribe(() => {
      this.getDismissReason
      //    this.getAllProducts();
          this.form = false;
          alert("Assign done successfully");
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

    closeMod(){
      this.modalService.dismissAll();
    }
}
