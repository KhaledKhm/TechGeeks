import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { HomeComponent } from './components/home/home.component';
import { ListTrainingComponent } from './components/training/list-training/list-training.component';
import { DetailTrainingComponent } from './components/training/detail-training/detail-training.component';
import { CategoryComponent } from './components/shared/category/category/category.component';
import { ListCoursesComponent } from './components/shared/listcourses/list-courses/list-courses.component';
import { MyCoursesTrainerComponent } from './components/training/myCoursesTrainer/my-courses-trainer/my-courses-trainer.component';
import { MyCoursesWomenComponent } from './components/training/myCoursesWomen/my-courses-women/my-courses-women.component';
import { AddCourseComponent } from './components/training/myCoursesTrainer/add-course/add-course.component';
import { DetailCourseTComponent } from './components/training/myCoursesTrainer/detail-course-t/detail-course-t.component';
import { AddCertificteComponent } from './components/training/myCoursesWomen/add-certificte/add-certificte.component';
import { ListQuizComponent } from './components/training/myCoursesTrainer/QuizForm/list-quiz/list-quiz.component';



@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavbarComponent,
    NotFoundComponent,
    HomeComponent,
    ListTrainingComponent,
    DetailTrainingComponent,
    CategoryComponent,
    ListCoursesComponent,
    MyCoursesTrainerComponent,
    MyCoursesWomenComponent,
    AddCourseComponent,
    DetailCourseTComponent,
    AddCertificteComponent,
    ListQuizComponent,



  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    RouterModule,
    NgbModalModule,
    FormsModule
  ],
  providers: [
   
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
{ }
