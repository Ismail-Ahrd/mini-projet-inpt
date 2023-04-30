import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrelevementComponent } from './prelevement.component';

describe('PrelevementComponent', () => {
  let component: PrelevementComponent;
  let fixture: ComponentFixture<PrelevementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrelevementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrelevementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
