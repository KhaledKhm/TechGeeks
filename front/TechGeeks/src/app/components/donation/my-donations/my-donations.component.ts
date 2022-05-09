import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/models/donation';
import { Pot } from 'src/app/models/pot';
import { DonationService } from 'src/app/services/donation.service';

@Component({
  selector: 'app-my-donations',
  templateUrl: './my-donations.component.html',
  styleUrls: ['./my-donations.component.css']
})
export class MyDonationsComponent implements OnInit {
  myDonations:any; 
  form:boolean=false;
   donation!:Donation;
   closeResult!:string;
 //  pott!:Pot;

  constructor(private donationService: DonationService, private modalService: NgbModal) { }

  ngOnInit(): void {
    console.log(this.getMyDonations(1));
    this.getMyDonations(1);
   /* this.donation = {
      idDonation: null,
      dateDonation: null,
    	sum: null,
     bankAccount: null,
     pot:this.pott = {
      idPot:null,
      libelle:null,
      description: null,
      sum:null,	
      bankAccount:null,
     },
     user: null,
 
   }*/
  }
  getMyDonations(idUSer: any){
   // console.log("Pot"+this.myDonations.pot.libelle);
  //  console.log(Object.values(this.myDonations.pot))
    this.donationService.retrieveMyDonations(1).subscribe(res => this.myDonations = res)
    console.log(this.myDonations )
  }

}
