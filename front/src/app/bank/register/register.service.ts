import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map'

@Injectable()
export class RegisterService {
  email: string;
  password: string;

  constructor(private http: HttpClient) { }

  register(email: string, password: string) {
    return this.http.post('/api/authenticate', JSON.stringify({ email: email, password: password }))
      .map((response: Response) => {
        console.log("register success");
      });
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
}
