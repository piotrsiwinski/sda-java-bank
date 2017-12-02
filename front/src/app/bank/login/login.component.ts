import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginService} from "./login.service";
import {Router} from "@angular/router";


@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  loginForms: FormGroup;
  error: String;

  constructor(private builder: FormBuilder, private service: LoginService, private router: Router) {
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
        resp => {
          console.log(JSON.stringify(resp, null, 2));
          localStorage.setItem("session", 'true');
          this.router.navigate(['/my-finances']);
        },
        err => {
          this.error = "Błędny login lub hasło";
          console.log(JSON.stringify(err, null, 2))
        });
  }

}

