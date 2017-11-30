import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";

@Injectable()
export class LoginService {

  baseURL = 'http://localhost:8080/login';

  constructor(private http: HttpClient) {

  }

  login(formData){

    let params = new HttpParams()
      .set("login", formData.login)
      .set("password", formData.password)
    let headers = new HttpHeaders().set('Content-type', 'application/x-www-form-urlencoded');
    const postData = `username=${encodeURIComponent(formData.login)}&password=${encodeURIComponent(formData.password)}&submit`;

    return this.http
      .post(this.baseURL, postData, {headers: headers, observe: 'response', responseType: 'text', withCredentials: true});
  }




}
