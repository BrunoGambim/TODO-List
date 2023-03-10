import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTodoListFormComponent } from './edit-todo-list-form.component';

describe('EditTodoListFormComponent', () => {
  let component: EditTodoListFormComponent;
  let fixture: ComponentFixture<EditTodoListFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditTodoListFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditTodoListFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
