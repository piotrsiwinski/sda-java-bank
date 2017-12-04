import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {RegisterService} from "./register.service";
import {RegisterModel} from "./RegisterModel";
import {AbstractControl, FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerModel: RegisterModel;
  registerForms: FormGroup;

  error: string;

  emailRegex = '^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$';

  constructor(private router: Router, private registerService: RegisterService, private builder: FormBuilder) {
  }

  ngOnInit(): void {
    this.registerForms = this.builder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      email: ['', Validators.compose([Validators.required, Validators.pattern(this.emailRegex)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(8)])],
      passwordRepeat: ['', Validators.required],
      pesel: ['', Validators.compose([Validators.minLength(11), Validators.maxLength(11)])],
      regulations: [false, Validators.requiredTrue]
    }, {validator: this.passwordConfirming});
  }

  passwordConfirming(p: AbstractControl): { invalid: boolean } {
    if (p.get('password').value !== p.get('passwordRepeat').value) {
      return {invalid: true};
    }
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
