package com.sigepi.professor.banco;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.modelo.Edital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RepositorioEdital {
	
	private final String NOME_BANCO = "sigepi.db";
	private final String NOME_TABELA = "editais";
	
	private SQLiteDatabase db;
	
	public RepositorioEdital(Context ctx){
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}
	
	public void close(){
		db.close();
	}
	
	public int salvarLista(List<Edital> editais){
		int qtd = 0;
		
		for (Edital edital : editais) {
			edital.setId(0);
			salvar(edital);
			qtd++;
		}
		
		return qtd;
	}
	
	public int salvar(Edital edital){
		int id = edital.getId();
		
		if(id != 0)
			atualizar(edital);
		else
			id = inserir(edital);
		
		return id;
	}
	
	private int inserir(Edital edital) {
		ContentValues values = new ContentValues();
		
		values.put(Edital.ID_EDITAL, edital.getId_edital());
		values.put(Edital.TITULO, edital.getTitulo());
		
		
		int id = (int) inserir(values);
		return id;
	}
	
	private long  inserir(ContentValues values) {
		long id = db.insert(NOME_TABELA, null, values);
		
		Log.i("TESTE [ID ITEM]", String.valueOf(id));
		return id;
	}

	private int atualizar(Edital edital) {
		ContentValues values = new ContentValues();
		
		String _id = String.valueOf(edital.getId());
		
		values.put(Edital.ID_EDITAL, edital.getId_edital());
		values.put(Edital.TITULO, edital.getTitulo());
		
		
		String where = Edital.ID + "=?";
		String[] whereArgs = new String[] { _id };
		
		int count = atualiza(values, where, whereArgs);
		
		return count;
	}

	private int atualiza(ContentValues values, String where, String[] whereArgs) {
		int count = db.update(NOME_TABELA, values, where, whereArgs);
		Log.i("TESTE ATUALIZACAO", count + " registros");
		
		return count;
	}
	
	public Cursor getCursor(){
		return db.query(NOME_TABELA, null, null, null, null, null, null);
	}
	
	public List<Edital> listarEditais(){
		Cursor cursor = getCursor();
		
		List<Edital> listaEdital = new ArrayList<Edital>();
		
		if(cursor.moveToFirst()){	
			while(!cursor.isAfterLast()) {
				Edital edital = new Edital();
				edital.setId(cursor.getInt(0));
				edital.setId_edital(cursor.getInt(1));
				edital.setTitulo(cursor.getString(2));
				

				listaEdital.add(edital);
				
			    cursor.moveToNext();
			}
		}
		
		return listaEdital;
	}
	
	public int deletarTodos(){
		int qtd = db.delete(NOME_TABELA, null, null);
		
		return qtd;
	}

}
