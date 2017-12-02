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
      regulations: [false, Validators.requiredTrue]
    });
  }

  onSubmit = function (formData) {
    console.log(`DATA: ${JSON.stringify(formData, null, 2)}`);
    console.log(`DATA: ${JSON.stringify(this.registerForms.value)}`);
    this.registerService.register(this.registerForms.value)
      .subscribe(response => {
          console.log(response);
          this.router.navigate(['/']);
        },
        error => {
          console.log(error);
          this.error = 'Podany użytkownik już istnieje';
        });
  }
}
