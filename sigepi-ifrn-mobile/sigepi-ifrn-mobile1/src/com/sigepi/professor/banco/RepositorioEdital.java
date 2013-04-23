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
		Log.i(RepositorioEdital.class.getName(), "Banco de dados aberto : [" + db.isOpen() + "][" + db.isReadOnly() + "]");
		Log.i(RepositorioEdital.class.getName(), "Verificando se tabela existe");
		Cursor cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='" + NOME_TABELA + "'", null);
		cursor.moveToFirst();
		if (cursor.getCount() == 0) {
			Log.i(RepositorioEdital.class.getName(), "Criando tabela");
			String createQuery = "CREATE TABLE " + NOME_TABELA +
					"(" + Edital.ID + " integer primary key autoincrement" + 
					", " + Edital.TITULO + " TEXT);";

			db.execSQL(createQuery);
			Log.i(RepositorioEdital.class.getName(), "Tabela criada!");
		}
		cursor.close();
		Log.i(RepositorioEdital.class.getName(), "Verificação concluída!");
	}
	
	public void close(){
		db.close();
	}
	
	public int salvarLista(List<Edital> editais){
		int qtd = 0;
		
		for (Edital edital : editais) {
//			edital.setId(0);
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
		
		values.put(Edital.ID, edital.getId());
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
		
		values.put(Edital.ID, edital.getId());
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
		return db.query(NOME_TABELA, new String[] {Edital.ID, Edital.TITULO}, null, null, null, null, Edital.TITULO);
	}
	
	public List<Edital> listarEditais(){
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : Query");
		Cursor cursor = getCursor();
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : Query finalizado!");
		
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : Convertendo em objetos java");
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : getCount");
		List<Edital> listaEdital = new ArrayList<Edital>(cursor.getCount());
		
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : moveToFirst");
		if(cursor.moveToFirst()){
			Log.i(RepositorioEdital.class.getName(), "DB-Cursor : isAfterLast");
			while(!cursor.isAfterLast()) {
				Log.i(RepositorioEdital.class.getName(), "DB-Cursor : get");
				Edital edital = new Edital();
				edital.setId(cursor.getInt( cursor.getColumnIndex(Edital.ID) ));
//				edital.setId_edital(cursor.getInt(1));
				edital.setTitulo(cursor.getString( cursor.getColumnIndex(Edital.TITULO) ));
				Log.i(RepositorioEdital.class.getName(), "Edital [" + edital.getId() + "] " + edital.getTitulo());

				listaEdital.add(edital);
				
				Log.i(RepositorioEdital.class.getName(), "DB-Cursor : moveToNext");
			    cursor.moveToNext();
			}
		}
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : close");
		cursor.close();
		Log.i(RepositorioEdital.class.getName(), "DB-Cursor : Convertendo em objetos java - FINALIZADO!");
		
		return listaEdital;
	}
	
	public int deletarTodos(){
		int qtd = db.delete(NOME_TABELA, null, null);
		
		return qtd;
	}

}
