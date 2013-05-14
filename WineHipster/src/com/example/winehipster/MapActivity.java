package com.example.winehipster;
// hdhd
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
	private int userIcon, wineIcon;
	private GoogleMap theMap;
	private LocationManager locMan;
	private Marker userMarker;
	// test
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		userIcon = R.drawable.yellow_point;
		wineIcon = R.drawable.red_point;
		
		//Map not instantiated yet
		if(theMap == null){
			theMap = ((MapFragment)getFragmentManager().findFragmentById(R.id.the_map)).getMap();
			System.out.println("MAP DONT WORK");
		}
		
		if(theMap != null){
			theMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
			updatePlaces();
		}
	}

	// Display the user's location
	private  void updatePlaces(){
		
		locMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		
		// Retrieve the user's last recorded location
		Location lastLoc = locMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		double lat = lastLoc.getLatitude();
		double lng = lastLoc.getLongitude();
		
		LatLng lastLatLng = new LatLng(lat, lng);
		
		// After the first time the marker is added to the map, when the user's
		// location is updated, the previous marker will be removed and replaced
		if(userMarker != null)
			userMarker.remove();
				
		// Adds marker for current location
		userMarker = theMap.addMarker(new MarkerOptions()
			.position(lastLatLng)
			.title("You are here")
			.icon(BitmapDescriptorFactory.fromResource(userIcon))
			.snippet("Your last recorded location"));
		
		// Camera centers at your location
		theMap.animateCamera(CameraUpdateFactory.newLatLng(lastLatLng), 3000, null);
	
		String placesSearchStr = "https://maps.googleapis.com/maps/api/place/nearbysearch/" +
				"json?location="+lat+","+lng+
				"&radius=1000&sensor=true" +
				"&types=food" +
				"&key=AIzaSyAemyzAK19nxjFynNPKBykglWaUoUNFZSg";
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

class GetPlaces extends AsyncTask<String, Void, String> {	
	@Override
	protected String doInBackground(String... placesURL){
		StringBuilder placesBuilder = new StringBuilder();
		
		// process search parameter string(s)
		for(String placeSearchURL : placesURL){
			HttpClient placesClient = new DefaultHttpClient();
			
			try {
				// Create an Http Get object
				HttpGet placesGet = new HttpGet(placeSearchURL);
				
				// Retrieving an HTTP Response
				HttpResponse placesResponse = placesClient.execute(placesGet);
				
				// Retrieve the status line. Check for positive response
				StatusLine placeSearchStatus = placesResponse.getStatusLine();
				
				// Can only continue if 200 "OK" status code
				if(placeSearchStatus.getStatusCode() == 200) {
					HttpEntity placesEntity = placesResponse.getEntity();
					
					// Retrieve the content of the response
					InputStream placesContent = placesEntity.getContent();
					
					// Create reader for stream
					InputStreamReader placesInput = new InputStreamReader(placesContent);
					
					// Carry out input Stream processing using Buffered Reader
					BufferedReader placesReader = new BufferedReader(placesInput);
					
					String lineIn;
					while((lineIn = placesReader.readLine()) != null){
						placesBuilder.append(lineIn);
					}
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return placesBuilder.toString();
	}
}

