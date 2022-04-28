import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/Models/donation';
import { DonationService } from 'src/app/Services/donation.service';

@Component({
  selector: 'app-list-donation',
  templateUrl: './list-donation.component.html',
  styleUrls: ['./list-donation.component.css']
})
export class ListDonationComponent implements OnInit {
  
  listDonations : any; 
  form : boolean = false;
   donation!: Donation;
   closeResult! : string;
  
  constructor(private donationService: DonationService, private modalService: NgbModal) { }

  ngOnInit(): void {
    
    
    this.donation = {
      idDonation: null,
      dateDonation: null,
    	sum: null,
     bankAccount: null,
   }
  }

  retrieveAllDonations(){
    console.log("sum"+this.donation.sum);
    this.donationService.retrieveAllDonations().subscribe(res => this.listDonations = res)
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
