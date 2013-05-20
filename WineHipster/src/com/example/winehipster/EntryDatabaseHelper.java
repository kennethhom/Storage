/**
 * 
 */
package com.example.winehipster;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Aviv
 *
 */
public class EntryDatabaseHelper extends SQLiteOpenHelper {
	public static final String DB_NAME = "entries.sqlite";
	public static final int VERSION = 1;
	
	public static final String TABLE_ENTRY = "entry";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_DRAFT = "is_draft";
	public static final String COLUMN_WINE = "wine";
	public static final String COLUMN_TYPE = "type";
	public static final String COLUMN_COUNTRY_REGION = "country_region";
	public static final String COLUMN_SERVING_TEMPERATURE = "serving_temperature";
	public static final String COLUMN_APPEARENCE = "appearence";
	public static final String COLUMN_AROMA = "aroma";
	public static final String COLUMN_TASTE = "taste";
	public static final String COLUMN_PAIRED_WITH = "paired_with";
	public static final String COLUMN_OPINION = "opinion";
	public static final String COLUMN_VINTAGE = "vintage";
	public static final String COLUMN_RATING = "rating";
	public static final String COLUMN_PRICE = "price";
	public static final String COLUMN_ALCOHOL_CONTENT = "alcohol_content";
	public static final String COLUMN_PHOTO = "photo";
	public static final String COLUMN_ENTRY_LOCATION = "location";
	public static final String COLUMN_ENTRY_DATE = "entry_date";

	public EntryDatabaseHelper(Context context) {
		super(context, DB_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public long insertEntry(Entry entry) {
		
		return 0; // stub, needs to be changed
	}
	
	public long updateEntry(Entry entry) {
		
		return 0;
	}
	
	public EntryCursor queryEntries() {
		
		
		return null;
	}
	
	public EntryCursor queryEntry(long id) {
		
		return null;
	}
	
	public static class EntryCursor extends CursorWrapper {
		
		public EntryCursor(Cursor c) {
			super(c);
		}
		
		public Entry getEntry() {
			
			return null;
		}
	}
	
}















