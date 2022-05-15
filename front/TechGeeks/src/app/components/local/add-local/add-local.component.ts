import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Local } from 'src/app/models/local';
import { LocalService } from 'src/app/services/local.service';

@Component({
  selector: 'app-add-local',
  templateUrl: './add-local.component.html',
  styleUrls: ['./add-local.component.css']
})
export class AddLocalComponent implements OnInit {
  listLocals:any; 
  form:boolean=false;
   local!:Local
   closeResult!:string;
  constructor(private localService: LocalService, private modalService: NgbModal) { }

  ngOnInit(): void {
 //   this.getAllLocals();
    this.local = {
      idLocal:null,
      city:null,
      governorate:null,	
      postalCode:null,	
      address:null,		
      name:null,			
      dateStart:null,		
      dateEnd:null,	
    }

  }
    addLocal(l: any){
      this.localService.addLocal(l).subscribe(() => {
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