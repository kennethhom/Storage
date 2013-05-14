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

public class ListActivity extends Activity implements OnClickListener {
	
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
    	
    	switch(arg0.getId()){
    	case R.id.bSQLUpdate:
    		boolean diditwork= true;
    		try{
    		String name = sqlName.getText().toString();
    		String hotness = sqlHotness.getText().toString();
    		
    		DBAdaptor entry = new DBAdaptor(ListActivity.this);
    		entry.open();
    		entry.createEntry(name, hotness);
    		entry.close();
    		}
    		catch (Exception e){
    			diditwork = false;
        		System.out.print("no nigga it didnt work");

    		}
    		finally{
    			if(diditwork){
    				Dialog d = new Dialog(this);
    				d.setTitle("heck yea!");
    				TextView tv = new TextView(this);
    				tv.setText("sucess");
    				d.setContentView(tv);
    				d.show();
    			}
    		}
    		break;
    	case R.id.bSQLopenView:
    		
    		startActivity(new Intent("com.example.wineapp.SQLView"));
    	
    		break;
    	}
   

    }
}
