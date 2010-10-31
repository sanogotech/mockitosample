package com.hascode.android.persistence;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.hascode.android.activity.SimpleTodoActivity;

public class TodoProvider {
	private static final String DB_NAME = "tasks";
	private static final String TABLE_NAME = "tasks";
	private static final int DB_VERSION = 1;
	private static final String DB_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME
			+ " (id integer primary key autoincrement, title text not null);";

	private SQLiteDatabase storage;
	private SQLiteOpenHelper helper;

	public TodoProvider(Context ctx) {
		helper = new SQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {
			@Override
			public void onUpgrade(SQLiteDatabase db, int oldVersion,
					int newVersion) {
				db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
				onCreate(db);
			}

			@Override
			public void onCreate(SQLiteDatabase db) {
				db.execSQL(DB_CREATE_QUERY);
			}
		};
		storage = helper.getWritableDatabase();
	}

	public List<String> findAll() {
		Log.d(SimpleTodoActivity.APP_TAG, "findAll triggered");
		List<String> tasks = new ArrayList<String>();
		Cursor c = storage.query(TABLE_NAME, new String[] { "title" }, null,
				null, null, null, null);
		if (c != null) {
			c.moveToFirst();
			while (c.isAfterLast() == false) {
				tasks.add(c.getString(0));
				c.moveToNext();
			}
			c.close();
		}
		return tasks;
	}

	public void addTask(String title) {
		ContentValues data = new ContentValues();
		data.put("title", title);
		storage.insert(TABLE_NAME, null, data);
	}

	public void deleteTask(String title) {
		storage.delete(TABLE_NAME, "title='" + title + "'", null);
	}

	public void deleteTask(long id) {
		storage.delete(TABLE_NAME, "id=" + id, null);
	}
}
