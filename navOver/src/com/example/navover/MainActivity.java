package com.example.navover;



import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends ActionBarActivity {
	
	 private String[] listaMenu;
	 private ListView drawerList;
	 private DrawerLayout drawerLayout;
	 private LinearLayout drawerLeft;
	 private String tituloSeccion;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		drawerList = (ListView) findViewById(R.id.left_drawer_list);
		drawerLeft = (LinearLayout) findViewById(R.id.left_drawer);
		
		listaMenu = getResources().getStringArray(R.array.menuLista);
		 drawerList.setAdapter(new ArrayAdapter<String>(this,
	                android.R.layout.simple_list_item_1, listaMenu));
		 drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		 
		 drawerList.setOnItemClickListener(new DrawerItemClickListener());
		 
		 Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	     setActionBar(toolbar);
		 
	     
	     getActionBar().setDisplayHomeAsUpEnabled(true);
	     toolbar.setNavigationIcon(R.drawable.ic_drawer);
	     toolbar.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 drawerLayout.openDrawer(Gravity.START);
             }
         });
	     
	     Bundle extras = getIntent().getExtras();
	     if(extras != null){
	    	 if (extras.getBoolean("voy") == true) {
		    	 selectItem(0, extras);
		     }else{
		    	 selectItem(1, null);
		     }
	     }else{
	    	 selectItem(1, null);
	     }
	     
	     
	     
	     
	     



	}
	
	protected boolean isNavDrawerOpen() {
        return drawerLayout != null && drawerLayout.isDrawerOpen(Gravity.START);
    }
	
	protected void closeNavDrawer() {
        if (drawerLayout != null) {
            drawerLayout.closeDrawer(Gravity.START);
        }
    }


	@Override
    public void onBackPressed() {
        if (isNavDrawerOpen()) {
            closeNavDrawer();
        } else {
            super.onBackPressed();
        }
    }
	
	private class DrawerItemClickListener implements ListView.OnItemClickListener {
	    @Override
	    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        selectItem(position, null);
	    }

	}
	
	public void selectItem(int position, Bundle extras) {
	    
		Fragment fragment = null;
		 
        switch (position) {
            case 0:
            	fragment = new FragmentPerfil();
				if(extras != null){
				   fragment.setArguments(extras);         		
				}
                break;
            case 1:
                fragment = new FragmentLista();
                break;
            case 2:
            	FragmentManager fragmentManager =
        		getFragmentManager();
            	DialogoAccesoCamara dialogo = new DialogoAccesoCamara();
            	dialogo.show(fragmentManager, "tag");

                
                break;
        }

        if(fragment != null){
        	FragmentManager fragmentManager =
            		getFragmentManager();

            fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

            drawerList.setItemChecked(position, true);

            tituloSeccion = listaMenu[position];
            getActionBar().setTitle(tituloSeccion);

            drawerLayout.closeDrawer(drawerLeft);
        }
        
	}
	
	public void editar(View v) {
		 	Intent inten = new Intent(this, EditarPerfil.class);
	        startActivity(inten);
	}
	
	public class DialogoAccesoCamara extends DialogFragment {
	    @Override
	    public Dialog onCreateDialog(Bundle savedInstanceState) {
	 
	        AlertDialog.Builder builder =
	                new AlertDialog.Builder(getActivity());
	 
	        builder.setMessage("Esta opción aun no esta diponible, pero igualemente puede accerder a la camara.")
	        .setTitle("Tomar foto")
	        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener()  {
	               public void onClick(DialogInterface dialog, int id) {
	            	   	Intent inten = new Intent("android.media.action.IMAGE_CAPTURE");
	                    startActivityForResult(inten, 0);
	                        dialog.cancel();
	                   }
	               })
	        .setNegativeButton("Volver", new DialogInterface.OnClickListener() {
	               public void onClick(DialogInterface dialog, int id) {
	                        dialog.cancel();
	                   }
	               });
	 
	        return builder.create();
	    }
	}
}



