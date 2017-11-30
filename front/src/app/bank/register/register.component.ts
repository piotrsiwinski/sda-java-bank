import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RegisterService} from "./register.service";
import {RegisterModel} from "./RegisterModel";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
 registerModel: RegisterModel;

  error: string;
  constructor(private router: Router,
              private registerService: RegisterService) {
  }

  onSubmit = function (data) {
    console.log(data);
    this.registerService.register(data)
      .subscribe(data => {
          console.log(data);
          this.router.navigate(['/']);
        },
        error => {
          console.log(error);
          this.error = 'Cant register';
        });
  }
}
