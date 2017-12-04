import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class NewAccountService{
  constructor(private http: HttpClient){}

  createAccount(data){
    let headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http
      .post("http://localhost:8080/api/v1/bank/account/create",
        JSON.stringify(data),
        {withCredentials: true, headers: headers});
  }
}
