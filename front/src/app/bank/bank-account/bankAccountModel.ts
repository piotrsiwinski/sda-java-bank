export class bankAccountModel{
  accountNumber;
  balance;
  accountType: any;

  constructor(accountNumber, balance, accountType){
    this.accountNumber = accountNumber;
    this.balance = balance;
    this.accountType = accountType;
  }
}
