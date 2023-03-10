import { Injectable } from '@angular/core';
import { TODOList } from '../../models/todo-list';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
import { TodoItemService } from '../todo-item/todo-item.service';

@Injectable({
  providedIn: 'root'
})
export class TodoListService {

  private readonly API = "http://localhost:8080/v1/todo_lists"
  todoLists: Subject<Observable<TODOList[]>>

  constructor(private httpClient: HttpClient, private todoItemService: TodoItemService) {
    this.todoLists = new Subject<Observable<TODOList[]>>()
  }

  getAll(){
    return this.httpClient.get<TODOList[]>(this.API)
  }

  getUpdates() {
    return this.todoLists
  }

  tryUpdate() {
    this.todoLists.next(this.httpClient.get<TODOList[]>(this.API))
  }

  save(todoList: TODOList) {
    this.httpClient.post(this.API, todoList).subscribe(
    res => {
      this.tryUpdate()
    })
  }

  update(todoList: TODOList) {
    this.httpClient.put(this.API +"/"+ todoList.id, todoList).subscribe(
    res => {
      this.tryUpdate()
    })
  }

  delete(todoList: TODOList) {
    return this.httpClient.delete(this.API +"/"+ todoList.id).subscribe(
    res => {
      this.tryUpdate()
      this.todoItemService.resetItems()
    })
  }
}
