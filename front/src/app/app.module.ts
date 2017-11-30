import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {AppComponent} from './app.component';
import {BankModule} from "./bank/bank.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {AppRoutingModule} from "./app-routing.module";
import {MatButtonModule, MatIconModule, MatListModule, MatSidenavModule, MatToolbarModule} from "@angular/material";
import {RegisterService} from "./bank/register/register.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginService} from "./bank/login/login.service";
import {AuthService} from "./bank/auth/auth.service";
import {CanActivateViaAuthGuard} from "./common/activate-guard";
import {NewTransactionService} from "./bank/new-transaction/new-transaction.service";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
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
  providers: [RegisterService, LoginService, AuthService, CanActivateViaAuthGuard, NewTransactionService],
  bootstrap: [AppComponent],
  schemas: [ NO_ERRORS_SCHEMA ]
})
export class AppModule {
}
