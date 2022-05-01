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

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    NavbarComponent,
    FooterComponent,
    HomeComponent,
    ListDonationComponent,
    AddDonationComponent
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
