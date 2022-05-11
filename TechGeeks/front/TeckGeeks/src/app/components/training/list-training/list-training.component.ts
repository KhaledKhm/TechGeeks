import { Component, OnInit } from '@angular/core';
import { SectorService } from 'src/app/services/sector/sector.service';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-list-training',
  templateUrl: './list-training.component.html',
  styleUrls: ['./list-training.component.css']
})
export class ListTrainingComponent implements OnInit {

  list : any; 
  sec : any; 
  
  

  constructor(private s : TrainingService,
    private sectorServ : SectorService) { }

  ngOnInit(): void {

    this.getList();
    this.getAllCourses();
  }

  // bech nsala7a yelzem liste tkoun juste b id ta3 trainer akahw 
  private getAllCourses(){
    this.s.getAllTrainings().subscribe(
      res =>{
      this.list = res;
      console.log(res);
      } 
      )
  }

  private getList() {
    this.sectorServ.getAllSectors().subscribe(
      a => {
        this.sec = a;
        console.log(a);
      }
    )
  }

 
}
