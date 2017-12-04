import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {LoginService} from "../bank/login/login.service";
import {TransferService} from "./transfer.service";
import {UserService} from "../bank/user/user.service";

@Component({
  selector: 'transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss']
})
export class TransferComponent implements OnInit {
  depositFrom: FormGroup;

  constructor(private builder: FormBuilder,
              private service: LoginService,
              private router: Router,
              private transferService: TransferService,
              private userService: UserService) {

  }

  ngOnInit() {
    this.depositFrom = this.builder.group({
      account: ['', Validators.required],
      amount: ['', Validators.required],
    });
  }

  onSubmit(formData) {
    console.log(JSON.stringify(formData, null, 2));

    this.transferService.createTransfer(formData)
      .subscribe(data => {
        console.log(JSON.stringify(data, null, 2));
      }, err => {
        console.log(JSON.stringify(err, null, 2));
      });
  }

}
