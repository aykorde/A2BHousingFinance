import { TestBed } from '@angular/core/testing';

import { UserapplicationserviceService } from './userapplicationservice.service';

describe('UserapplicationserviceService', () => {
  let service: UserapplicationserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UserapplicationserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
