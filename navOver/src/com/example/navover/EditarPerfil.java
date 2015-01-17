package com.example.navover;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toolbar;

public class EditarPerfil extends Activity {
	private String pais = "España";
	private String fotografoCheck = "Si";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_editar_perfil);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	    setActionBar(toolbar);
	    getActionBar().setTitle("Editar Perfil");
	    
	    ArrayAdapter<CharSequence> adapter =
	    	    ArrayAdapter.createFromResource(this,
	    	        R.array.paises,
	    	        android.R.layout.simple_spinner_item);
	    
	    Spinner paises = (Spinner)findViewById(R.id.editPais);
	    
	    adapter.setDropDownViewResource(
	            android.R.layout.simple_spinner_dropdown_item);
	    
	    paises.setAdapter(adapter);
	    
	    
	    paises.setOnItemSelectedListener(
	            new AdapterView.OnItemSelectedListener() {
	                public void onItemSelected(AdapterView<?> parent,
	                    android.view.View v, int position, long id) {
	                	pais = (String) parent.getItemAtPosition(position);
	                       
	                }
	         
	                public void onNothingSelected(AdapterView<?> parent) {
	                	
	                }
	        });
	    
	    CheckBox fotografo = (CheckBox) findViewById(R.id.editFotografo);
	    
	    fotografo.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
	    	@Override
	    	public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					fotografoCheck = "Si";
				} else {
					fotografoCheck = "No";
				}
			}
		});
	    
	    
	    

	}
	
	
	
	public void guardar(View v){
		
		RadioGroup radiogroup = (RadioGroup) findViewById(R.id.grpSexo);
	    
	    RadioButton seleccionado = (RadioButton)findViewById(radiogroup.getCheckedRadioButtonId());
	    String sexo;
	    if(seleccionado != null){
	    	sexo = (String) seleccionado.getText();	  
	    }else{
	    	sexo = "Hombre";
	    }
	      
		
	    EditText nombre = (EditText) findViewById(R.id.editNombre);
	    EditText apellidos = (EditText) findViewById(R.id.editApellidos);
	    EditText correo = (EditText) findViewById(R.id.editCorreo);
	  
		
		Intent inten = new Intent(this, MainActivity.class);
		inten.putExtra("nombre", nombre.getText().toString());
		inten.putExtra("apellidos", apellidos.getText().toString());
		inten.putExtra("correo", correo.getText().toString());
		inten.putExtra("sexo",sexo);
		inten.putExtra("fotografoCheck",fotografoCheck);
		inten.putExtra("pais", pais);
		inten.putExtra("voy", true);
		startActivity(inten);
	}
}
