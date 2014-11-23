package com.example.navover;



import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	 private String[] listaMenu;
	 private ListView drawerList;
	 private DrawerLayout drawerLayout;
	 private LinearLayout drawerLeft;

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

        //tituloSeccion = opcionesMenu[position];
        //getSupportActionBar().setTitle(tituloSeccion);

        drawerLayout.closeDrawer(drawerLeft);
	}
}



