import {Component, DoCheck, NgModule, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {AuthService} from "./bank/auth/auth.service";
import {UserModel} from "./bank/model/UserModel";
import {Router} from "@angular/router";

@NgModule({
    imports: [MatButtonModule, MatCheckboxModule],
})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnChanges, DoCheck {

  loggedUser: UserModel;
  title = 'app';
  isLoggedIn: Boolean = false;

  constructor(private authService: AuthService, private router: Router) {
  };

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isAuthenticated();
    this.loggedUser = {
      firstName: 'Jan',
      lastName: 'Kowalski',
      email: 'test@wp.pl',
    };
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  ngDoCheck() {
    console.log("APP COMPONENT ngDoCheck");
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);

  }

}
