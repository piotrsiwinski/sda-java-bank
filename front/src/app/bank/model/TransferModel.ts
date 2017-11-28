export class TranferModel {
  account;
  adressInfo;
  amount;
  title;
  date;

  constructor(account, adressInfo, amount, title, date) {
    this.account = account;
    this.adressInfo = adressInfo;
    this.amount = amount;
    this.title = title;
    this.date = date;
  }
}
