import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";

@Injectable()
export class LoginService {

  baseURL = 'http://localhost:8080/api/v1/login';

  constructor(private http: HttpClient) {

  }

  login(formData){

    let params = new HttpParams()
      .set("login", formData.login)
      .set("password", formData.password)

    return this.http.post(this.baseURL, {params: params}, {observe: 'response'}).subscribe(
      response => {
        console.log(response.status);
      }
    );
  }




}
