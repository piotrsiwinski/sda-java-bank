import {Component, OnInit} from '@angular/core';
import {AuthService} from "../auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-my-finances',
  templateUrl: './my-finances.component.html',
  styleUrls: ['./my-finances.component.scss']
})
export class MyFinancesComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {

  }

  onAddAccount(){
    this.router.navigate(['/new-account'])
  }

}
