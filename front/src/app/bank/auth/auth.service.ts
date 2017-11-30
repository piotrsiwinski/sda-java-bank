import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AuthService {

  apiUrl = "http://localhost:8080/logout";

  constructor(private http: HttpClient) {

  }

  private sessionKey = 'session';

  public isAuthenticated(): Boolean {
    return localStorage.getItem(this.sessionKey) !== null;
  }

  public getSessionId(): String{
    return localStorage.getItem(this.sessionKey);
  }

  public logout() {
    localStorage.removeItem(this.sessionKey);
    return this.http.post(this.apiUrl, null);
  }

}
