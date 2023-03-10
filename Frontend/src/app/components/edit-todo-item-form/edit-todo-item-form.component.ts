import { Component, Inject } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';

@Component({
  selector: 'app-edit-todo-item-form',
  templateUrl: './edit-todo-item-form.component.html',
  styleUrls: ['./edit-todo-item-form.component.css']
})
export class EditTodoItemFormComponent {

  editTodoItemForm:FormGroup

  constructor(private todoItemService: TodoItemService,
    public dialogRef: MatDialogRef<EditTodoItemFormComponent>,
    @Inject(MAT_DIALOG_DATA) private item: TODOItem) {
      this.editTodoItemForm = new FormGroup({
        name: new FormControl(item.name, Validators.required),
        description: new FormControl(item.description, Validators.required),
        priority: new FormControl(item.priority, Validators.required),
        difficulty: new FormControl(item.difficulty, Validators.required),
        status: new FormControl(item.status, Validators.required),
      });
  }

  update() {
    let name = this.editTodoItemForm.controls['name'].getRawValue()
    let description = this.editTodoItemForm.controls['description'].getRawValue()
    let priority = this.editTodoItemForm.controls['priority'].getRawValue()
    let status = this.editTodoItemForm.controls['status'].getRawValue()
    let difficulty = this.editTodoItemForm.controls['difficulty'].getRawValue()
    if(name != null && description != null && priority != null && status != null && difficulty != null){
      let item:TODOItem = {id: this.item.id, name: name, description: description, difficulty: difficulty, priority: priority, status: status}
      this.todoItemService.update(item)
      this.dialogRef.close()
    }
  }

  deleteItem() {
    this.todoItemService.delete(this.item.id)
    this.dialogRef.close()
  }
}
