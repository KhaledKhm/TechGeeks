import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/models/donation';
import { DonationService } from 'src/app/services/donation.service';

@Component({
  selector: 'app-edit-donation',
  templateUrl: './edit-donation.component.html',
  styleUrls: ['./edit-donation.component.css']
})
export class EditDonationComponent implements OnInit {
  listDonations:any; 
  form:boolean=false;
   donation!:Donation;
   closeResult!:string;
   @Output() editDon = new EventEmitter<any>();
  constructor(private donationService: DonationService, private modalService: NgbModal) { }

  ngOnInit(): void {
 //   this.getAllDonations();
    this.donation = {
      idDonation: null,
      dateDonation: null,
    	sum: null,
     bankAccount: null,
   }
  }
  editDonation(don: Donation) {
   // console.log("edit " +pro.price);
    
    console.log(don);
    this.editDon.emit(this.donationService.updateDonation(don).subscribe());
  }

}
