import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Answer } from 'src/app/models/answer/answer';
import { Question } from 'src/app/models/question/question';
import { Quiz } from 'src/app/models/quiz/quiz';
import { Training } from 'src/app/models/training/training';
import { AnswerService } from 'src/app/services/answer/answer.service';
import { QuestionService } from 'src/app/services/question/question.service';
import { QuizService } from 'src/app/services/quiz/quiz.service';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-detail-course-t',
  templateUrl: './detail-course-t.component.html',
  styleUrls: ['./detail-course-t.component.css']
})
export class DetailCourseTComponent implements OnInit {
  list: any;
  idTraining: any;
  idQuiz: any;
  idQuestion :any;

  form: boolean = false;
  closeResult!: string;


  quiz: Quiz = new Quiz();


  q: any;
  qst:any;
  an:any


  current = 1;
  counter = 60;
  currentQuestion = 0;


  constructor(private s: TrainingService, private ac: ActivatedRoute,
    private modalService: NgbModal,
    private router: Router,
    private sq: QuizService,
    private squest: QuestionService,
    private sa: AnswerService) { }

  ngOnInit(): void {
    this.getList();   
    this.getQuiz();
 
  }

  ////////////////// Training /////////////////////////////


  private getList() {
    this.idTraining = this.ac.snapshot.params['idTraining']
    this.s.getTrainingbyid(this.idTraining).subscribe(
      res => {
        this.list = res;
        console.log(res);
      }
    )
  }


  editTraining(training: Training, idTraining: any) {
    this.s.editTraining(training, idTraining).subscribe();
  }


  deleteTraining(idTraining: any) {
    this.s.deleteTraining(idTraining).subscribe(
      () => {
        this.router.navigate(['MyCoursesT/1']);
      });
  }

  ////////////////// Training /////////////////////////////





  //////////////////   Quiz   /////////////////////////////


  private getQuiz() {
    
      this.idTraining = this.ac.snapshot.params['idTraining'];
      this.sq.getQuizBytraining(this.idTraining).subscribe(
        (res) => {
          this.q = res;
          console.log(res);

          this.squest.getQuestionByQuiz(this.q.idQuiz).subscribe(
            (res) => {
              this.qst = res;
              console.log(res);
              for (var c of this.qst) {
                console.log(c.idQuestion);
                this.sa.getAnswerByQuestion(c.idQuestion).subscribe((res)=>{
                  this.an = res;
                  console.log(res);
                }              
                );
              }
                
              
              

            }
          );
        });  
  }


  addQuiz() {
    this.idTraining = this.ac.snapshot.params['idTraining'];
    console.log(this.idTraining);
    this.sq.addQuiz(this.idTraining, this.quiz).subscribe(
      ()=>{
        this.router.navigate([
          `MyCoursesT/1/${this.idTraining}`]);
      }
    );
  }

  editQuestion(question: Question, idQuestion: any) {
    this.squest.editQuestion(question, idQuestion).subscribe();
  }

  //////////////////   Quiz   /////////////////////////////


  deleteQuestion(idTraining: any) {
    this.idTraining = this.ac.snapshot.params['idTraining'];
      this.sq.getQuizBytraining(this.idTraining).subscribe(
        (res) => {
          this.q = res;
          console.log(res);

          this.squest.deleteQuestion(this.q.idQuiz).subscribe()
  });
}



  nextquestion() {
    this.currentQuestion++;
  }

  previousQuestion() {
    this.currentQuestion--;
  }

  startCounter() {

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
