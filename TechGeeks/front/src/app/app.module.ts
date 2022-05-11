import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ModalDismissReasons, NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { ComplaintListComponent } from './components/complaint-list/complaint-list.component';
import { AddComplaintComponent } from './components/add-complaint/add-complaint.component';
import { CommonModule } from '@angular/common';
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';
import { AddAppointmentComponent } from './components/add-appointment/add-appointment.component';
import { UpdateComplaintComponent } from './components/update-complaint/update-complaint.component';
import { UpdateAppointmentComponent } from './components/update-appointment/update-appointment.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ComplaintListComponent,
    AddComplaintComponent,
    AppointmentListComponent,
    AddAppointmentComponent,
    UpdateComplaintComponent,
    UpdateAppointmentComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    RouterModule,
    NgbModalModule,
    CommonModule,
    FormsModule,
  
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
