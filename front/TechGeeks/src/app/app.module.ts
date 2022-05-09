import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModal, NgbModalModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { RouterModule } from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './components/shared/not-found/not-found.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { ListDonationComponent } from './components/donation/list-donation/list-donation.component';
import { AddDonationComponent } from './components/donation/add-donation/add-donation.component';
import { ListEventComponent } from './components/event/list-event/list-event.component';
import { AddEventComponent } from './components/event/add-event/add-event.component';
import { AddPotComponent } from './components/pot/add-pot/add-pot.component';
import { ListPotComponent } from './components/pot/list-pot/list-pot.component';
import { ListLocalComponent } from './components/local/list-local/list-local.component';
import { AddLocalComponent } from './components/local/add-local/add-local.component';
import { MyDonationsComponent } from './components/donation/my-donations/my-donations.component';
import { AddMyDonationComponent } from './components/donation/add-my-donation/add-my-donation.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ListDonationComponent,
    AddDonationComponent,
    ListEventComponent,
    AddEventComponent,
    AddPotComponent,
    ListPotComponent,
    ListLocalComponent,
    AddLocalComponent,
    MyDonationsComponent,
    AddMyDonationComponent
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
