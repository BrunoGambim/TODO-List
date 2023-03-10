import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EditTodoListFormComponent } from 'src/app/components/edit-todo-list-form/edit-todo-list-form.component';
import { TODOList } from 'src/app/models/todo-list';
import { TodoItemService } from 'src/app/services/todo-item/todo-item.service';
import { TodoListService } from 'src/app/services/todo-list/todo-list.service';
import { CreateTodoListFormComponent } from '../create-todo-list-form/create-todo-list-form.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
})
export class HeaderComponent {

  todoLists: TODOList[] = []

  constructor(public dialog: MatDialog, private todoListService: TodoListService, private todoItemService: TodoItemService) {
    todoListService.getAll().subscribe(todoLists => {
      this.todoLists = todoLists
    })
    todoListService.getUpdates().subscribe(observable => {
      observable.subscribe(todoLists => {
        this.todoLists = todoLists
      })
    })
  }

  openCreateDialog() {
    const dialogRef = this.dialog.open(CreateTodoListFormComponent);
  }

  openEditDialog() {
    let id = this.todoItemService.getListId()
    for(let list of this.todoLists){
      if(id == list.id) {
        const dialogRef = this.dialog.open(EditTodoListFormComponent, {data: list});
        break
      }
    }
  }

  setListId(id: number){
    this.todoItemService.setListId(id)
  }
}
