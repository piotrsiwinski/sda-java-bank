import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {error} from "util";

@Injectable()
export class NewTransactionService {

  baseURL = 'http://localhost:8080/api/v1';

  constructor(private http: HttpClient) {
  }

  doTransaction(formData): any {

    var account = formData.account;
    var destinationAccount  = formData.destinationAccount;
    var addressInfo = formData.addressInfo;
    var amount = formData.amount;
    var title = formData.title;

    let params = new HttpParams()
      .set("account", account)
      .set("destinationAccount", destinationAccount)
      .set("addressInfo", addressInfo)
      .set("amount", amount)
      .set("title", title)

    return this.http.post(this.baseURL, {params: params}, {observe: 'response'}).subscribe(
      response => {
        console.log(response.status);
      }
    );
  }


}
