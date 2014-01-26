package com.example.paksaaf;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SubmitPhoto extends Activity {
    private static final String TAG = "MainActivity.java";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submit_photo);
		ImageView image = (ImageView)this.findViewById(R.id.photo);
        image.setImageBitmap(Camera.photo);        
        Typeface font = Typeface.createFromAsset(this.getAssets(), "fonts/HelveticaNeueLTStd-Th.otf");
		TextView curloc = (TextView)  findViewById(R.id.curloc);
		String lat_string = Double.toString(MyLocationListener.latitude);
    	String lon_string = Double.toString(MyLocationListener.longitude);
    	curloc.setText("Your current location is:" + "\n" + lat_string + "\n"  + lon_string);
    	curloc.setTypeface(font);
    	Button submit = (Button) findViewById(R.id.submit);
    	submit.setTypeface(font);
    	TextView phototext = (TextView) findViewById(R.id.phototext);
    	phototext.setTypeface(font);
    	
    	new PostDataAsyncTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.submit_photo, menu);
		return true;
	}

	public void submit(View view) {
		Intent submit = new Intent(this,ThankYou.class);
		startActivity(submit);
	}
    public class PostDataAsyncTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            // do stuff before posting data
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                // 1 = post text data, 2 = post file
                int actionChoice = 3;
                
                // post a text data
                if(actionChoice==3){
                    postText();
                    postFile();
                }
                
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String lenghtOfFile) {
            // do stuff after posting data
        }
    }
 // this will post our text data
    private void postText(){
        try{
            // url where the data will be posted
            String postReceiverUrl = "http://10.103.1.204/~Gohar/bilalba.php";
            Log.v(TAG, "postURL: " + postReceiverUrl);
            
            // HttpClient
            HttpClient httpClient = new DefaultHttpClient();
            
            // post header
            HttpPost httpPost = new HttpPost(postReceiverUrl);
    
            // add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("latitude", "31.54669"));
            nameValuePairs.add(new BasicNameValuePair("longitude", "74.33093"));
            nameValuePairs.add(new BasicNameValuePair("country_name", "Pakistan"));
            nameValuePairs.add(new BasicNameValuePair("incident_zoom", "12"));
            nameValuePairs.add(new BasicNameValuePair("form_id", ""));
            nameValuePairs.add(new BasicNameValuePair("incident_title", "Lahore garbage"));
            nameValuePairs.add(new BasicNameValuePair("incident_description", "Dumpsite"));
            nameValuePairs.add(new BasicNameValuePair("incident_date", "01/26/2014"));
            nameValuePairs.add(new BasicNameValuePair("incident_hour", "08"));
            nameValuePairs.add(new BasicNameValuePair("incident_minute", "03"));
            nameValuePairs.add(new BasicNameValuePair("incident_ampm", "pm"));
            nameValuePairs.add(new BasicNameValuePair("incident_category[]", "3"));
            nameValuePairs.add(new BasicNameValuePair("person_first", "admin"));
            nameValuePairs.add(new BasicNameValuePair("person_last", ""));
            nameValuePairs.add(new BasicNameValuePair("person_email", "admin@paksaaf.com"));
            nameValuePairs.add(new BasicNameValuePair("geometry_label", ""));
            nameValuePairs.add(new BasicNameValuePair("geometry_comment", ""));
            nameValuePairs.add(new BasicNameValuePair("geometry_strokewidth", "2.5"));
            nameValuePairs.add(new BasicNameValuePair("location_name", "Lahore"));
            nameValuePairs.add(new BasicNameValuePair("OpenLayers_Control_LayerSwitcher_25_baseLayers", "Google Maps Normal"));
            nameValuePairs.add(new BasicNameValuePair("incident_news[]", ""));
            // IMAGE MISSINGGGGGGGGGGGGGGGGG
            nameValuePairs.add(new BasicNameValuePair("category_name", "3"));
            nameValuePairs.add(new BasicNameValuePair("geometry_lat", ""));
            nameValuePairs.add(new BasicNameValuePair("geometry_lon", ""));
            nameValuePairs.add(new BasicNameValuePair("video_id", "1"));
            nameValuePairs.add(new BasicNameValuePair("photo_id", "1"));
            nameValuePairs.add(new BasicNameValuePair("incident_video[]", ""));
            nameValuePairs.add(new BasicNameValuePair("form_auth_token", "9a43dc8b79d56874f9b04d5d9669173669de52189a8cda90a0bc13c9323e299a"));
            nameValuePairs.add(new BasicNameValuePair("submit", "Submit"));
            
            
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
    
            // execute HTTP post request
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            
            if (resEntity != null) {
                
                String responseStr = EntityUtils.toString(resEntity).trim();
                Log.v(TAG, "Response: " +  responseStr);
                
                // you can add an if statement here and do other actions based on the response
            }
            
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // will post our text file
    private void postFile(){
        try{
            
            // the file to be posted
            String textFile = Environment.getExternalStorageDirectory() + "/PakSaaf/" + "abc.jpg";
            Log.v(TAG, "textFile: " + textFile);
            
            // the URL where the file will be posted
            String postReceiverUrl = "http://10.103.1.204/~Gohar/bilalba.php";
            Log.v(TAG, "postURL: " + postReceiverUrl);
            
            // new HttpClient
            HttpClient httpClient = new DefaultHttpClient();
            
            // post header
            HttpPost httpPost = new HttpPost(postReceiverUrl);
            
            // incident_photo[]
            File file = new File(textFile);
            FileBody fileBody = new FileBody(file);
    
            MultipartEntity reqEntity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);
            reqEntity.addPart("file", fileBody);
            httpPost.setEntity(reqEntity);
            
            // execute HTTP post request
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
    
            if (resEntity != null) {
                
                String responseStr = EntityUtils.toString(resEntity).trim();
                Log.v(TAG, "Response: " +  responseStr);
                
                // you can add an if statement here and do other actions based on the response
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
