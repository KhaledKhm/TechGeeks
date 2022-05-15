import { Component, Input, OnInit } from '@angular/core';
import { Event } from 'src/app/models/event';
import { Pot } from 'src/app/models/pot';

@Component({
  selector: 'app-put-money',
  templateUrl: './put-money.component.html',
  styleUrls: ['./put-money.component.css']
})
export class PutMoneyComponent implements OnInit {
  @Input() pot = {
    idPot:null,
    libelle:null,
    description: null,
    sum:null,	
    bankAccount:null,
}

  form : boolean = false;
  event!: Event;
  closeResult! : string;
  myDate = new Date();
  pott!: Pot;
  constructor() { }

  ngOnInit(): void {
  }

}
