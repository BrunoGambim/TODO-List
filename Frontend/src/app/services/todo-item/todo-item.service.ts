import { Injectable } from '@angular/core';
import { TODOItem } from 'src/app/models/todo-item';
import { Observable, Subject } from 'rxjs';

const ITEM_DATA: TODOItem[][] = [[
  {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"easy"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "medium", status: "in progress", difficulty:"moderate"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"}
],[
  {name: "Lorem ipsum dolor sit amet2",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"easy"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "medium", status: "in progress", difficulty:"moderate"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"}
],[
  {name: "Lorem ipsum dolor sit amet3",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"easy"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "medium", status: "in progress", difficulty:"moderate"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"}
],[
  {name: "Lorem ipsum dolor sit amet4",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"easy"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "medium", status: "in progress", difficulty:"moderate"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"}
],[
  {name: "Lorem ipsum dolor sit amet5",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"easy"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "high", status: "todo", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "medium", status: "in progress", difficulty:"moderate"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"},
   {name: "Lorem ipsum dolor sit amet",
   description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam feugiat massa ut faucibus blandit. Etiam libero nibh, congue ut lorem at, varius mattis nisi. Sed sagittis elit sit amet fringilla molestie. Suspendisse blandit vitae mi eu mollis. Nam id elementum ante, ut aliquet odio. Nam non mi urna. Nullam ornare augue ut risus rutrum tristique.",
   priority: "low", status: "done", difficulty:"hard"}
]];

@Injectable({
  providedIn: 'root'
})
export class TodoItemService {

  todoItems: Subject<Observable<TODOItem[]>>

  constructor() {
    this.todoItems = new Subject<Observable<TODOItem[]>>()
  }

  getItems() {
    return new Observable<TODOItem[]>( subscriber => subscriber.next(ITEM_DATA[0]))
  }

  getUpdates() {
    return this.todoItems
  }

  setListId(id: number) {
    this.todoItems.next(new Observable<TODOItem[]>( subscriber => subscriber.next(ITEM_DATA[id])))
  }
}
