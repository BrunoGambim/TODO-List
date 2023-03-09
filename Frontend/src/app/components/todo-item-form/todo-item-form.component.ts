import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';

@Component({
  selector: 'app-todo-item-form',
  templateUrl: './todo-item-form.component.html',
  styleUrls: ['./todo-item-form.component.css']
})
export class TodoItemFormComponent {

  item: TODOItem = {"name": "", "description": "", "priority": "", "difficulty": "", "status":""}
  constructor(private todoItemService: TodoItemService, public dialogRef: MatDialogRef<TodoItemFormComponent>) {

  }

  save() {
    this.todoItemService.save(this.item)
    this.dialogRef.close()
  }
}
