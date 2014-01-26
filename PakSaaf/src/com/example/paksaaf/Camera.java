package com.example.paksaaf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Camera extends Activity {
	File file = null;
	private static final int CAMERA_REQUEST = 1888;
	public static Bitmap photo = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		TextView takepic = (TextView)  findViewById(R.id.takepic);
		takepic.setTypeface(font);
		Button no = (Button) findViewById(R.id.no);
		no.setTypeface(font);
	
		Button yes = (Button) this.findViewById(R.id.yes);
		yes.setTypeface(font);
		yes.setOnClickListener(new View.OnClickListener() {
			
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
                startActivityForResult(cameraIntent, CAMERA_REQUEST); 
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
		return true;
	}
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {  
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {  
            photo = (Bitmap) data.getExtras().get("data"); 
            Intent submitwithphoto = new Intent(this, SubmitPhoto.class);
            startActivity(submitwithphoto);
            String path = Environment.getExternalStorageDirectory().toString();
            OutputStream fOutputStream = null;
            file = new File(path + "/PakSaaf/", "abc.jpg");
            try {
                fOutputStream = new FileOutputStream(file);

                photo.compress(Bitmap.CompressFormat.JPEG, 100, fOutputStream);

                fOutputStream.flush();
                fOutputStream.close();

                MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
                return;
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Save Failed", Toast.LENGTH_SHORT).show();
                return;
            }
            
        }
    }
	public void no(View view) {
		Intent submit = new Intent(this,Submit.class);
		startActivity(submit);
	}
	

}
