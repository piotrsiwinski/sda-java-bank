import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { RouterOutlet } from '@angular/router';
import {AppComponent} from './app.component';
import {BankModule} from "./bank/bank.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatInputModule} from '@angular/material/input';
import {AppRoutingModule} from "./app-routing.module";
import {MatButtonModule, MatIconModule, MatListModule, MatSidenavModule, MatToolbarModule} from "@angular/material";
import {RegisterService} from "./bank/register/register.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    MatSidenavModule,
    BrowserModule,
    BankModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    HttpClientModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule, MatIconModule, MatListModule, MatSidenavModule,

  ],
  providers: [RegisterService],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]
})
export class AppModule {
}
