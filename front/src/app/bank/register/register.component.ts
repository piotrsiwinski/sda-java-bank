import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  error: string;
  constructor() {
  }

  ngOnInit() {
  }
  onSubmit = function (a) {
    console.log(a);
  }

}
