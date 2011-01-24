package com.hascode.examples.protocol_buffer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.hascode.examples.protocol_buffer.TodoProvider.Todo;
import com.hascode.examples.protocol_buffer.TodoProvider.Todos;
import com.hascode.examples.protocol_buffer.TodoProvider.Todo.Priority;

public class Main {
	public static void main(String[] args) throws IOException {
		// write some todos to file
		Todo todo1 = Todo.newBuilder().setTitle("Do the laundry").setPriority(
				Priority.MEDIUM).build();
		Todo todo2 = Todo.newBuilder().setTitle("Write the tutorial")
				.setPriority(Priority.HIGH).build();
		Todos todos = Todos.newBuilder().addTodos(todo1).addTodos(todo2)
				.build();
		FileOutputStream os = new FileOutputStream("/tmp/todo.data");
		todos.writeTo(os);
		os.close();

		// read todos from file
		FileInputStream is = new FileInputStream("/tmp/todo.data");
		Todos.newBuilder().build();
		Todos newTodos = Todos.parseFrom(is);
		for (Todo todo : newTodos.getTodosList()) {
			System.out.println("Reading todo - title: " + todo.getTitle()
					+ " priority: " + todo.getPriority());
		}
	}
}
