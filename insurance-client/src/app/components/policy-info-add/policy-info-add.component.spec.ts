import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicyInfoAddComponent } from './policy-info-add.component';

describe('PolicyInfoAddComponent', () => {
  let component: PolicyInfoAddComponent;
  let fixture: ComponentFixture<PolicyInfoAddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PolicyInfoAddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PolicyInfoAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
