import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "./login.service";


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  loginForms: FormGroup;

  constructor(private builder: FormBuilder, private service: LoginService) {
  }

  ngOnInit(): void {
    this.loginForms = this.builder.group({
      login: ['', Validators.required],
      password: ['', Validators.required],
    });
  }


  onSubmit = function (formData) {
    console.log(formData);
    this.service
      .login(formData)
      .subscribe(
        resp => console.log(JSON.stringify(resp, null, 2)),
          err => console.log(JSON.stringify(err, null, 2)));
  }

}

