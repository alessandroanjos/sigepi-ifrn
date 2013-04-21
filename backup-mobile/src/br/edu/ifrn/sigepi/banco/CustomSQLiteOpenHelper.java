package br.edu.ifrn.sigepi.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;



public class CustomSQLiteOpenHelper extends SQLiteOpenHelper{
	public static final String TABLE_EDITAIS = "editais";
	public static final String COLUMN_TITULO = "titulo";
	
	private static final String DATABASE_NAME = "sigepi2.db";
	private static final int DATABASE_VERSION = 1;
	
	//database creation sql statement
	private static final String DATABASE_CREATE = "create table" 
			+ TABLE_EDITAIS + " ( " + COLUMN_TITULO
			+"text not null);";
		
	
	public CustomSQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);	
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS" + TABLE_EDITAIS);
		
	}

}
