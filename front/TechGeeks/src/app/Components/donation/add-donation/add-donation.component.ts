import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/models/donation';
import { Pot } from 'src/app/models/pot';
import { User } from 'src/app/models/user';
import { DonationService } from 'src/app/services/donation.service';

@Component({
  selector: 'app-add-donation',
  templateUrl: './add-donation.component.html',
  styleUrls: ['./add-donation.component.css'],
  providers: [DatePipe]
})
export class AddDonationComponent implements OnInit {

  constructor(private donationService : DonationService, private modalService: NgbModal, private datePipe: DatePipe) { }

  listDonations : any; 
  form : boolean = false;
   donation!: Donation;
   closeResult! : string;
   myDate = new Date();
   pott!: Pot;
   userr!:User;
  ngOnInit(): void {
  //  this.getAllDonations();

  this.donation = {
    idDonation: null,
    dateDonation: this.datePipe.transform(this.myDate, 'yyyy-MM-dd'),
    sum: null,
   bankAccount: null,
   pot:this.pott,
   user: this.userr,
 }

  }

  addDonation(d: any){
    
    console.log("add" +d.sum);
    console.log("add" +d);
    this.donationService.addDonation(d).subscribe(() => {
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