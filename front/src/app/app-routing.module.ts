import { NgModule }              from '@angular/core';
import { RouterModule, Routes }  from '@angular/router';
import {PageNotFoundComponent} from "./page-not-found/page-not-found.component";
import {LoginComponent} from "./bank/login/login.component";
import {RegisterComponent} from "./bank/register/register.component";
import {SettingsComponent} from "./bank/settings/settings.component";
import {NewTransactionComponent} from "./bank/new-transaction/new-transaction.component";
import {MyFinancesComponent} from "./bank/my-finances/my-finances.component";
import {HistoryComponent} from "./bank/history/history.component";

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home',       component: HomeComponent },
  { path: 'login',  component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'settings',     component: SettingsComponent },
  { path: 'new-transaction',     component: NewTransactionComponent },
  { path: 'my-finances',     component: MyFinancesComponent },
  { path: 'history',     component: HistoryComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
