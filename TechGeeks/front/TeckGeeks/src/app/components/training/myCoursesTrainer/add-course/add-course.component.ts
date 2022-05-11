import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Training } from 'src/app/models/training/training';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-add-course',
  templateUrl: './add-course.component.html',
  styleUrls: ['./add-course.component.css']
})
export class AddCourseComponent implements OnInit {
  
  @Input() modal: any;
  @Output() submit: EventEmitter<any> = new EventEmitter<any>();

  training: Training = new Training();
  idUser = 1;


  constructor(private s: TrainingService,private router : Router) { }

  ngOnInit(): void {
    
  }

  addTraining(f: any, id: any, idSector: any) {
    id = this.idUser
    this.s.addTrainingTrainer(id, idSector, f).subscribe(
      () => {
        this.submit.emit(this.training);
        this.modal.close('Save click');
        this.router.navigate(['MyCoursesT/1']);
        
    });

  }


}

  

