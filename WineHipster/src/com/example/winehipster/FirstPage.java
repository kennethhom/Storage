package com.example.winehipster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class FirstPage extends Activity{
	private Button viewEntriesButton;
	private Button findWineryButton;
	private Button messWithGit;
	
// comment
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/**
		 * Initializes the view entries button. Takes user to screen with list of 
		 * all of their previous entries.
		 */
		viewEntriesButton = (Button) findViewById(R.id.view_entries);
		viewEntriesButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// CLicking "view entries" button takes you to new screen with list
				Intent entryListIntent = new Intent(FirstPage.this, ListActivity.class);
				startActivity(entryListIntent);
			}
		});
	
		
		/**
		 * Initializes the find winery screen. Takes user to a map that will zoom
		 * in on their location.
		 */
		findWineryButton = (Button) findViewById(R.id.find_winery);
		findWineryButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent findWineryIntent = new Intent(FirstPage.this, MapActivity.class);
				startActivity(findWineryIntent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
