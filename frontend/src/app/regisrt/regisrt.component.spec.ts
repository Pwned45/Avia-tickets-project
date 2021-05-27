import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisrtComponent } from './regisrt.component';

describe('RegisrtComponent', () => {
  let component: RegisrtComponent;
  let fixture: ComponentFixture<RegisrtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisrtComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisrtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
