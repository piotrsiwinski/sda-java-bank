import { Component, OnInit } from '@angular/core';
import {RegisterService} from "./register.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  constructor(private registerService: RegisterService, private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
  }

}
