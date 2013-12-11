package br.edu.ifrn.sigepi.adapter;

import br.edu.ifrn.sigepi.R;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MenuProjetosAdapter extends BaseAdapter {

	private String[] menus;
	
	private TypedArray icones;
	
	private Activity context;
	
	private boolean admin = false;
	
	public MenuProjetosAdapter(Activity context, boolean admin){
		this.context = context;
		this.admin = admin;
		this.menus = context.getResources().getStringArray(R.array.itens_menu_projetos);
		this.icones = context.getResources().obtainTypedArray(R.array.icones_menu_projetos);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menus.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return menus[arg0];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public class ViewHolder {
		ImageView icone;
		TextView menu;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		View layout;
		
		if (convertView == null){
			layout = (View) context.getLayoutInflater().inflate(R.layout.item_grid, null);
			holder = new ViewHolder();
			
			holder.icone = (ImageView) layout.findViewById(R.id.icone_item_image);
			holder.menu = (TextView) layout.findViewById(R.id.grid_item_label);
			
			holder.icone.setImageDrawable(icones.getDrawable(position));
			holder.menu.setText(menus[position]);
			
			layout.setTag(menus[position]);
			
			Typeface face = Typeface.createFromAsset(context.getAssets(),"font/GothamLight.otf");
			holder.menu.setTypeface(face);
			
			if ((position == 3 || position == 1) && !admin){
				layout = new View(context);
			}
			
		} else {
			layout = (View) convertView;
		}
		
		return layout;
	}

}
