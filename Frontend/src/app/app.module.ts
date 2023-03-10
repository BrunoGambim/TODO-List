import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatMenuModule } from '@angular/material/menu';
import { TodoListComponent } from './components/todo-list/todo-list.component';
import { CreateTodoItemFormComponent } from './components/create-todo-item-form/create-todo-item-form.component';
import { CreateTodoListFormComponent } from './components/create-todo-list-form/create-todo-list-form.component';
import { HeaderComponent } from './components/header/header.component';
import { TodoItemService } from './services/todo-item/todo-item.service';
import { TodoListService } from './services/todo-list/todo-list.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EditTodoItemFormComponent } from './components/edit-todo-item-form/edit-todo-item-form.component';
import { EditTodoListFormComponent } from './components/edit-todo-list-form/edit-todo-list-form.component';

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    CreateTodoItemFormComponent,
    CreateTodoListFormComponent,
    HeaderComponent,
    EditTodoItemFormComponent,
    EditTodoListFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatMenuModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    TodoItemService,
    TodoListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
