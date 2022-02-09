import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CanteenDetailsComponent } from './canteen-details.component';

describe('CanteenDetailsComponent', () => {
  let component: CanteenDetailsComponent;
  let fixture: ComponentFixture<CanteenDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CanteenDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CanteenDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
