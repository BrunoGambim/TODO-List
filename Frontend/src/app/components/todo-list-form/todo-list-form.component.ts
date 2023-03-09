import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TODOList } from 'src/app/models/todo-list';
import { TodoListService } from 'src/app/services/todo-list/todo-list.service';

@Component({
  selector: 'app-todo-list-form',
  templateUrl: './todo-list-form.component.html',
  styleUrls: ['./todo-list-form.component.css']
})
export class TodoListFormComponent {
  list: TODOList = {"id": 0, "name": ""}
  constructor(private todoListService: TodoListService, public dialogRef: MatDialogRef<TodoListFormComponent>) {

  }

  save() {
    this.todoListService.save(this.list)
    this.dialogRef.close()
  }
}
