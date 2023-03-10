import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';

@Component({
  selector: 'app-create-todo-item-form',
  templateUrl: './create-todo-item-form.component.html',
  styleUrls: ['./create-todo-item-form.component.css']
})
export class CreateTodoItemFormComponent {

  item: TODOItem = {"name": "", "description": "", "priority": "", "difficulty": "", "status":"", "id": 0}
  constructor(private todoItemService: TodoItemService, public dialogRef: MatDialogRef<CreateTodoItemFormComponent>) {

  }

  save() {
    this.todoItemService.save(this.item)
    this.dialogRef.close()
  }
}
