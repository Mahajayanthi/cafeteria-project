import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateCanteenComponent } from './create-canteen.component';

describe('CreateCanteenComponent', () => {
  let component: CreateCanteenComponent;
  let fixture: ComponentFixture<CreateCanteenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCanteenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCanteenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
