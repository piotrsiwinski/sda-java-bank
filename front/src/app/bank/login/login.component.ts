import { Component, OnInit } from '@angular/core';
import {LoginService} from "./login.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

}
