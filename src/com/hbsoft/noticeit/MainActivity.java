package com.hbsoft.noticeit;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		synchronized (Widget_word.mNoticeWords) {
			Widget_word.loadWords(this);

			EditText v = (EditText) findViewById(R.id.notice_word);
			if (v != null) {
				String s = "";
				for (int i = 0; i < Widget_word.mNoticeWords.size(); i++)
					s += (Widget_word.mNoticeWords.get(i) + "\n");
				v.setText(s);
			}
		}
	}

}
