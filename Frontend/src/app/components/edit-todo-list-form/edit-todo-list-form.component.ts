import { Component, Inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TODOList } from 'src/app/models/todo-list';
import { TodoListService } from 'src/app/services/todo-list/todo-list.service';

@Component({
  selector: 'app-edit-todo-list-form',
  templateUrl: './edit-todo-list-form.component.html',
  styleUrls: ['./edit-todo-list-form.component.css']
})
export class EditTodoListFormComponent {
  editTodoListForm: FormGroup

  constructor(private todoListService: TodoListService,
     public dialogRef: MatDialogRef<EditTodoListFormComponent>,
     @Inject(MAT_DIALOG_DATA) private list: TODOList) {
      this.editTodoListForm = new FormGroup({
        name: new FormControl(list.name, Validators.required),
      });
  }

  updateList() {
    let name = this.editTodoListForm.controls['name'].getRawValue()
    if(name != null){
      let list: TODOList = {id: this.list.id, name: name}
      this.todoListService.update(list)
      this.dialogRef.close()
    }
  }

  deleteList() {
    this.todoListService.delete(this.list)
    this.dialogRef.close()
  }
}
