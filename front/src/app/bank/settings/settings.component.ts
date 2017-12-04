import { Component, OnInit } from '@angular/core';
import {UserModel} from "../model/UserModel";
import {UserService} from "../user/user.service";


@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {

  userData: UserModel;
  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userData = {
      firstName: 'Jan',
      lastName: 'Nowak',
      email: 'test@wp.pl'
    };
    this.userService.getUserData().subscribe((data: any) => {
      this.userData = {
        firstName: data.firstName,
        lastName: data.lastName,
        email: data.email
      }
    });

  }

}
