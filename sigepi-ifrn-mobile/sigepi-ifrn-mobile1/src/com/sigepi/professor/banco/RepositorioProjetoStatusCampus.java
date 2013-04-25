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
import com.sigepi.professor.modelo.ProjetoStatusCampus;

public class RepositorioProjetoStatusCampus {

	private final String NOME_BANCO = "sigepi.db";
	private final String NOME_TABELA = "projetosStatusCampus";

	private SQLiteDatabase db;
	
	public RepositorioProjetoStatusCampus(Context ctx){
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}

	public void close(){
		db.close();
	}
	
	public int salvarLista(List<ProjetoStatusCampus> projetos){
		int qtd = 0;
		
		for (ProjetoStatusCampus projetoStatusCampus : projetos) {
			projetoStatusCampus.setId(0);
			salvar(projetoStatusCampus);
			qtd++;
		}
		
		return qtd;
	}
	
	public int salvar(ProjetoStatusCampus projetoStatusCampus){
		int id = projetoStatusCampus.getId();

		if(id != 0)
			atualizar(projetoStatusCampus);
		else
			id = inserir(projetoStatusCampus);

		return id;
	}

	private int inserir(ProjetoStatusCampus projetoStatusCampus) {
		ContentValues values = new ContentValues();		
		values.put(ProjetoAvaliar.PROJETO_AVALIAR, projetoStatusCampus.getProjetoStatusCampus());

		int id = (int) inserir(values);
		return id;
	}
	
	private long  inserir(ContentValues values) {
		long id = db.insert(NOME_TABELA, null, values);
		
		Log.i("TESTE [ID ITEM]", String.valueOf(id));
		return id;
	}

	private int atualizar(ProjetoStatusCampus projetoStatusCampus) {
		ContentValues values = new ContentValues();

		String _id = String.valueOf(projetoStatusCampus.getId());
		values.put(ProjetoStatusCampus.PROJETO_STATUS_CAMPUS, projetoStatusCampus.getProjetoStatusCampus());
				
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
	
	public List<ProjetoStatusCampus> listarProjetosStatusCampus(){
		Cursor cursor = getCursor();

		List<ProjetoStatusCampus> listaProjetosStatusCampus = new ArrayList<ProjetoStatusCampus>();

		if(cursor.moveToFirst()){	
			while(!cursor.isAfterLast()) {
				ProjetoStatusCampus projetoStatusCampus = new ProjetoStatusCampus();
				projetoStatusCampus.setId(cursor.getInt(0));
				projetoStatusCampus.setProjetoStatusCampus(cursor.getString(1));

				listaProjetosStatusCampus.add(projetoStatusCampus);

			    cursor.moveToNext();
			}
		}
		
		return listaProjetosStatusCampus;
	}
	
	public int deletarTodos(){
		int qtd = db.delete(NOME_TABELA, null, null);
		
		return qtd;
	}

}
