package com.example.paksaaf;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Submit extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit);
		Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		TextView curloc = (TextView)  findViewById(R.id.curloc);
		String lat_string = Double.toString(MyLocationListener.latitude);
    	String lon_string = Double.toString(MyLocationListener.longitude);
    	curloc.setText("Your current location is:" + "\n" + lat_string + "\n"  + lon_string);
    	curloc.setTypeface(font);
    	Button submit = (Button) findViewById(R.id.submit);
    	submit.setTypeface(font);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.submit, menu);
		return true;
	}

	public void submit(View view) {
		Intent submit = new Intent(this,ThankYou.class);
		startActivity(submit);
	}

}
