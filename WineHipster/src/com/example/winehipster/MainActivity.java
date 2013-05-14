package com.example.winehipster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.splash);     //displays the splashscreen image

	        
	        /**
	         * Splash screen displays for 5 seconds and changes to the home screen
	         */
	        Thread logoTimer = new Thread() {
	            public void run(){
	                try{
	                    int logoTimer = 0;
	                    while(logoTimer < 5000){
	                        sleep(100);
	                        logoTimer = logoTimer +100;
	                    };
	                    startActivity(new Intent("android.intent.action.MAINN"));
	                }
	                 
	                catch (InterruptedException e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	                 
	                finally{
	                    finish();
	                }
	            }
	        };
	         
	        logoTimer.start();
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	    
	        

	    }
        
        
        
        
        
        
        
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
