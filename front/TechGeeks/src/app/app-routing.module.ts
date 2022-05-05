import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListDonationComponent } from './components/donation/list-donation/list-donation.component';
import { ListEventComponent } from './components/event/list-event/list-event.component';
import { HomeComponent } from './components/home/home.component';
import { ListLocalComponent } from './components/local/list-local/list-local.component';
import { ListPotComponent } from './components/pot/list-pot/list-pot.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';

const routes: Routes = [
  {path: 'home',  component: HomeComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  { path: 'list-donation',  component: ListDonationComponent },
  { path: 'list-event',  component: ListEventComponent },
  { path: 'list-local',  component: ListLocalComponent },
  { path: 'list-pot',  component: ListPotComponent },
  //{ path: 'add-donation',  component: AddDonationComponent },


  {path:'404',component:NotFoundComponent},
  {path:'**',component:NotFoundComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
