package br.edu.ifrn.sigepi.editaisDAO;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.banco.CustomSQLiteOpenHelper;
import br.edu.ifrn.sigepi.modelo.Edital;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class EditaisDAO {
	
	private SQLiteDatabase database;
	private String[] columns = { CustomSQLiteOpenHelper.COLUMN_TITULO };
	private CustomSQLiteOpenHelper sqliteOpenHelper;
	
	public EditaisDAO(Context context){
		sqliteOpenHelper = new CustomSQLiteOpenHelper(context);
	}
	
	public void open() throws SQLException{
		database = sqliteOpenHelper.getWritableDatabase();
	}
	
	public void close(){
		sqliteOpenHelper.close();
	}
	
	public Edital create(String edital){
		ContentValues values = new ContentValues();
		values.put(CustomSQLiteOpenHelper.COLUMN_TITULO, edital);
		long insertId = database.insert(CustomSQLiteOpenHelper.TABLE_EDITAIS, null, values);
		
		Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_EDITAIS, columns, null, null, null, null, null);
		cursor.moveToFirst();
		Edital novoEdital = new Edital();
		novoEdital.setTitulo(cursor.getString(0));
		cursor.close();
		return novoEdital;
	}
	
	public void delete(Edital edital){
		String titulo = edital.getTitulo();
		database.delete(CustomSQLiteOpenHelper.TABLE_EDITAIS, null, null);
	}
	
	public List<Edital> getAll(){
		List<Edital> editais = new ArrayList<Edital>();
		
		Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_EDITAIS, columns, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Edital e = new Edital();
			e.setTitulo(cursor.getString(0));
			editais.add(e);
			cursor.moveToNext();
		}
		cursor.close();
		return editais;
		
	}
	
	
	
	
	
	
	
	
	
}
