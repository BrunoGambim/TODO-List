import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { TODOItem } from 'src/app/models/todo-item';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';
import { TodoItemFormComponent } from '../todo-item-form/todo-item-form.component';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {
  displayedColumns: string[] = ['name', 'description',  'priority', 'status', 'difficulty'];
  dataSource: Observable<TODOItem[]>

  constructor(public dialog: MatDialog, private todoItemService: TodoItemService) {
    this.dataSource = todoItemService.getItems()

    todoItemService.getUpdates().subscribe( todoItems => {
      this.dataSource = todoItems
    })
  }

  openDialog() {
    const dialogRef = this.dialog.open(TodoItemFormComponent);
  }
}
