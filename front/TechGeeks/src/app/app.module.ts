import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';
import { AddDonationComponent } from './Components/donation/add-donation/add-donation.component';
import { ModifyDonationComponent } from './Components/donation/modify-donation/modify-donation.component';
import { DeleteDonationComponent } from './Components/donation/delete-donation/delete-donation.component';
import { ListDonationComponent } from './Components/donation/list-donation/list-donation.component';
import { GetDonationComponent } from './Components/donation/get-donation/get-donation.component';
import { AddEventComponent } from './Components/event/add-event/add-event.component';
import { ModifyEventComponent } from './Components/event/modify-event/modify-event.component';
import { DeleteEventComponent } from './Components/event/delete-event/delete-event.component';
import { ListEventComponent } from './Components/event/list-event/list-event.component';
import { GetEventComponent } from './Components/event/get-event/get-event.component';
import { AddLocalComponent } from './Components/local/add-local/add-local.component';
import { ModifyLocalComponent } from './Components/local/modify-local/modify-local.component';
import { DeleteLocalComponent } from './Components/local/delete-local/delete-local.component';
import { ListLocalComponent } from './Components/local/list-local/list-local.component';
import { GetLocalComponent } from './Components/local/get-local/get-local.component';
import { AddPotComponent } from './Components/pot/add-pot/add-pot.component';
import { ModifyPotComponent } from './Components/pot/modify-pot/modify-pot.component';
import { DeletePotComponent } from './Components/pot/delete-pot/delete-pot.component';
import { ListPotComponent } from './Components/pot/list-pot/list-pot.component';
import { GetPotComponent } from './Components/pot/get-pot/get-pot.component';


@NgModule({
  declarations: [
    AppComponent,
    AddDonationComponent,
    ModifyDonationComponent,
    DeleteDonationComponent,
    ListDonationComponent,
    GetDonationComponent,
    AddEventComponent,
    ModifyEventComponent,
    DeleteEventComponent,
    ListEventComponent,
    GetEventComponent,
    AddLocalComponent,
    ModifyLocalComponent,
    DeleteLocalComponent,
    ListLocalComponent,
    GetLocalComponent,
    AddPotComponent,
    ModifyPotComponent,
    DeletePotComponent,
    ListPotComponent,
    GetPotComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule,
    NgbModalModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
