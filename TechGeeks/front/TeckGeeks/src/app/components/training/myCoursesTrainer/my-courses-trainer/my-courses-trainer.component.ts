import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Training } from 'src/app/models/training/training';
import { SectorService } from 'src/app/services/sector/sector.service';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-my-courses-trainer',
  templateUrl: './my-courses-trainer.component.html',
  styleUrls: ['./my-courses-trainer.component.css']
})
export class MyCoursesTrainerComponent implements OnInit {


  form: boolean = false;
  closeResult!: string;

  list: any;
  sec: any;
  id: any;
  idSector : any;
  u = 1;

  constructor(private s: TrainingService,
    private sectorServ: SectorService,
    private modalService: NgbModal) { }

  ngOnInit(): void {

    this.getList();
    this.getAllCourses();
  }

  private getAllCourses() {
    this.s.getTrainingByUser(this.u).subscribe(
      res => {
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


  addTraining(event : any){
    console.log(event)
    this.s.addTrainingTrainer(this.u,this.idSector,event).subscribe(
      ()=>{
      this.getAllCourses();
      alert("Class successfully added");
    });
    this.modalService.dismissAll();

  }
  open(content: any) {
    this.modalService.open(content, { ariaLabelledBy: 'modal-basic-title' }).result.then((result) => {
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
      return `with: ${reason}`;
    }
  }
  closeForm() {

  }
  cancel() {
    this.form = false;
  }
}
