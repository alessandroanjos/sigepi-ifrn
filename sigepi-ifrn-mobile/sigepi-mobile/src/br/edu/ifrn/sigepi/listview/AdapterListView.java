package br.edu.ifrn.sigepi.listview;

import java.util.ArrayList;

import br.edu.ifrn.sigepi.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class AdapterListView extends BaseAdapter{

	private LayoutInflater mInflater;
    private ArrayList<ItemListViewEdital> itens;

    public AdapterListView(Context context, ArrayList<ItemListViewEdital> itens) {
        this.itens = itens;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return itens.size();
    }

    public ItemListViewEdital getItem(int position) {
        return itens.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        ItemListViewEdital item = itens.get(position);
        view = mInflater.inflate(R.layout.item_lista_rota, null);

        ((TextView) view.findViewById(R.id.item_lista_cliente)).setText(item.getTexto());
     
        return view;
    }
}
