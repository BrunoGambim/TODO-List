import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';

@Component({
  selector: 'app-create-todo-item-form',
  templateUrl: './create-todo-item-form.component.html',
  styleUrls: ['./create-todo-item-form.component.css']
})
export class CreateTodoItemFormComponent {

  createTodoItemForm = new FormGroup({
    name: new FormControl('', Validators.required),
    description: new FormControl('', Validators.required),
    priority: new FormControl('', Validators.required),
    difficulty: new FormControl('', Validators.required),
    status: new FormControl('', Validators.required),
  });

  constructor(private todoItemService: TodoItemService, public dialogRef: MatDialogRef<CreateTodoItemFormComponent>) {

  }

  save() {
    let name = this.createTodoItemForm.controls.name.getRawValue()
    let description = this.createTodoItemForm.controls.description.getRawValue()
    let priority = this.createTodoItemForm.controls.priority.getRawValue()
    let status = this.createTodoItemForm.controls.status.getRawValue()
    let difficulty = this.createTodoItemForm.controls.difficulty.getRawValue()
    if(name != null && description != null && priority != null && status != null && difficulty != null){
      let item:TODOItem = {id: 0, name: name, description: description, difficulty: difficulty, priority: priority, status: status}
      this.todoItemService.save(item)
      this.dialogRef.close()
    }
  }
}
