import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/models/donation';
import { DonationService } from 'src/app/services/donation.service';

@Component({
  selector: 'app-donation',
  template: '' ,
  templateUrl: './list-donation.component.html',
  styleUrls: ['./list-donation.component.css']
})
export class ListDonationComponent implements OnInit {
  
  listDonations:any; 
  form:boolean=false;
   donation!:Donation;
   closeResult!:string;
  
  constructor(private donationService: DonationService, private modalService: NgbModal) { }

  ngOnInit(): void {
    
    this.getAllDonations();
    this.donation = {
      idDonation: null,
      dateDonation: null,
    	sum: null,
     bankAccount: null,
   }
  }

  getAllDonations(){
    this.donationService.retrieveAllDonations().subscribe(res => this.listDonations = res)
  }

  deleteDonation(idDonation: any) {
    this.donationService.deleteDonation(idDonation).subscribe(()=> this.getAllDonations());
  }
  editDonation(don: Donation) {
    // console.log("edit " +don.sum);
     
     console.log(don);
     this.donationService.updateDonation(don).subscribe();
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
