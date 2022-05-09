import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/models/donation';
import { DonationService } from 'src/app/services/donation.service';

@Component({
  selector: 'app-add-my-donation',
  templateUrl: './add-my-donation.component.html',
  styleUrls: ['./add-my-donation.component.css']
})
export class AddMyDonationComponent implements OnInit {
  form : boolean = false;
  donation!: Donation;
  closeResult! : string;
  constructor(private donationService : DonationService, private modalService: NgbModal, private datePipe: DatePipe) { }

  ngOnInit(): void {
  }
  addMyDonation(d: any,idPot:any,idUser:any){
    
    console.log("add" +d.sum);
    console.log("add" +d);
    this.donationService.addAndAssignPotAndUser(d,idPot,idUser).subscribe(() => {
  //    this.getAllProducts();
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

    closeMod(){
      this.modalService.dismissAll();
    }
}
