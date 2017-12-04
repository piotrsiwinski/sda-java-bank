import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NewAccountService} from "./new-account.service";

@Component({
  selector: 'new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.scss']
})
export class NewAccountComponent implements OnInit {
  account: FormGroup;

  constructor(private builder: FormBuilder,
              private service: NewAccountService) {
  }

  ngOnInit() {
    this.account = this.builder.group({
      accountType: ['', Validators.required],
      account: ['', Validators.required],
      amount: ['', Validators.required]
    });
  }

  onSubmit(data: any) {
    console.log(JSON.stringify(data, null, 2));
    this.service.createAccount(data)
      .subscribe(data => {
        console.log(JSON.stringify(data, null, 2));
      })
  }

}
