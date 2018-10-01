import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomCategoriesListComponent } from './room-categories-list.component';

describe('RoomCategoriesListComponent', () => {
  let component: RoomCategoriesListComponent;
  let fixture: ComponentFixture<RoomCategoriesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomCategoriesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomCategoriesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
