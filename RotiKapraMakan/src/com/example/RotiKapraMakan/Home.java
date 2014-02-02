package com.example.RotiKapraMakan;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends Activity {
	
	
	String lat_string = "Latitude";
	String lon_string = "Longitude";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent report = getIntent();
		setContentView(R.layout.home);
		Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		final TextView loc = (TextView)  findViewById(R.id.location);
		loc.setTypeface(font);
		Button anyloc = (Button) findViewById(R.id.anyloc);
		Button curloc = (Button) findViewById(R.id.curloc);
		anyloc.setTypeface(font);
		curloc.setTypeface(font);
		}
	
	public void anyloc(View view) {
		Intent anyloc = new Intent(this,AnyLoc.class);
		startActivity(anyloc);
	}
	
	public void curloc(View view) {
	        	 LocationManager mlocManager=null;  
	             LocationListener mlocListener;  
	             mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);  
	             mlocListener = new MyLocationListener();  
	             mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
	             
	            if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {  
	            	if(MyLocationListener.latitude>=0)
               	{
	            		
	            		final TextView loc = (TextView)  findViewById(R.id.location);
	            		
	                	lat_string = Double.toString(MyLocationListener.latitude);
	                	lon_string = Double.toString(MyLocationListener.longitude);
	                	loc.setText((lat_string + "\n"  + lon_string));
               	}
	            
	         }
	            	Intent p= new Intent(this,eEtc.class);
	            	startActivity(p);
	     

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	} 
        
    
}
