package cn.edu.jssvc.hzqbookmanagement_v5;

import cn.edu.jssvc.hzqbookmanagement_v5.DatabaseHelper;
import cn.edu.jssvc.hzqbookmanagement_v5.DialogDemo;
import cn.edu.jssvc.hzqbookmanagement_v5.R;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddBooks extends Activity {

	private EditText addbook_edit;
	private EditText addauthor_edit;
	private EditText addprice_edit;
	private Button btn_add;
	private Button btn_abandon;
	private TextView setting_about_back;
	private DatabaseHelper dbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.addbooks);

		dbHelper = new DatabaseHelper(this);
		addbook_edit = (EditText) findViewById(R.id.addbook_edit);
		addauthor_edit = (EditText) findViewById(R.id.addauthor_edit);
		addprice_edit = (EditText) findViewById(R.id.addprice_edit);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_abandon = (Button) findViewById(R.id.btn_abandon);
		setting_about_back = (TextView) findViewById(R.id.setting_about_back);

		btn_add.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				SQLiteDatabase db = dbHelper.getWritableDatabase();
				ContentValues values = new ContentValues();
				UserService uService = new UserService(AddBooks.this);
				boolean flag = uService.add(addbook_edit.getText().toString(),
						addauthor_edit.getText().toString(), addprice_edit
								.getText().toString());
				if (flag) {
					DialogDemo.builder(AddBooks.this, "������Ϣ", "�ü�¼�Ѵ��ڣ�");
				}else if (addbook_edit.getText().toString().equals("")) {
					DialogDemo.builder(AddBooks.this, "������Ϣ", "��������Ϊ�գ�");
				} else if (addauthor_edit.getText().toString().equals("")) {
					DialogDemo.builder(AddBooks.this, "������Ϣ", "���߲���Ϊ�գ�");
				} else if (addprice_edit.getText().toString().equals("")) {
					DialogDemo.builder(AddBooks.this, "������Ϣ", "�۸���Ϊ�գ�");
				} else {

					// ��ʼ��װ����
					values.put("bookname", addbook_edit.getText().toString());
					values.put("author", addauthor_edit.getText().toString());
					values.put("price", addprice_edit.getText().toString());
					db.insert("bookstore", null, values); // ��������
					Toast.makeText(AddBooks.this, "��ӳɹ�", Toast.LENGTH_SHORT)
							.show();
				}
			}
		});
		btn_abandon.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addbook_edit.setText("");
				addauthor_edit.setText("");
				addprice_edit.setText("");
			}
		});
		setting_about_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
			}

		});
	}
}
