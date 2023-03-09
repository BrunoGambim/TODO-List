import { Injectable } from '@angular/core';
import { TODOItem } from 'src/app/models/todo-item';
import { mergeMap, Observable, Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { TODOList } from 'src/app/models/todo-list';

@Injectable({
  providedIn: 'root'
})
export class TodoItemService {

  private readonly API = "http://localhost:8080/v1/todo_lists"
  private todoItems: Subject<Observable<TODOItem[]>>
  private listId: number

  constructor(private httpClient: HttpClient) {
    this.todoItems = new Subject<Observable<TODOItem[]>>()
    this.listId = -1
  }

  getItems() {
    return this.httpClient.get<TODOList[]>(this.API)
    .pipe(mergeMap(lists => {
      this.listId = lists[0].id
      return this.httpClient.get<TODOItem[]>(this.API + "/" + lists[0].id + "/items")
    }))
  }


  getUpdates() {
    return this.todoItems
  }

  setListId(id: number) {
    this.listId = id
    this.todoItems.next(this.httpClient.get<TODOItem[]>(this.API + "/" + id + "/items"))
  }

  tryUpdate() {
    this.todoItems.next(this.httpClient.get<TODOItem[]>(this.API + "/" + this.listId + "/items"))
  }

  save(todoItem: TODOItem) {
    this.httpClient.post(this.API + "/" + this.listId + "/items", todoItem).subscribe(
    res => {
      this.tryUpdate()
    })
  }
}
