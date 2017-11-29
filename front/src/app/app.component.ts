import {Component, NgModule, OnInit} from '@angular/core';
import {MatButtonModule, MatCheckboxModule} from '@angular/material';
import {AuthService} from "./bank/auth/auth.service";

@NgModule({
    imports: [MatButtonModule, MatCheckboxModule],
})

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'app';
  isLoggedIn: Boolean = false;

  constructor(private authService: AuthService) {
  };

  ngOnInit(): void {
    this.isLoggedIn = this.authService.isAuthenticated();
  }

}
