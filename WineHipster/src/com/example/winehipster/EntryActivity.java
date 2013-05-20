package com.example.winehipster;

import android.app.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EntryActivity extends Activity implements OnClickListener{


EditText textBox;
	
	
	Button sqlUpdate, sqlView;
	EditText sqlName, sqlHotness;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.activity_list); 
        
        
        
        
        
        
        
        
        
        
       
        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlName = (EditText) findViewById(R.id.etSQLName);
        sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
        
        sqlView = (Button) findViewById( R.id.bSQLopenView);
        sqlView.setOnClickListener(this);
        sqlUpdate.setOnClickListener( this);
        

    }




    
    public void onClick(View arg0){
    	

    }
}
