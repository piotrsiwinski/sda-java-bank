import {Injectable} from '@angular/core';

import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {
  }

  getAccess(email: string, password: string) {

    let body = new URLSearchParams();
    body.set('email', email);
    body.set('password', password);

    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };

    return this.http.post('//yourUrl.com/login', body.toString(), options);
  }
}
