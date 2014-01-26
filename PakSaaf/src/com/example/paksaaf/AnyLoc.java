package com.example.paksaaf;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class AnyLoc extends Activity {
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.any_loc);
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
    Intent intent = new Intent(this, SubmitAnyLoc.class);
    EditText latitude = (EditText) findViewById(R.id.latitude);
	String lat = latitude.getText().toString();
	EditText longitude = (EditText) findViewById(R.id.longitude);
	String lon = longitude.getText().toString();
	String loc = (lat + "\n" + lon);
	intent.putExtra(EXTRA_MESSAGE, loc);
    startActivity(intent);
    }

}
