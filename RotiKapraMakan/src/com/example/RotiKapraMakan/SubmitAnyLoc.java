package com.example.RotiKapraMakan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubmitAnyLoc extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit_any_loc);
		Intent intent = getIntent();
		String message = intent.getStringExtra(AnyLoc.EXTRA_MESSAGE);
		Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		TextView curloc = (TextView)  findViewById(R.id.curloc);
    	curloc.setText("The location you want to report is:" + "\n" + message);
    	curloc.setTypeface(font);
    	Button submit = (Button) findViewById(R.id.submit);
    	submit.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.submit_any_loc, menu);
		return true;
	}

	public void submit(View view) {
		Intent submit = new Intent(this,ThankYou.class);
		startActivity(submit);
	}
}
