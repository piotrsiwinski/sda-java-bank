import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map'
import {bankAccountModel} from "./bankAccountModel";

@Injectable()
export class bankAccountService {

  constructor(private http: HttpClient) { }

  account(account: bankAccountModel) {
    console.log(account);
    return this.http
      .get('http://localhost:8080/api/v1/bank/account/all',{withCredentials: true});
  }

}
