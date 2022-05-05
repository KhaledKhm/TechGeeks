import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Pot } from 'src/app/models/pot';
import { PotService } from 'src/app/services/pot.service';

@Component({
  selector: 'app-list-pot',
  templateUrl: './list-pot.component.html',
  styleUrls: ['./list-pot.component.css']
})
export class ListPotComponent implements OnInit {
  listPots:any; 
  form:boolean=false;
   pot!:Pot;
   closeResult!:string;
  constructor(private potService: PotService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getAllPots();
    this.pot = {
      idPot:null,
      libelle:null,
      sum:null,	
      bankAccount:null,
  }

}

getAllPots(){
  this.potService.retrieveAllPots().subscribe(res => this.listPots = res)
}

deletePot(idPot: any) {
  this.potService.deletePot(idPot).subscribe(()=> this.getAllPots());
}
editPot(po: Pot) {
  // console.log("edit " +don.sum);
   
   console.log(po);
   this.potService.updatePot(po).subscribe();
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
