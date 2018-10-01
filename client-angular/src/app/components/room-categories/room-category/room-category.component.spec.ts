import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomCategoryComponent } from './room-category.component';

describe('RoomCategoryComponent', () => {
  let component: RoomCategoryComponent;
  let fixture: ComponentFixture<RoomCategoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomCategoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomCategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
