package br.edu.ifrn.sigepi.adapter;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifrn.sigepi.R;
import br.edu.ifrn.sigepi.modelo.Edital;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListaEditalAdapter extends BaseAdapter {
	
	private List<Edital> edital;
	private List<Edital> editalBKP;
	private Activity context;
	private SharedPreferences pref;

	public ListaEditalAdapter( Activity context,List<Edital> edital) {
		super();
		this.edital = edital;
		this.editalBKP = edital;
		this.context = context;
		pref = context.getSharedPreferences("config", Context.MODE_PRIVATE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return edital.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return edital.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	class ViewHolder {
		ImageView icone;
		TextView codigo;
		TextView cliente;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View layout = (View) convertView;
		
		ViewHolder holder = new ViewHolder();
		
		if (layout == null){
			layout = (View) context.getLayoutInflater().inflate(R.layout.item_lista_rota, null);
			
			holder.icone = (ImageView) layout.findViewById(R.id.item_lista_medido);
			holder.codigo = (TextView) layout.findViewById(R.id.item_lista_codigo);
			holder.cliente = (TextView) layout.findViewById(R.id.item_lista_cliente);
			layout.setTag(holder);

		} 
		
		holder = (ViewHolder) layout.getTag();
		
		return layout;
	}

	public void filter(String charText) {

		List<Edital> med = new ArrayList<Edital>();
		
        for (Edital e : editalBKP) {
            if ( e.getTitulo().toLowerCase().contains(charText) )            		
            {
                med.add(e);
            }
        }
        
        this.edital = med;
        notifyDataSetChanged();
	}
	
}
