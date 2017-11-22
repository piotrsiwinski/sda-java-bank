import {NgModule, NO_ERRORS_SCHEMA } from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {MyFinancesComponent} from './my-finances/my-finances.component';
import {NewTransactionComponent} from './new-transaction/new-transaction.component';
import {HistoryComponent} from './history/history.component';
import {SettingsComponent} from './settings/settings.component';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { MDBBootstrapModule } from 'angular-bootstrap-md';

@NgModule({
  imports: [
    CommonModule,
    MatInputModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
    MDBBootstrapModule.forRoot()
  ],
  schemas: [ NO_ERRORS_SCHEMA ],
  exports: [LoginComponent, RegisterComponent],
  declarations: [LoginComponent, RegisterComponent, MyFinancesComponent, NewTransactionComponent, HistoryComponent, SettingsComponent]
})
export class BankModule {
}

