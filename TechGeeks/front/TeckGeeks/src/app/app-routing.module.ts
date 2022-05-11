import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { DetailTrainingComponent } from './components/training/detail-training/detail-training.component';
import { ListTrainingComponent } from './components/training/list-training/list-training.component';
import { AddCourseComponent } from './components/training/myCoursesTrainer/add-course/add-course.component';
import { DetailCourseTComponent } from './components/training/myCoursesTrainer/detail-course-t/detail-course-t.component';
import { MyCoursesTrainerComponent } from './components/training/myCoursesTrainer/my-courses-trainer/my-courses-trainer.component';
import { ListQuizComponent } from './components/training/myCoursesTrainer/QuizForm/list-quiz/list-quiz.component';
import { MyCoursesWomenComponent } from './components/training/myCoursesWomen/my-courses-women/my-courses-women.component';


const routes: Routes = [
  {path: 'home',  component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},

  //Training
  {path:'detailCourse/:idTraining',component:DetailTrainingComponent},
  {path:'listCourses',component:ListTrainingComponent},

  //training by trainer
  {path:'MyCoursesT/:id',component:MyCoursesTrainerComponent},
  {path:'addCoursesT/:id/:idsector',component:AddCourseComponent},
  {path:'detailCourseT/:idTraining',component:DetailCourseTComponent},

  //Quiz
  {path:'MyCoursesT/:id/:idTraining',component:ListQuizComponent},
  


  //training by women
  {path:'MyCoursesW/:id',component:MyCoursesWomenComponent},

  {path:'404',component:NotFoundComponent},
  {path:'**',component:NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
