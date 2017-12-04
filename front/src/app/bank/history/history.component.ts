import {Component, OnInit} from '@angular/core';
import {HistoryModel} from "../model/HistoryModel";

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  history: HistoryModel[];

  constructor() { }

  ngOnInit() {
    this.history = [
      {
        date: '22.12.2017',
        descrption: 'SQ Club - płatnosć kartą',
        amount: '1 941,88 zł',
        amountAfter: '3 2204 zł'
      },
      {
        date: '12.12.2017',
        descrption: 'Lidl Poznań - płatnosć kartą',
        amount: '75,99 zł',
        amountAfter: '2 9234 zł'
      },
      {
        date: '07.12.2017',
        descrption: 'Żabka Poznań - płatnosć kartą',
        amount: '31,12 zł',
        amountAfter: '2 1234 zł'
      }
    ]
  }

}
