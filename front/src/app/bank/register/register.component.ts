import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RegisterService} from "./register.service";
import {RegisterModel} from "./RegisterModel";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerModel: RegisterModel;
  registerForms: FormGroup;

  error: string;

  constructor(private router: Router, private registerService: RegisterService, private builder: FormBuilder) {
  }

  ngOnInit(): void {
    this.registerForms = this.builder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      passwordRepeat: ['', Validators.required],
      pesel: ['', Validators.minLength(11)],
    });
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
          this.error = 'Podany użytkownik już istnieje';
        });
  }


}
