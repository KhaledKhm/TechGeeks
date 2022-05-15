import { DatePipe } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Donation } from 'src/app/models/donation';
import { Pot } from 'src/app/models/pot';
import { User } from 'src/app/models/user';
import { DonationService } from 'src/app/services/donation.service';

@Component({
  selector: 'app-add-my-donation',
  templateUrl: './add-my-donation.component.html',
  styleUrls: ['./add-my-donation.component.css'],
  providers: [DatePipe]
  
})
export class AddMyDonationComponent implements OnInit {
  
  @Input() pot = {
    idPot:null,
    libelle:null,
    description: null,
    sum:null,	
    bankAccount:null,
}


  form : boolean = false;
  donation!: Donation;
  closeResult! : string;
  myDate = new Date();
  pott!: Pot;
  userr!: User;
  constructor(private donationService : DonationService, private modalService: NgbModal, private datePipe: DatePipe) { }

  ngOnInit(): void {
    this.donation = {
      idDonation: null,
      dateDonation: this.datePipe.transform(this.myDate, 'yyyy-MM-dd'),
      sum: null,
     bankAccount: null,
     pot:this.pott,
     user: this.userr,
    }
  }
  addMyDonation(d: any,idPot:any,idUser:any){
    
 //   console.log("add" +d.sum);
  //  console.log("add" +d);
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
