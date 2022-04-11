import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewalldocComponent } from './viewalldoc.component';

describe('ViewalldocComponent', () => {
  let component: ViewalldocComponent;
  let fixture: ComponentFixture<ViewalldocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewalldocComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewalldocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
