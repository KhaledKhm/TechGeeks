import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Answer } from 'src/app/models/answer/answer';
import { Question } from 'src/app/models/question/question';
import { AnswerService } from 'src/app/services/answer/answer.service';
import { QuestionService } from 'src/app/services/question/question.service';
import { QuizService } from 'src/app/services/quiz/quiz.service';
import { TrainingService } from 'src/app/services/training/training.service';

@Component({
  selector: 'app-list-quiz',
  templateUrl: './list-quiz.component.html',
  styleUrls: ['./list-quiz.component.css']
})
export class ListQuizComponent implements OnInit {

  form: boolean = false;
  closeResult!: string;

  q: any
  idQuiz: any;
  idTraining :any
  idAnswer : any;
  idQuestion :any
  qst : any;
  correct = true;
  wrong = false ;

  question : Question = new Question();
  answer1 : Answer = new Answer();
  answer2 : Answer = new Answer();
  answer3 : Answer = new Answer();

  ann : any;
  ques : any
questTest : any;


  counter = 60;
  currentQuestion : number = 0;


  constructor(private s: TrainingService, private ac: ActivatedRoute,
    private modalService: NgbModal,
    private router: Router,
    private sq: QuizService,
    private squest: QuestionService,
    private sa: AnswerService) { }

  ngOnInit(): void {
    this.getQuiz();

  }


  private getQuiz() {
    this.idTraining = this.ac.snapshot.params['idTraining'];
    this.sq.getQuizBytraining(this.idTraining).subscribe(
      res => {
        this.q = res;
      });
  }


  editAnswer(idAnswer : any, answer : any)
{
  this.idAnswer =idAnswer;
  this.ann=answer;
  this.sa.editAnswer(idAnswer,answer).subscribe(()=>{
    this.ngOnInit();
  });
}

deleteAnswer(idAnswer : any)
{
  this.sa.deleteAnswer(idAnswer).subscribe(()=>{
    this.ngOnInit();
  });
}

  nextquestion() {
    this.idTraining = this.ac.snapshot.params['idTraining'];
    this.sq.getQuizBytraining(this.idTraining).subscribe(
      () => {
        this.squest.addQuestionByquiz(this.q.idQuiz,this.question).subscribe((res)=>{
          this.questTest = res ; 
          console.log(this.questTest.idQuestion);
            this.sa.addAnswerByQuestion(this.questTest.idQuestion,this.answer1).subscribe();
            this.sa.addAnswerByQuestion(this.questTest.idQuestion,this.answer2).subscribe();
            this.sa.addAnswerByQuestion(this.questTest.idQuestion,this.answer3).subscribe();
            
            console.log(res);
            
        });
       
       
      });
    
  }

  redirect() {
    {
    this.idTraining = this.ac.snapshot.params['idTraining'];
    this.router.navigate([`detailCourseT/${this.idTraining}`]);
  }
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
