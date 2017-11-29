import {Injectable} from "@angular/core";

@Injectable()
export class AuthService {

  private sessionKey = 'session';

  public isAuthenticated(): Boolean {
    return localStorage.getItem(this.sessionKey) !== null;
  }

  public getSessionId(): String{
    return localStorage.getItem(this.sessionKey);
  }
}
