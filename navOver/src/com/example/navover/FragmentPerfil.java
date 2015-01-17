package com.example.navover;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentPerfil extends Fragment{
	

	
	@Override
    public View onCreateView(
        LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_perfil, container, false);
		
		
		if(getArguments() != null){
			
			TextView nombre = (TextView) v.findViewById(R.id.nombreContenido);
			nombre.setText(getArguments().getString("nombre"));
			
			TextView apellidos = (TextView) v.findViewById(R.id.apellidosContenido);
			apellidos.setText(getArguments().getString("apellidos"));
			
			TextView correo = (TextView) v.findViewById(R.id.emailContenido);
			correo.setText(getArguments().getString("correo"));
			
			TextView sexo = (TextView) v.findViewById(R.id.sexoContenedor);
			sexo.setText(getArguments().getString("sexo"));
			
			TextView fotografoCheck = (TextView) v.findViewById(R.id.fotografoContenido);
			fotografoCheck.setText(getArguments().getString("fotografoCheck"));
			
			TextView pais = (TextView) v.findViewById(R.id.paisContenido);
			pais.setText(getArguments().getString("pais"));
			
			 Context contexto = getActivity().getApplicationContext();
			 
			 View toast_layout = inflater.inflate(R.layout.toast,
						(ViewGroup) v.findViewById(R.id.toastPersonalizada));
			 TextView text = (TextView) toast_layout.findViewById(R.id.text);
			 text.setText(R.string.tostada);
			 Toast tostada = new Toast(contexto.getApplicationContext());
			 tostada.setDuration(Toast.LENGTH_SHORT);
			 tostada.setView(toast_layout);
			 tostada.show();
			
		}
		
		
		
		
		
		
		
		
		
	    
        
        return v;
    }
	
	
}