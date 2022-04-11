import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Userapplication2Component } from './userapplication2.component';

describe('Userapplication2Component', () => {
  let component: Userapplication2Component;
  let fixture: ComponentFixture<Userapplication2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Userapplication2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Userapplication2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
