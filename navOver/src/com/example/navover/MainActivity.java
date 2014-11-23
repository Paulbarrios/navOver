package com.example.navover;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	 private String[] mPlanetTitles;
	 private ListView mDrawerList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);
		
		mPlanetTitles = getResources().getStringArray(R.array.planets_array);
		 mDrawerList.setAdapter(new ArrayAdapter<String>(this,
	                android.R.layout.simple_list_item_1, mPlanetTitles));

	    // Now retrieve the DrawerLayout so that we can set the status bar color.
	    // This only takes effect on Lollipop, or when using translucentStatusBar
	    // on KitKat.

	}
}
