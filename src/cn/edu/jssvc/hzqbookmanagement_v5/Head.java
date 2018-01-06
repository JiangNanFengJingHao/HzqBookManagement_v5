package cn.edu.jssvc.hzqbookmanagement_v5;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Head extends Activity {

	private TextView setting_about_back;
	private String[] data = { "����������ǿ", "�Ա���", "���䣺20", "רҵ�������Ӧ�ü���2��Ƕ�룩",
			"ѧУ��������ְҵ��ѧ", "��ϵ��ʽ��18913504162" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.head);
		setting_about_back = (TextView) findViewById(R.id.setting_about_back);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(Head.this,
				android.R.layout.simple_list_item_1, data);
		ListView listView = (ListView) findViewById(R.id.listview_head);
		listView.setAdapter(adapter);
		setting_about_back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
			
		});
	}
}
