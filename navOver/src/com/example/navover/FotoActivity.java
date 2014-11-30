package com.example.navover;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toolbar;
import android.support.v4.app.NavUtils;

public class FotoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foto);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
	     setActionBar(toolbar);
	     getActionBar().setDisplayHomeAsUpEnabled(true);
	     
	     int imagenId = 0;
	     Bundle extras = getIntent().getExtras();
	     if (extras != null) {
	    	 imagenId = extras.getInt("idImage", 0);
	     }

	     
	     ImageView image = (ImageView)findViewById(R.id.imagenMax);
	     image.setImageResource(imagenId);

	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    
	    case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
	
	
}
