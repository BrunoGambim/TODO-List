import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTodoItemFormComponent } from './edit-todo-item-form.component';

describe('EditTodoItemFormComponent', () => {
  let component: EditTodoItemFormComponent;
  let fixture: ComponentFixture<EditTodoItemFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditTodoItemFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditTodoItemFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
