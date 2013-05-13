package com.example.winehipster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListActivity extends Activity {
	
	private Button fakeEntry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		// comment
		/*
		fakeEntry = (Button) findViewById(R.id.fake_entry);
		fakeEntry.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent entryIntent = new Intent(ListActivity.this, EntryActivity.class);
				startActivity(entryIntent);
			}
		}); */
	}
}
