import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {NewTransactionService} from "./new-transaction.service";

@Component({
  selector: 'new-transaction',
  templateUrl: './new-transaction.component.html',
  styleUrls: ['./new-transaction.component.scss']
})
export class NewTransactionComponent implements OnInit {

  transactionForm: FormGroup;

  constructor(private builder: FormBuilder, private service: NewTransactionService){
  }

  ngOnInit(): void {
    this.transactionForm = this.builder.group({
      amount: ['', Validators.required],
      addressInfo: ['', Validators.required],
      account: ['', Validators.required],
      destinationAccount: ['', Validators.required],
      title: ['', Validators.required],
    });
  }


  onSubmit(formData) {
    if (this.transactionForm.valid){
      console.log("Form data: " + formData);
      this.service.doTransaction(formData);
    }
    console.log("Invalid input");
  }


}
