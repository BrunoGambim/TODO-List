import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TODOList } from 'src/app/models/todo-list';
import { TodoListService } from 'src/app/services/todo-list/todo-list.service';

@Component({
  selector: 'app-edit-todo-list-form',
  templateUrl: './edit-todo-list-form.component.html',
  styleUrls: ['./edit-todo-list-form.component.css']
})
export class EditTodoListFormComponent {
  constructor(private todoListService: TodoListService,
     public dialogRef: MatDialogRef<EditTodoListFormComponent>,
     @Inject(MAT_DIALOG_DATA) public list: TODOList) {
  }

  updateList() {
    this.todoListService.update(this.list)
    this.dialogRef.close()
  }

  deleteList() {
    this.todoListService.delete(this.list)
    this.dialogRef.close()
  }
}
