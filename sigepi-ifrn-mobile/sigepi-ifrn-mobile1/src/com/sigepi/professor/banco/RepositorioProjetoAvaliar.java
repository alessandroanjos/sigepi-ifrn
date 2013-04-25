package com.sigepi.professor.banco;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.sigepi.professor.modelo.Projeto;
import com.sigepi.professor.modelo.ProjetoAvaliar;

public class RepositorioProjetoAvaliar {
	
	private final String NOME_BANCO = "sigepi.db";
	private final String NOME_TABELA = "projetosAvaliar";

	private SQLiteDatabase db;
	
	public RepositorioProjetoAvaliar(Context ctx){
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}

	public void close(){
		db.close();
	}
	
	public int salvarLista(List<ProjetoAvaliar> projetos){
		int qtd = 0;
		
		for (ProjetoAvaliar projetoAvaliar : projetos) {
			projetoAvaliar.setId(0);
			salvar(projetoAvaliar);
			qtd++;
		}
		
		return qtd;
	}
	
	public int salvar(ProjetoAvaliar projetoAvaliar){
		int id = projetoAvaliar.getId();

		if(id != 0)
			atualizar(projetoAvaliar);
		else
			id = inserir(projetoAvaliar);

		return id;
	}

	private int inserir(ProjetoAvaliar projetoAvaliar) {
		ContentValues values = new ContentValues();		
		values.put(ProjetoAvaliar.PROJETO_AVALIAR, projetoAvaliar.getProjetoAvaliar());

		int id = (int) inserir(values);
		return id;
	}
	
	private long  inserir(ContentValues values) {
		long id = db.insert(NOME_TABELA, null, values);
		
		Log.i("TESTE [ID ITEM]", String.valueOf(id));
		return id;
	}

	private int atualizar(ProjetoAvaliar projetoAvaliar) {
		ContentValues values = new ContentValues();

		String _id = String.valueOf(projetoAvaliar.getId());
		values.put(ProjetoAvaliar.PROJETO_AVALIAR, projetoAvaliar.getProjetoAvaliar());
				
		String where = Projeto.ID + "=?";
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
	
	public List<ProjetoAvaliar> listarProjetos(){
		Cursor cursor = getCursor();

		List<ProjetoAvaliar> listaProjetosAvaliar = new ArrayList<ProjetoAvaliar>();

		if(cursor.moveToFirst()){	
			while(!cursor.isAfterLast()) {
				ProjetoAvaliar projetoAvaliar = new ProjetoAvaliar();
				projetoAvaliar.setId(cursor.getInt(0));
				projetoAvaliar.setProjetoAvaliar(cursor.getString(1));

				listaProjetosAvaliar.add(projetoAvaliar);

			    cursor.moveToNext();
			}
		}
		
		return listaProjetosAvaliar;
	}
	
	public int deletarTodos(){
		int qtd = db.delete(NOME_TABELA, null, null);
		
		return qtd;
	}

}
