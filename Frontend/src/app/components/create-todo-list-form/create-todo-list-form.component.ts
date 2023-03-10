import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
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

  createTodoListForm = new FormGroup({
    name: new FormControl('', Validators.required),
  });

  constructor(private todoListService: TodoListService, public dialogRef: MatDialogRef<CreateTodoListFormComponent>) {

  }

  save() {
    let name = this.createTodoListForm.controls.name.getRawValue()
    if(name != null){
      let list: TODOList = {id: 0, name: name}
      this.todoListService.save(list)
      this.dialogRef.close()
    }
  }
}
