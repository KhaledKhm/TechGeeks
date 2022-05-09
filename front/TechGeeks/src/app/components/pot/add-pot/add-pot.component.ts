import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pot } from 'src/app/models/pot';
import { PotService } from 'src/app/services/pot.service';

@Component({
  selector: 'app-add-pot',
  templateUrl: './add-pot.component.html',
  styleUrls: ['./add-pot.component.css']
})
export class AddPotComponent implements OnInit {
  listPots:any; 
  form:boolean=false;
   pot!:Pot;
   closeResult!:string;
  constructor(private potService: PotService, private modalService: NgbModal) { }

  ngOnInit(): void {
   /* this.pot = {
      idPot:null,
      libelle:null,
      description: null,
      sum:null,	
      bankAccount:null,
  }*/
  }
  addPot(p: any){
    this.potService.addPot(p).subscribe(() => {
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
