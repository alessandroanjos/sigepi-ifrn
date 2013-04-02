package br.edu.ifrn.sigepi.banco;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.modelo.Edital;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RepositorioEdital {
	
	private final String NOME_BANCO = "sigepi2.db";
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
			salvar(edital);
			qtd++;
		}
		
		return qtd;
	}
	
	public int salvar(Edital edital){
		return 0;
	}
	
	private int inserir(Edital edital) {
		ContentValues values = new ContentValues();
		
		
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
		
			
		values.put(Edital.TITULO, edital.getTitulo());
		
		
	
		return 0;
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
