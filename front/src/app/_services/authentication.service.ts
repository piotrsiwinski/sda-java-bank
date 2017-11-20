import { Injectable } from '@angular/core';
import {Http, Headers, Response, URLSearchParams} from '@angular/http';
import 'rxjs/add/operator/map'
import {HttpClient} from "@angular/common/http";
import {HttpHeaders} from "@angular/common/http";
import {Router} from "@angular/router";

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient, private router: Router) {

  }

  login(email: string, password: string) {

    let options = {headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')};
    let body = new URLSearchParams();
    body.set('email', email);
    body.set('password', password);

    return this.http.post('http://localhost;8080/api/authenticate', body.toString(), options)
      .subscribe(res => {
        console.log(res);
        this.router.navigate(['/home']);
      }, err => {
        console.log("Error occured");
      });
  }

}
