import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BrasketComponent } from './brasket.component';

describe('BrasketComponent', () => {
  let component: BrasketComponent;
  let fixture: ComponentFixture<BrasketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BrasketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BrasketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
