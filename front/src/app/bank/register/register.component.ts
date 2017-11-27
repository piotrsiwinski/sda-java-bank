import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RegisterService} from "./register.service";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  loading = false;

  constructor(private router: Router,
              private registerService: RegisterService) {
  }

  ngOnInit() {
    this.registerService.logout();
  }

  onClick() {
    this.register();
  }

  register() {
    this.loading = true;
    this.registerService.register(this.registerService.email, this.registerService.password)
      .subscribe(
        data => {
          console.log(data);
          this.router.navigate(['/']);
        },
        error => {
          console.log(error);
          this.loading = false;
        });
  }
}
