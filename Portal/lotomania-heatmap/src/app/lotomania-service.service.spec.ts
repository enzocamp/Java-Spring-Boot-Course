import { TestBed } from '@angular/core/testing';

import { LotomaniaServiceService } from './lotomania-service.service';

describe('LotomaniaServiceService', () => {
  let service: LotomaniaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LotomaniaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
