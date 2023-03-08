import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { TODOList } from 'src/app/models/todo-list';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';
import { TodoListService } from 'src/app/services/todo-list/todo-list.service';
import { TodoListFormComponent } from '../todo-list-form/todo-list-form.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {

  todoLists: TODOList[]

  constructor(public dialog: MatDialog, private todoListService: TodoListService, private todoItemService: TodoItemService, private router: Router) {
    this.todoLists = todoListService.getAll()
  }

  openDialog() {
    const dialogRef = this.dialog.open(TodoListFormComponent);
  }

  setListId(id: number){
    this.todoItemService.setListId(id)
    this.router.navigateByUrl('')
  }
}
