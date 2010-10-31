package com.hascode.android.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.hascode.android.R;
import com.hascode.android.persistence.TodoProvider;

public class SimpleTodoActivity extends Activity {
	public static final String APP_TAG = "com.hascode.android.simple-todos";
	private ListView taskView;
	private Button btNewTask;
	private EditText etNewTask;
	private TodoProvider provider;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.main);
		provider = new TodoProvider(this);
		taskView = (ListView) findViewById(R.id.tasklist);
		btNewTask = (Button) findViewById(R.id.btNewTask);
		etNewTask = (EditText) findViewById(R.id.etNewTask);
		btNewTask.setOnClickListener(handleNewTaskEvent);
		renderTodos();
	}

	private OnClickListener handleNewTaskEvent = new OnClickListener() {
		@Override
		public void onClick(View view) {
			Log.d(APP_TAG, "add task click received");
			provider.addTask(etNewTask.getText().toString());
			renderTodos();
		}
	};

	/**
	 * renders the task list
	 */
	private void renderTodos() {
		List<String> beans = provider.findAll();
		if (!beans.isEmpty()) {
			Log.d(APP_TAG, String.format("%d beans found", beans.size()));
			// render the list
			taskView.setAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, beans
							.toArray(new String[] {})));

			// dumb item deletion onclick
			taskView.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					Log.d(APP_TAG, String.format(
							"item with id: %d and position: %d", id, position));
					TextView v = (TextView) view;
					provider.deleteTask(v.getText().toString());
					renderTodos();

				}
			});
		} else {
			Log.d(APP_TAG, "no tasks found");
		}
	}
}