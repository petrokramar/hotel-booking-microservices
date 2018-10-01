import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FindingRoomComponent } from './finding-room.component';

describe('FindingRoomComponent', () => {
  let component: FindingRoomComponent;
  let fixture: ComponentFixture<FindingRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FindingRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FindingRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
