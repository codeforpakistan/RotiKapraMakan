package com.example.RotiKapraMakan;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThankYou extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thank_you);
		TextView thankyou = (TextView)  findViewById(R.id.thankyou);
		Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		thankyou.setTypeface(font);
		Button home = (Button) findViewById(R.id.home);
		home.setTypeface(font);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.thank_you, menu);
		return true;
	}
	public void home(View view) {
		Intent home = new Intent(this,Main.class);
		startActivity(home);
	}
}
