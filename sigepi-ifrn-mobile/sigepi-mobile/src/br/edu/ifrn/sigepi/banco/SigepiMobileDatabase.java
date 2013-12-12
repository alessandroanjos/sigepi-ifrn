package br.edu.ifrn.sigepi.banco;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.modelo.Edital;
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
		
		String[] selargs = {titulo};
		
		Cursor c2 = dbDatabase.rawQuery("SELECT titulo FROM edital WHERE titulo=?", selargs);
		
		if(c2.moveToNext()){
			edital = new Edital();
			edital.setTitulo(c2.getString(0));
		}
		return edital;
	}
	
	public void criaEdital(Edital edital){
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		
		onCreate(dbDatabase);
		ContentValues contentValues = new ContentValues();
		contentValues.put(Edital.TITULO, edital.getTitulo());
		criaEdital(contentValues);
	}
	
	public void criaEdital(ContentValues valores){
		dbDatabase.insert(TABELA_EDITAL, null, valores);
		Log.i("Tabela Edital", "Inseriu o registro.");
	}
	
	public void atualizar(Edital edital, String nome){
		ContentValues contentValues = new ContentValues();
		contentValues.put(Edital.TITULO, edital.getTitulo());
		
		String where = Edital.TITULO + "=?";
		String[] whereArgs = new String[]{nome};
		atualizar(contentValues, where, whereArgs);
	}
	
	public int atualizar(ContentValues valores, String where, String[] whereArgs){
		int count =  dbDatabase.update(TABELA_EDITAL, valores, where, whereArgs);
		Log.i("Tabela Edital", "Atualizou [ "+ count + " ] registros");
		return count;
	}
	
	public int deletar(String nome, String titulo){
		String where  = Edital.TITULO + "=?";
		String[] whereArgs = new String[] {nome};
		int count = deletar(where, whereArgs);
		return count;
	}
	
	public int deletar(String where, String[] whereArgs){
		int count = dbDatabase.delete(TABELA_EDITAL, where, whereArgs);
		Log.i("Tabela Edital", "Deletou [ "+ count + " ] registros");
		return count;
	}
	
	///
	
	public Cursor getCursor() {
		dbDatabase = contexto.openOrCreateDatabase(NOME_BANCO, Context.MODE_PRIVATE, null);
		try {
			return dbDatabase.query(TABELA_EDITAL, null, null, null, null, null, null);
		} catch (SQLiteException ex) {
			Log.e("Tabela Edital", "Erro ao buscar os editais." + ex.toString());
			return null;
		}
	}
	
	public List<Edital> listarEditais(){
		Cursor c = getCursor();
		
		List<Edital> editais = new ArrayList<Edital>();
		
		if(c.moveToFirst()){
			int idxTitulo = c.getColumnIndex(Edital.TITULO);
			
			do{
				Edital edital = new Edital();
				editais.add(edital);
				edital.setTitulo(c.getString(idxTitulo));
			} while(c.moveToNext());
		}
		return editais;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS " + TABELA_EDITAL + "("+Edital.TITULO + " TEXT PRIMARY KEY"+ ")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		db.execSQL("DROP TABLE IF EXISTS "+ TABELA_EDITAL);
		onCreate(db);
	}
}
