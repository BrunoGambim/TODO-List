import { Injectable } from '@angular/core';
import { TODOList } from '../../models/todo-list';


const LIST_DATA: TODOList[] = [{'id': 0 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 1 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 2 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 3 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'},
  {'id': 4 ,'name': 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'}]

@Injectable({
  providedIn: 'root'
})
export class TodoListService {

  constructor() {
  }

  getAll(){
    return LIST_DATA
  }
}
