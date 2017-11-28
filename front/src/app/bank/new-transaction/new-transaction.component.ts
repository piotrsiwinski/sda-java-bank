import { Component } from '@angular/core';

@Component({
  selector: 'new-transaction',
  templateUrl: './new-transaction.component.html',
  styleUrls: ['./new-transaction.component.scss']
})
export class NewTransactionComponent  {

  onSubmit = function (a) {
    console.log(a);
  }


}
