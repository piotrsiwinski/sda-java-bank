import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {MyFinancesComponent} from './my-finances/my-finances.component';
import {NewTransactionComponent} from './new-transaction/new-transaction.component';
import {HistoryComponent} from './history/history.component';
import {SettingsComponent} from './settings/settings.component';
import {MatInputModule} from '@angular/material/input';

@NgModule({
  imports: [
    CommonModule,
    MatInputModule
  ],
  exports: [LoginComponent, RegisterComponent],
  declarations: [LoginComponent, RegisterComponent, MyFinancesComponent, NewTransactionComponent, HistoryComponent, SettingsComponent]
})
export class BankModule {
}

