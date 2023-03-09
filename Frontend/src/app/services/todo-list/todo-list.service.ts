import { Injectable } from '@angular/core';
import { TODOList } from '../../models/todo-list';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';


const LIST_DATA: TODOList[] = [{'id': 0 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 1 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 2 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 3 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 4 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'}]

@Injectable({
  providedIn: 'root'
})
export class TodoListService {

  private readonly API = "http://localhost:8080/v1/todo_lists"
  todoLists: Subject<Observable<TODOList[]>>

  constructor(private httpClient: HttpClient) {
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
    this.httpClient.post(this.API, {"name": todoList.name}).subscribe(
    res => {
      this.tryUpdate()
    })
  }
}
