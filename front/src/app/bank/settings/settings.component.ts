import { Component, OnInit } from '@angular/core';
import {UserModel} from "../model/UserModel";


@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  userData: UserModel;
  constructor() { }

  ngOnInit() {
    this.userData = {
      firstName: 'Jan',
      lastName: 'Nowak',
      email: 'test@wp.pl'
    };
  }

}
