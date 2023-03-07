import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { TodoListFormComponent } from './todo-list-form/todo-list-form.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Frontend';

  constructor(public dialog: MatDialog) {}

  openDialog() {
    const dialogRef = this.dialog.open(TodoListFormComponent);
  }
}
