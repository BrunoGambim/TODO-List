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
import { TodoItemFormComponent } from './components/todo-item-form/todo-item-form.component';
import { TodoListFormComponent } from './components/todo-list-form/todo-list-form.component';
import { HeaderComponent } from './components/header/header.component';
import { TodoItemService } from './services/todo-item/todo-item.service';
import { TodoListService } from './services/todo-list/todo-list.service';

@NgModule({
  declarations: [
    AppComponent,
    TodoListComponent,
    TodoItemFormComponent,
    TodoListFormComponent,
    HeaderComponent
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
  ],
  providers: [
    TodoItemService,
    TodoListService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
