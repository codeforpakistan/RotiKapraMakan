package com.example.RotiKapraMakan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class AnyLoc extends Activity implements OnItemSelectedListener {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
String loc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.any_loc);
		Spinner spinner= (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter <CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.Districts, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
		
		// Show the Up button in the action bar.
		setupActionBar();
		Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		Button submit = (Button)  findViewById(R.id.submit);
		submit.setTypeface(font);
		TextView location = (TextView)  findViewById(R.id.location);
		location.setTypeface(font);
	    	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.any_loc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

    public void submit (View view) {
    Intent intent = new Intent(this, eEtc.class);
    
	
	
	
	
	intent.putExtra(EXTRA_MESSAGE, loc);
    startActivity(intent);
    }

	@Override
	public void onItemSelected(AdapterView<?> prent, View arg1, int pos,
			long arg3) {
		
	    
		loc=  prent.getItemAtPosition(pos).toString();
		
		
		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg) {
	Toast.makeText(this, "Please Select a District", Toast.LENGTH_LONG).show();
		
	}

}
