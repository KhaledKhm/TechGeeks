import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAppointmentComponent } from './components/add-appointment/add-appointment.component';
import { AddComplaintComponent } from './components/add-complaint/add-complaint.component';
import { AppointmentListComponent } from './components/appointment-list/appointment-list.component';
import { ComplaintListComponent } from './components/complaint-list/complaint-list.component';
import { DeleteComplaintComponent } from './components/delete-complaint/delete-complaint.component';
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { UpdateAppointmentComponent } from './components/update-appointment/update-appointment.component';
import { UpdateComplaintComponent } from './components/update-complaint/update-complaint.component';

const routes: Routes = [
  {path: 'home',  component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {path: 'addcomplaint',  component: AddComplaintComponent  },
 // {path: 'deletecomplaint/:idcomplaint',  component: DeleteComplaintComponent },
  {path: 'retrivecomplaint',  component: ComplaintListComponent },
  {path: 'updatecomplaint/:id',  component: UpdateComplaintComponent },
  {path: 'updateappointment/:id',  component: UpdateAppointmentComponent },

{path:'detail/:id',component:ComplaintListComponent},
  {path: 'retriveappointment',  component: AppointmentListComponent },
  {path: 'retriveappointment',  component: AppointmentListComponent },
  {path: 'addappointment',  component: AddAppointmentComponent },

  {path:'404',component:NotFoundComponent},
  {path:'**',component:NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
