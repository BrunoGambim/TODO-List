import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';
import { CreateTodoItemFormComponent } from '../create-todo-item-form/create-todo-item-form.component';
import { Observable } from 'rxjs';
import { EditTodoItemFormComponent } from '../edit-todo-item-form/edit-todo-item-form.component';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {
  displayedColumns: string[] = ['name', 'description',  'priority', 'status', 'difficulty', 'edit'];
  dataSource: Observable<TODOItem[]>

  constructor(public dialog: MatDialog, private todoItemService: TodoItemService) {
    this.dataSource = todoItemService.getItems()

    todoItemService.getUpdates().subscribe( todoItems => {
      this.dataSource = todoItems
    })
  }

  openEditDialog(item: TODOItem) {
    const dialogRef = this.dialog.open(EditTodoItemFormComponent,{
      data: item
    });
  }

  openCreateDialog() {
    const dialogRef = this.dialog.open(CreateTodoItemFormComponent);
  }
}
