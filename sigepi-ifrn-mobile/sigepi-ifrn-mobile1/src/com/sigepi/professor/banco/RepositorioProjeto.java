package com.sigepi.professor.banco;

import java.util.ArrayList;
import java.util.List;

import com.sigepi.professor.modelo.Projeto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class RepositorioProjeto {
	
	private final String NOME_BANCO = "sigepi.db";
	private final String NOME_TABELA = "projetos";
	
	private SQLiteDatabase db;
	
	public RepositorioProjeto(Context ctx){
		db = ctx.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
	}
	
	public void close(){
		db.close();
	}
	
	public int salvarLista(List<Projeto> consultas){
		int qtd = 0;
		
		for (Projeto consulta : consultas) {
			consulta.setId(0);
			salvar(consulta);
			qtd++;
		}
		
		return qtd;
	}
	
	public int salvar(Projeto consulta){
		int id = consulta.getId();
		
		if(id != 0)
			atualizar(consulta);
		else
			id = inserir(consulta);
		
		return id;
	}
	
	private int inserir(Projeto consulta) {
		ContentValues values = new ContentValues();
		
		values.put(Projeto.ID_PROJETO, consulta.getId_projeto());
		
		int id = (int) inserir(values);
		return id;
	}
	
	private long  inserir(ContentValues values) {
		long id = db.insert(NOME_TABELA, null, values);
		
		Log.i("TESTE [ID ITEM]", String.valueOf(id));
		return id;
	}

	private int atualizar(Projeto consulta) {
		ContentValues values = new ContentValues();
		
		String _id = String.valueOf(consulta.getId());
		
		values.put(Projeto.ID_PROJETO, consulta.getId_projeto());
				
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
	
	public List<Projeto> listarProjetos(){
		Cursor cursor = getCursor();
		
		List<Projeto> listaConsulta = new ArrayList<Projeto>();
		
		if(cursor.moveToFirst()){	
			while(!cursor.isAfterLast()) {
				Projeto consulta = new Projeto();
				consulta.setId(cursor.getInt(0));
				consulta.setId_projeto(cursor.getInt(1));
				
				listaConsulta.add(consulta);
				
			    cursor.moveToNext();
			}
		}
		
		return listaConsulta;
	}
	
	public int deletarTodos(){
		int qtd = db.delete(NOME_TABELA, null, null);
		
		return qtd;
	}

}
