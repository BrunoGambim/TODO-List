import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TODOList } from 'src/app/models/todo-list';
import { TodoListService } from 'src/app/services/todo-list/todo-list.service';

@Component({
  selector: 'app-create-todo-list-form',
  templateUrl: './create-todo-list-form.component.html',
  styleUrls: ['./create-todo-list-form.component.css']
})
export class CreateTodoListFormComponent {
  list: TODOList = {"id": 0, "name": ""}
  constructor(private todoListService: TodoListService, public dialogRef: MatDialogRef<CreateTodoListFormComponent>) {

  }

  save() {
    this.todoListService.save(this.list)
    this.dialogRef.close()
  }
}
