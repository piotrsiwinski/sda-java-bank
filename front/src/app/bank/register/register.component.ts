import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RegisterService} from "./register.service";
import {RegisterModel} from "./RegisterModel";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
 registerModel: RegisterModel;

  error: string;
  constructor() {
  constructor(private router: Router,
              private registerService: RegisterService) {
  }

  ngOnInit() {
  }
  onSubmit = function (a) {
    console.log(a);
  }

  onClick() {
    this.register();
  }

  register() {
    this.registerModel = {
      firstName: 'qwe',
      lastName: 'asd',
      email: 'qwe@asd.pl',
      password: 'qwerty'
    };

    this.registerService.register(this.registerModel)
      .subscribe(data => {
          console.log(data);
          this.router.navigate(['/']);
        },
        error => {
          console.log(error);
        });
  }
}
