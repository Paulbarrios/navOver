package com.example.navover;



import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.ActivityCompat;
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
		 
	     
	     //getActionBar().setDisplayHomeAsUpEnabled(true);
	     getActionBar().setDisplayHomeAsUpEnabled(true);
	     toolbar.setNavigationIcon(R.drawable.ic_drawer);
	     toolbar.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 drawerLayout.openDrawer(Gravity.START);
             }
         });
	     selectItem(0);
	     
	     
	     



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
	        selectItem(position);
	    }

	}
	
	public void selectItem(int position) {
	    // Create a new fragment and specify the planet to show based on position
		Fragment fragment = null;
		 
        switch (position) {
            case 0:
                fragment = new FragmentPerfil();
                break;
            case 1:
                fragment = new FragmentLista();
                break;
        }

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



