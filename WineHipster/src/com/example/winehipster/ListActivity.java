package com.example.winehipster;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends Activity implements OnClickListener {
	
	
	Button sqlUpdate, sqlView;
	EditText textBox, sqlName, sqlHotness, sqlOpinion, sqlVintage, sqlTypeOfWine, sqlRating, sqlPrice;


	private EditText sqlEntryDate;
	private EditText sqlAppearance;
	private EditText sqlTaste;
	private EditText sqlAroma;
	private EditText sqlServingTemp;
	private EditText sqlCountry;
	private EditText sqlLevel;
	
	//*********************************************************************************************
	Button addImage;
	 //ArrayList<Contact> imageArry = new ArrayList<Contact>();
	 //ContactImageAdapter imageAdapter;
	 private static final int CAMERA_REQUEST = 1;
	 private static final int PICK_FROM_GALLERY = 2;
	 ListView dataList;
	 byte[] imageName;
	 int imageId;
	 Bitmap theImage;
	 //DataBaseHandler db;
	 
	 
	
	
	
	//*********************************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.activity_list); 
        
    	//*********************************************************************************************

        
        //dataList = (ListView) findViewById(R.id.list);

        
        //db = new DataBaseHandler(this);
        
        /**
         * open dialog for choose camera/gallery
         */

        final String[] option = new String[] { "Take from Camera",
          "Select from Gallery" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.select_dialog_item, option);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Select Option");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {

         public void onClick(DialogInterface dialog, int which) {
          // TODO Auto-generated method stub
          Log.e("Selected Item", String.valueOf(which));
          if (which == 0) {
           callCamera();
          }
          if (which == 1) {
           callGallery();
          }

         }
        });
        final AlertDialog dialog = builder.create();

        addImage = (Button) findViewById(R.id.btnAdd);

        addImage.setOnClickListener(new View.OnClickListener() {
         public void onClick(View v) {
          dialog.show();
         }
        });

       
  
        
        
    	//*********************************************************************************************

        
       
        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlName = (EditText) findViewById(R.id.etSQLName);
        sqlOpinion = (EditText) findViewById(R.id.etSQLOpinion);
        sqlVintage = (EditText) findViewById(R.id.etSQLVintage);
        sqlTypeOfWine = (EditText) findViewById(R.id.etSQLTypeOfWine);
        sqlRating = (EditText) findViewById(R.id.etSQLRating);
        sqlPrice = (EditText) findViewById(R.id.etSQLPrice);
        sqlEntryDate = (EditText) findViewById(R.id.etSQLEntryDate);
        sqlAppearance = (EditText) findViewById(R.id.etSQLAppearance);
        sqlTaste = (EditText) findViewById(R.id.etSQLTaste);
        sqlAroma = (EditText) findViewById(R.id.etSQLAroma);
        sqlServingTemp = (EditText) findViewById(R.id.etSQLServingTemp);
        sqlCountry = (EditText) findViewById(R.id.etSQLCountry);
        sqlLevel = (EditText) findViewById(R.id.etSQLLevel);
        
        
        
//        sqlView = (Button) findViewById( R.id.bSQLopenView);
//        sqlView.setOnClickListener(this);
//        sqlUpdate.setOnClickListener( this);
        

    }

    /**
     * On activity result
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     if (resultCode != RESULT_OK)
      return;

     switch (requestCode) {
     case CAMERA_REQUEST:

      Bundle extras = data.getExtras();

      if (extras != null) {
       Bitmap yourImage = extras.getParcelable("data");
       // convert bitmap to byte
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
       byte imageInByte[] = stream.toByteArray();
       imageName = imageInByte;
       Log.e("output before conversion", imageInByte.toString());
       // Inserting Contacts
       Log.d("Insert: ", "Inserting ..");
       //db.addContact(new Contact(1, "Android", imageInByte));
       Intent i = new Intent(ListActivity.this,
         ListActivity.class);
       startActivity(i);
       finish();

      }
      break;
     case PICK_FROM_GALLERY:
      Bundle extras2 = data.getExtras();

      if (extras2 != null) {
       Bitmap yourImage = extras2.getParcelable("data");
       // convert bitmap to byte
       ByteArrayOutputStream stream = new ByteArrayOutputStream();
       yourImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
       byte imageInByte[] = stream.toByteArray();
       imageName = imageInByte;
       Log.e("output before conversion", imageInByte.toString());
       // Inserting Contacts
       Log.d("Insert: ", "Inserting ..");
       //db.addContact(new Contact(1, "Android", imageInByte));
       Intent i = new Intent(ListActivity.this,
         ListActivity.class);
       startActivity(i);
       finish();
      }

      break;
     }
    }


    
    public void onClick(View arg0){
    	
    	switch(arg0.getId()){
    	case R.id.bSQLUpdate:
    		boolean diditwork= true;
    		try{
    		String name = sqlName.getText().toString();
    		String opinion = sqlOpinion.getText().toString();
    		String vintage = sqlVintage.getText().toString();
    		String typeofwine = sqlTypeOfWine.getText().toString();
    		String rating = sqlRating.getText().toString();
    		String price = sqlPrice.getText().toString();
    		String entrydate = sqlEntryDate.getText().toString();
    		String appearance = sqlAppearance.getText().toString();
    		String taste = sqlTaste.getText().toString();
    		String aroma = sqlAroma.getText().toString();
    		String servingtemp = sqlServingTemp.getText().toString();
    		String country = sqlCountry.getText().toString();
    		String level = sqlLevel.getText().toString();
    		
    		
    		DBAdaptor entry = new DBAdaptor(ListActivity.this);
    		entry.open();
    		entry.createEntry( name,  opinion,  vintage,  typeofwine,  rating,  price,  entrydate, 
    				 appearance,  taste,  aroma,  servingtemp,  country,  level,imageName);
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
//    	case R.id.bSQLopenView:
    		
//    		startActivity(new Intent("com.example.wineapp.SQLView"));
    	
//    		break;
    	}
   
    }

    /**
     * open camera method
     */
    public void callCamera() {
     Intent cameraIntent = new Intent(
       android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
     cameraIntent.putExtra("crop", "true");
     cameraIntent.putExtra("aspectX", 0);
     cameraIntent.putExtra("aspectY", 0);
     cameraIntent.putExtra("outputX", 200);
     cameraIntent.putExtra("outputY", 150);
     startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    /**
     * open gallery method
     */

    public void callGallery() {
     Intent intent = new Intent();
     intent.setType("image/*");
     intent.setAction(Intent.ACTION_GET_CONTENT);
     intent.putExtra("crop", "true");
     intent.putExtra("aspectX", 0);
     intent.putExtra("aspectY", 0);
     intent.putExtra("outputX", 200);
     intent.putExtra("outputY", 150);
     intent.putExtra("return-data", true);
     startActivityForResult(
       Intent.createChooser(intent, "Complete action using"),
       PICK_FROM_GALLERY);

    }
    
}
