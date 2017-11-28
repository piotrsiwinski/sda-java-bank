import { TestBed, inject } from '@angular/core/testing';

import { NewTransactionService } from './new-transaction.service';

describe('NewTransactionService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [NewTransactionService]
    });
  });

  it('should be created', inject([NewTransactionService], (service: NewTransactionService) => {
    expect(service).toBeTruthy();
  }));
});
