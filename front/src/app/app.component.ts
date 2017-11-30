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
  }

  private getUserData() {
    this.authService.getUserDetails().subscribe(data => {
      console.log(data);
      this.loggedUser = {firstName: 'test', lastName: '123', email: 'email@wp.pl'};
    })
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  ngDoCheck() {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

  logout() {
    this.authService.logout();
    this.loggedUser = null;
    this.router.navigate(['/login']);

  }

}
