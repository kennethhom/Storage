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
	static final String TAG = "DBAdapter";
	
	static final String DATABASE_NAME = "MyDB";
	static final String DATABASE_TABLE = "contacts";
	static final int DATABASE_VERSION = 1;
	
	static final String DATABASE_CREATE=
			"create table contacts (_id integer primary key autoincrement," +
	"name text not null, hotness text not null);";
	
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
			KEY_HOTNESS + " TEXT NOT NULL);"
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
	

	public long createEntry(String name, String hotness) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_HOTNESS, hotness);
		return db.insert(DATABASE_TABLE, null, cv);
	}
	
	
	public String getData() {
		
		
		String[] columns = new String[]{KEY_ROWID, KEY_NAME, KEY_HOTNESS};
		Cursor c = db.query(DATABASE_TABLE, columns, null, null, null, null, null);
		String result = "";
		
		int iRow = c.getColumnIndex(KEY_ROWID);
		int iName = c.getColumnIndex(KEY_NAME);
		int iHotness = c.getColumnIndex(KEY_HOTNESS);
		
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
			result = result + c.getString(iRow) + " " + c.getString(iName) + " " + c.getString(iHotness) + "\n";
		}
		return result;
	}
	
}
