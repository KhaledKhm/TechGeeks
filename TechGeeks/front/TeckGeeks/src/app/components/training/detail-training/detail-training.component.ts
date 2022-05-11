import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-detail-training',
  templateUrl: './detail-training.component.html',
  styleUrls: ['./detail-training.component.css']
})
export class DetailTrainingComponent implements OnInit {

  list: any;
  idTraining: any;
  id =3;

  constructor(private s: TrainingService, private activateroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getList();
  }

  private getList() {
    this.idTraining = this.activateroute.snapshot.params['idTraining']
    this.s.getTrainingbyid(this.idTraining).subscribe(
      res => {
        this.list = res;
        console.log(res);
      }
    )
  }

  addCertificate(c : any , idt : any){
    this.idTraining = this.activateroute.snapshot.params['idTraining'];
    idt = this.idTraining;
    this.s.addTrainingWomen(c,this.id,idt).subscribe();
  }
}
