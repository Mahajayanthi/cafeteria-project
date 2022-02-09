import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { UpdateCanteenComponent } from './update-canteen.component';

describe('UpdateCanteenComponent', () => {
  let component: UpdateCanteenComponent;
  let fixture: ComponentFixture<UpdateCanteenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateCanteenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCanteenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
