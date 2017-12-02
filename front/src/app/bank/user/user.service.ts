import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class UserService {
  constructor(private http: HttpClient) {

  }

  getUserData() {
    // this.http.get("http://localhost:8080/api/v1/me", {withCredentials: true});
  }
}
