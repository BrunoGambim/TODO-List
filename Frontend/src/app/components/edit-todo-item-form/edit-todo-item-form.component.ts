import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';

@Component({
  selector: 'app-edit-todo-item-form',
  templateUrl: './edit-todo-item-form.component.html',
  styleUrls: ['./edit-todo-item-form.component.css']
})
export class EditTodoItemFormComponent {


  constructor(private todoItemService: TodoItemService,
    public dialogRef: MatDialogRef<EditTodoItemFormComponent>,
    @Inject(MAT_DIALOG_DATA) public item: TODOItem) {

  }

  update() {
    this.todoItemService.update(this.item)
    this.dialogRef.close()
  }

  deleteItem() {
    this.todoItemService.delete(this.item.id)
    this.dialogRef.close()
  }
}
