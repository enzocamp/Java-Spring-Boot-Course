import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchLotterySweepstakesComponent } from './search-lottery-sweepstakes.component';

describe('SearchLotterySweepstakesComponent', () => {
  let component: SearchLotterySweepstakesComponent;
  let fixture: ComponentFixture<SearchLotterySweepstakesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchLotterySweepstakesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchLotterySweepstakesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
