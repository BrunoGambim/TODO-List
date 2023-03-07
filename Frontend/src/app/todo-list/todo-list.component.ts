import { Component } from '@angular/core';

export interface TODOElement {
  name: string;
  description: string;
  priority: string;
  status: string;
  difficulty: string;
}

const ELEMENT_DATA: TODOElement[] = [
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
];

@Component({
  selector: 'app-todo-list',
  templateUrl: './todo-list.component.html',
  styleUrls: ['./todo-list.component.css']
})
export class TodoListComponent {
  displayedColumns: string[] = ['name', 'description',  'priority', 'status', 'difficulty'];
  dataSource = ELEMENT_DATA;
}
