import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class TransferService {

  constructor(private http: HttpClient) {
  }

  public createTransfer(data: any) {
    let headers = new HttpHeaders()
      .set('Content-type', 'application/json')
      .set('Accept', 'application/json')
      .set('withCredentials', 'true');
    return this.http.post("http://localhost:8080/api/v1/deposit", data, {withCredentials: true, headers: headers});
  }

}
