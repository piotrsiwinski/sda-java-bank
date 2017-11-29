import { Injectable } from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {AuthService} from "../bank/auth/auth.service";


@Injectable()
export class CanActivateViaAuthGuard implements CanActivate {

  constructor(private auth: AuthService, private router: Router){}
  canActivate() {

    if (!this.auth.isAuthenticated()) {
      this.router.navigate(['/login']);
      return false;
    }
    return true;
  }
}


