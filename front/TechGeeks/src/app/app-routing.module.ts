import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDonationComponent } from './Components/donation/add-donation/add-donation.component';
import { ListDonationComponent } from './Components/donation/list-donation/list-donation.component';

const routes: Routes = [
  { path: 'list-donation',  component: ListDonationComponent },
  { path: 'add-donation',  component: AddDonationComponent },
  {path: '', redirectTo: '/home', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
