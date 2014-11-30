package com.example.navover;


import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentLista extends Fragment{
	
	private String[] titulos; 
	private String[] subtitulos;
	private TypedArray  imagenes;
	private ElementosLista[] datos;
	private ListView listaFotos;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		 if(isAdded()){
			 	titulos = getResources().getStringArray(R.array.titulos);
			 	subtitulos = getResources().getStringArray(R.array.subtitulos);
			 	imagenes = getResources().obtainTypedArray(R.array.imagenes);
		 }
		 
		 
		datos = new ElementosLista[titulos.length];
		for (int i = 0; i < titulos.length; i++) {
			datos[i] = new ElementosLista(titulos[i], subtitulos[i], imagenes.getResourceId(i, 1));
		}
		imagenes.recycle();
		View v = inflater.inflate(R.layout.fragment_list, container, false);
		AdaptadorListaFotos adaptador = new AdaptadorListaFotos(getActivity());
		

		listaFotos = (ListView)v.findViewById(R.id.lista_fotos);
		listaFotos.setAdapter(adaptador);
		
		listaFotos.setOnItemClickListener(new ListItemClickListener());
    	
    		
    	    
        return v;
    }
	
	private class ListItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView<?> a, View view, int position, long id) {
	    	String opcionSeleccionada =((ElementosLista)a.getAdapter().getItem(position)).getTitulo();
	    	
	        getActivity().getActionBar().setTitle(opcionSeleccionada);
	        Intent inten = new Intent(getActivity(), FotoActivity.class);
	        inten.putExtra("idImage", ((ElementosLista)a.getAdapter().getItem(position)).getFoto());
	        getActivity().startActivity(inten);
	    }

	}
	
	static class ViewHolder {
	    TextView titulo;
	    TextView subtitulo;
	    ImageView image;
	}
	
	class AdaptadorListaFotos extends ArrayAdapter {
		 
	    Activity context;
	 
	        AdaptadorListaFotos(Activity context) {
	            super(context, R.layout.elemento_lista, datos);
	            this.context = context;
	        }
	 
	        public View getView(int position, View convertView, ViewGroup parent) {
	        	
	        View item = convertView;
	        ViewHolder holder;
	        
	        if(item == null)
	        {
	            LayoutInflater inflater = context.getLayoutInflater();
	            item = inflater.inflate(R.layout.elemento_lista, null);
	     
	            holder = new ViewHolder();
	            holder.titulo = (TextView)item.findViewById(R.id.Titulo);
	            holder.subtitulo = (TextView)item.findViewById(R.id.SubTitulo);
	            holder.image = (ImageView)item.findViewById(R.id.image);
	     
	            item.setTag(holder);
	        }
	        else
	        {
	            holder = (ViewHolder)item.getTag();
	        }
	     
	        holder.titulo.setText(datos[position].getTitulo());
	        holder.subtitulo.setText(datos[position].getSubtitulo());
	        holder.image.setImageResource(datos[position].getFoto());
	        return(item);
	        
	    }
	}
}
