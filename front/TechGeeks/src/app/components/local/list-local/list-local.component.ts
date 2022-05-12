import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Local } from 'src/app/models/local';
import { LocalService } from 'src/app/services/local.service';

@Component({
  selector: 'app-list-local',
  templateUrl: './list-local.component.html',
  styleUrls: ['./list-local.component.css']
})
export class ListLocalComponent implements OnInit {
  listLocals:any; 
  form:boolean=false;
   local!:Local
   closeResult!:string;
  constructor(private localService: LocalService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllLocals();
    this.local = {
      idLocal:null,
      city:null,
      governorate:null,	
      postalCode:null,	
      address:null,		
      name:null,			
      dateStart:null,		
      dateEnd:null,	
   /*   events:{
        idEvent: null,
      libelle: null,
    	dateStart: null,
      dateEnd: null,
      sum:null,
      price:null,
      }
     */ 
   }
  }

  getAllLocals(){
    this.localService.retrieveAllLocals().subscribe(res => this.listLocals = res)
  }

  deleteLocal(idLocal: any) {
    this.localService.deleteLocal(idLocal).subscribe(()=> this.getAllLocals());
  }
  editLocal(loc: Event) {
    // console.log("edit " +don.sum);
     
     console.log(loc);
     this.localService.updateLocal(loc).subscribe();
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
