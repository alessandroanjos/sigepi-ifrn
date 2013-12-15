package br.edu.ifrn.sigepi.banco;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.modelo.Edital;
import br.edu.ifrn.sigepi.modelo.Projeto;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SigepiMobileDatabase extends SQLiteOpenHelper {
	
	private static final String NOME_BANCO = "sigepi";
	private static final String TABELA_PROJETO = "projeto";
	private static final String TABELA_EDITAL = "edital";
	

	private static final String CREATE_EDITAL = "CREATE TABLE "+ TABELA_EDITAL + " ("+ 
			Edital.TITULO + " TEXT PRIMARY KEY"+ ")";
	private static final String CREATE_PROJETO = "CREATE TABLE "+ TABELA_PROJETO + " ("+ 
			Projeto.PROJETO + " TEXT PRIMARY KEY"+ ")";

	private Context contexto;


	protected SQLiteDatabase dbDatabase;
	
	public SigepiMobileDatabase(Context context) {
		//dbDatabase = context.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		
		super(context, NOME_BANCO, null, 2);
		contexto = context;
	}
	
	public Edital buscarEdital(String titulo){
		Edital edital = null;	
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		
		onCreate(dbDatabase);
		
		String[] selargs = {titulo};
		
		Cursor c2 = dbDatabase.rawQuery("SELECT titulo FROM edital WHERE titulo=?", selargs);
		
		if(c2.moveToNext()){
			edital = new Edital();
			edital.setTitulo(c2.getString(0));
		}
		return edital;
	}
	
	public Projeto buscarProjeto(String titulo){
		Projeto projeto = null;	
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		
		onCreate(dbDatabase);
		
		String[] selargs = {titulo};
		
		Cursor c2 = dbDatabase.rawQuery("SELECT projeto FROM projeto WHERE projeto=?", selargs);
		
		if(c2.moveToNext()){
			projeto = new Projeto();
			projeto.setProjeto(c2.getString(0));
		}
		return projeto;
	}
	
	public void criaEdital(Edital edital){
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		
		onCreate(dbDatabase);
		ContentValues contentValues = new ContentValues();
		contentValues.put(Edital.TITULO, edital.getTitulo());
		criaEdital(contentValues);
	}
	
	public void criaProjeto(Projeto projeto){
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		
		onCreate(dbDatabase);
		ContentValues contentValues = new ContentValues();
		contentValues.put(Projeto.PROJETO, projeto.getProjeto());
		criaProjeto(contentValues);
	}
	
	public void criaEdital(ContentValues valores){
		dbDatabase.insert(TABELA_EDITAL, null, valores);
		Log.i("## Tabela Edital", "Inseriu o registro.");
	}
	
	public void criaProjeto(ContentValues valores){
		dbDatabase.insert(TABELA_PROJETO, null, valores);
		Log.i("## Tabela Projeto", "Inseriu o registro.");
	}
	
	public void atualizarEdital(Edital edital, String nome){
		ContentValues contentValues = new ContentValues();
		contentValues.put(Edital.TITULO, edital.getTitulo());
		
		String where = Edital.TITULO + "=?";
		String[] whereArgs = new String[]{nome};
		atualizarEdital(contentValues, where, whereArgs);
	}
	
	public void atualizarProjeto(Projeto projeto, String nome){
		ContentValues contentValues = new ContentValues();
		contentValues.put(Projeto.PROJETO, projeto.getProjeto());
		
		String where = Projeto.PROJETO + "=?";
		String[] whereArgs = new String[]{nome};
		atualizarProjeto(contentValues, where, whereArgs);
	}
	
	public int atualizarEdital(ContentValues valores, String where, String[] whereArgs){
		int count =  dbDatabase.update(TABELA_EDITAL, valores, where, whereArgs);
		Log.i("Tabela Edital", "Atualizou [ "+ count + " ] registros");
		return count;
	}
	
	public int atualizarProjeto(ContentValues valores, String where, String[] whereArgs){
		int count =  dbDatabase.update(TABELA_PROJETO, valores, where, whereArgs);
		Log.i("Tabela Projeto", "Atualizou [ "+ count + " ] registros");
		return count;
	}
	
	public int deletarEdital(String nome, String titulo){
		String where  = Edital.TITULO + "=?";
		String[] whereArgs = new String[] {nome};
		int count = deletarEdital(where, whereArgs);
		return count;
	}
	
	public int deletarProjeto(String nome, String titulo){
		String where  = Projeto.PROJETO + "=?";
		String[] whereArgs = new String[] {nome};
		int count = deletarProjeto(where, whereArgs);
		return count;
	}
	
	public int deletarEdital(String where, String[] whereArgs){
		int count = dbDatabase.delete(TABELA_EDITAL, where, whereArgs);
		Log.i("Tabela Edital", "Deletou [ "+ count + " ] registros");
		return count;
	}
	
	public int deletarProjeto(String where, String[] whereArgs){
		int count = dbDatabase.delete(TABELA_PROJETO, where, whereArgs);
		Log.i("Tabela Projeto", "Deletou [ "+ count + " ] registros");
		return count;
	}
	
	public int deletarTodosEditais(){
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		onCreate(dbDatabase);
		int qtd = dbDatabase.delete(TABELA_EDITAL, null, null);
		return qtd;
	}
	
	public int deletarTodosProjetos(){
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		onCreate(dbDatabase);
		int qtd = dbDatabase.delete(TABELA_PROJETO, null, null);
		return qtd;
	}
	
	///
	
	public Cursor getCursorEdital() {
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		try {
			return dbDatabase.query(TABELA_EDITAL, null, null, null, null, null, null);
		} catch (SQLiteException ex) {
			Log.e("Tabela Edital", "Erro ao buscar os editais." + ex.toString());
			return null;
		}
	}
	
	public List<Edital> listarEditais(){
		Cursor c = getCursorEdital();
		
		List<Edital> editais = new ArrayList<Edital>();
		
		if (c != null) {

			if (c.moveToFirst()) {
				int idxTitulo = c.getColumnIndex(Edital.TITULO);

				do {
					Edital edital = new Edital();
					editais.add(edital);
					edital.setTitulo(c.getString(idxTitulo));
				} while (c.moveToNext());
			}

		}
		return editais;
	}
	
	public Cursor getCursorProjetos() {
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		try {
			return dbDatabase.query(TABELA_PROJETO, null, null, null, null, null, null);
		} catch (SQLiteException ex) {
			Log.e("Tabela Projeto", "Erro ao buscar os projetos." + ex.toString());
			return null;
		}
	}
	
	public List<Projeto> listarProjetos(){
		Cursor c = getCursorProjetos();
		
		List<Projeto> projetos = new ArrayList<Projeto>();
		
		if (c != null) {

			if (c.moveToFirst()) {
				int idxTitulo = c.getColumnIndex(Projeto.PROJETO);

				do {
					Projeto projeto = new Projeto();
					projetos.add(projeto);
					projeto.setProjeto(c.getString(idxTitulo));
				} while (c.moveToNext());
			}
		}
		return projetos;
	}
	

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABELA_EDITAL + "("+Edital.TITULO + " TEXT PRIMARY KEY"+ ")");
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABELA_PROJETO + "("+Projeto.PROJETO + " TEXT PRIMARY KEY"+ ")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS "+ TABELA_EDITAL);
		db.execSQL("DROP TABLE IF EXISTS "+ TABELA_PROJETO);
		onCreate(db);
	}
}
