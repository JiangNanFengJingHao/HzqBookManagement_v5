package cn.edu.jssvc.hzqbookmanagement_v5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	static String name = "Preferences.db";
	static int version = 1;

	public DatabaseHelper(Context context) {
		super(context, name, null, version);
	}

	// ֻ�ڴ�����ʱ����һ��
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table user(id integer primary key autoincrement,username varchar(20),password varchar(20))";
		db.execSQL(sql);

		// ����Ĭ���û�
		String sql_use = "insert into user(id,username,password) values('0','admin','admin')";
		db.execSQL(sql_use);

	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
