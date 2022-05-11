import { Component, OnInit } from '@angular/core';
import { SectorService } from 'src/app/services/sector/sector.service';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-my-courses-women',
  templateUrl: './my-courses-women.component.html',
  styleUrls: ['./my-courses-women.component.css']
})
export class MyCoursesWomenComponent implements OnInit {

  list : any; 
  sec : any; 
  id : any;
  u = 3;

  constructor(private s : TrainingService,
    private sectorServ : SectorService) { }

  ngOnInit(): void {
    this.getList();
    this.getAllCourses();
  }


  private getAllCourses(){
    this.s.getTrainingByUser(this.u).subscribe(
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
