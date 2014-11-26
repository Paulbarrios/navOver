package com.example.navover;


import android.app.Activity;
import android.app.Fragment;
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
	private int[] imagenes;
	private ElementosLista[] datos;
	private ListView listaFotos;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		
		 if(isAdded()){
			 	titulos = getResources().getStringArray(R.array.titulos);
			 	subtitulos = getResources().getStringArray(R.array.subtitulos);
			 	imagenes = getResources().getIntArray(R.array.subtitulos);
		 }
		 
		datos = new ElementosLista[titulos.length];
		for (int i = 0; i < titulos.length; i++) {
			datos[i] = new ElementosLista(titulos[i], subtitulos[i], imagenes[i]);
		}
		
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
	    }

	}
	
	class AdaptadorListaFotos extends ArrayAdapter {
		 
	    Activity context;
	 
	        AdaptadorListaFotos(Activity context) {
	            super(context, R.layout.elemento_lista, datos);
	            this.context = context;
	        }
	 
	        public View getView(int position, View convertView, ViewGroup parent) {
	        LayoutInflater inflater = context.getLayoutInflater();
	        View item = inflater.inflate(R.layout.elemento_lista, null);
	 
	        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
	        lblTitulo.setText(datos[position].getTitulo());
	 
	        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
	        lblSubtitulo.setText(datos[position].getSubtitulo());
	        
	        ImageView image = (ImageView)item.findViewById(R.id.image);
	        image.setImageResource(datos[position].getFoto());
	 
	        return(item);
	    }
	}
}
