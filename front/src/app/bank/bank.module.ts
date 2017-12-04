import {NgModule, NO_ERRORS_SCHEMA, OnInit, Pipe} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {MyFinancesComponent} from './my-finances/my-finances.component';
import {NewTransactionComponent} from './new-transaction/new-transaction.component';
import {HistoryComponent} from './history/history.component';
import {SettingsComponent} from './settings/settings.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {CdkTableModule} from '@angular/cdk/table';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatAutocompleteModule,
  MatButtonModule,
  MatButtonToggleModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDatepickerModule,
  MatDialogModule,
  MatExpansionModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatNativeDateModule,
  MatPaginatorModule,
  MatProgressBarModule,
  MatProgressSpinnerModule,
  MatRadioModule,
  MatRippleModule,
  MatSelectModule,
  MatSliderModule,
  MatSlideToggleModule,
  MatSnackBarModule,
  MatSortModule,
  MatTableModule,
  MatTabsModule,
  MatToolbarModule,
  MatTooltipModule,
  MatStepperModule,
} from '@angular/material';
import {MatSidenavModule} from '@angular/material/sidenav';
import {FormsModule, ReactiveFormsModule,} from '@angular/forms';
import {HttpModule} from "@angular/http";
import {TransferComponent} from "../transfer/transfer.component";
import {NewAccountComponent} from "../new-account/new-account.component";

@NgModule({
  imports: [
    HttpModule,
    FormsModule,
    MatSidenavModule,
    CommonModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule,
    MDBBootstrapModule.forRoot(),
    MatCheckboxModule,
    MatTabsModule,
    BrowserModule,
    BrowserAnimationsModule,
    CdkTableModule,
    MatAutocompleteModule,
    MatButtonModule,
    MatButtonToggleModule,
    MatCardModule,
    MatCheckboxModule,
    MatChipsModule,
    MatStepperModule,
    MatDatepickerModule,
    MatDialogModule,
    MatExpansionModule,
    MatGridListModule,
    MatIconModule,
    MatInputModule,
    MatListModule,
    MatMenuModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatProgressBarModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatRippleModule,
    MatSelectModule,
    MatSidenavModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatSnackBarModule,
    MatSortModule,
    MatTableModule,
    MatTabsModule,
    MatToolbarModule,
    MatTooltipModule,
    FormsModule,
    ReactiveFormsModule,

  ],
  schemas: [NO_ERRORS_SCHEMA],
  exports: [LoginComponent, RegisterComponent, MyFinancesComponent, NewTransactionComponent, HistoryComponent, SettingsComponent, TransferComponent, NewAccountComponent],
  declarations: [LoginComponent, RegisterComponent, MyFinancesComponent, NewTransactionComponent, HistoryComponent, SettingsComponent, TransferComponent,NewAccountComponent]

})
export class BankModule {
}

