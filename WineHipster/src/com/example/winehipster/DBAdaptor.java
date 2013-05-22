package com.example.winehipster;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 
import android.util.Log;

public class DBAdaptor {

	static final String KEY_ROWID = "_id";
	static final String KEY_NAME = "name";
	static final String KEY_HOTNESS = "hotness";
	static final String KEY_OPINION = "opinion";
	static final String KEY_VINTAGE = "vintage";
	static final String KEY_TYPEOFWINE = "typeofwine";
	static final String KEY_RATING = "rating";
	static final String KEY_PRICE = "price";
	static final String KEY_ENTRYDATE = "entrydate";
	//static final String KEY_ENTRYLOCATION = "entrylocation";
	static final String KEY_APPEARANCE = "appearance";
	static final String KEY_TASTE = "taste";
	static final String KEY_AROMA = "aroma";
	static final String KEY_SERVINGTEMP = "servingtemperature";
	static final String KEY_COUNTRYREGION = "countryregion";
	static final String KEY_ALCOHOLCONTENT = "alcoholcontent";
	static final String KEY_IMAGE = "image";
	
	static final String TAG = "DBAdapter";
	
	static final String DATABASE_NAME = "MyDB";
	static final String DATABASE_TABLE = "contacts";
	static final int DATABASE_VERSION = 1;
	

	
	final Context context;
	
	DatabaseHelper DBHelper;
	SQLiteDatabase db;
	
	public DBAdaptor(Context ctx){
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}
	
	private static class DatabaseHelper extends SQLiteOpenHelper{
		DatabaseHelper(Context context){
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		
		public void onCreate(SQLiteDatabase db){
			try {
			 	db.execSQL("CREATE TABLE "+
			DATABASE_TABLE+
			" (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
			KEY_NAME + " TEXT NOT NULL, "+
			KEY_OPINION + " TEXT NOT NULL, " +
			KEY_VINTAGE + " TEXT NOT NULL, " +
			KEY_TYPEOFWINE + " TEXT NOT NULL, " +
			KEY_RATING + " TEXT NOT NULL, " +
			KEY_PRICE + " TEXT NOT NULL, " +
			KEY_ENTRYDATE + " TEXT NOT NULL, " +
			KEY_APPEARANCE + " TEXT NOT NULL, "+
			KEY_TASTE + " TEXT NOT NULL, "+
			KEY_AROMA + " TEXT NOT NULL, "+
			KEY_SERVINGTEMP + " TEXT NOT NULL, "+
			KEY_COUNTRYREGION + " TEXT NOT NULL, "+
			KEY_ALCOHOLCONTENT + " TEXT NOT NULL, " +
			KEY_IMAGE + " BLOB);"
			); } catch (SQLException e) {
				
				e.printStackTrace(); }
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			
			onCreate(db);
		}
	}
	
	//---opens the database---
	public DBAdaptor open() throws SQLException {
	db = DBHelper.getWritableDatabase();
	return this; }
	//---closes the database---
	public void close() {
	DBHelper.close(); }
	

	public long createEntry(String name, String opinion, String vintage, String typeofwine, String rating, String price, String entrydate, 
			String appearance, String taste, String aroma, String servingtemp, String country, String level, byte[] image) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_OPINION, opinion);
		cv.put(KEY_VINTAGE, vintage);
		cv.put(KEY_TYPEOFWINE, typeofwine);
		cv.put(KEY_RATING, rating);
		cv.put(KEY_PRICE, price);
		cv.put(KEY_ENTRYDATE, entrydate);
		cv.put(KEY_APPEARANCE, appearance);
		cv.put(KEY_TASTE, taste);
		cv.put(KEY_AROMA, aroma);
		cv.put(KEY_SERVINGTEMP, servingtemp);
		cv.put(KEY_COUNTRYREGION, country);
		cv.put(KEY_ALCOHOLCONTENT, level);
		cv.put(KEY_IMAGE, image);
		
		
		return db.insert(DATABASE_TABLE, null, cv);
	}
	
	
	public String getData() {
		
		
		String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_OPINION,
				KEY_VINTAGE, KEY_TYPEOFWINE, KEY_RATING, KEY_PRICE, KEY_ENTRYDATE,
				KEY_APPEARANCE, KEY_TASTE, KEY_AROMA, KEY_SERVINGTEMP, KEY_COUNTRYREGION,
				KEY_ALCOHOLCONTENT};
		Cursor c = db.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iOpinion = c.getColumnIndex(KEY_OPINION);
		int iVintage = c.getColumnIndex(KEY_VINTAGE);
		int iTypeOfWine = c.getColumnIndex(KEY_TYPEOFWINE);
		int iRating = c.getColumnIndex(KEY_RATING);
		int iPrice = c.getColumnIndex(KEY_PRICE);
		int iEntryDate = c.getColumnIndex(KEY_ENTRYDATE);
		int iAppearance = c.getColumnIndex(KEY_APPEARANCE);
		int iTaste = c.getColumnIndex(KEY_TASTE);
		int iAroma = c.getColumnIndex(KEY_AROMA);
		int iServingTemp = c.getColumnIndex(KEY_SERVINGTEMP);
		int iCountryDate = c.getColumnIndex(KEY_COUNTRYREGION);
		int iAlcoholContent = c.getColumnIndex(KEY_ALCOHOLCONTENT);
		int photo = c.getColumnIndex(KEY_IMAGE);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iName) + 
					" " + c.getString(iVintage) +
					" " + c.getString(iTypeOfWine) +
					" " + c.getString(iRating) +
					" " + c.getString(iPrice) +
					" " + c.getString(iEntryDate) +
					" " + c.getString(iAppearance) +
					" " + c.getString(iTaste) +
					" " + c.getString(iAroma) +
					" " + c.getString(iServingTemp) +
					" " + c.getString(iCountryDate) +
					" " + c.getString(iAlcoholContent) +"\n";
		}
		return result;
	}
	
}
