package com.example.RotiKapraMakan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class eEtc extends Activity implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		Button b=(Button) findViewById(R.id.yes);
		b.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View arg0) {
		Intent i=new Intent(this,ThankYou.class);
		startActivity(i);
		
	}

	
	
	

}
