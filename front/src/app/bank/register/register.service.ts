import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map'
import {RegisterModel} from "./RegisterModel";

@Injectable()
export class RegisterService {

  constructor(private http: HttpClient) { }

  register(user: RegisterModel) {
    user.login = user.email;
    console.log(user);
    let headers = new HttpHeaders().set('Content-type', 'application/json');

    return this.http
      .post('http://localhost:8080/api/v1/register', user, {headers: headers});
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
}
