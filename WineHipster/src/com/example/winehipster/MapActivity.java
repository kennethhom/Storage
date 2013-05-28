package com.example.winehipster;
// hdhd
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity implements OnCameraChangeListener,  OnInfoWindowClickListener {
	private int userIcon, wineIcon;
	private GoogleMap theMap;
	private LocationManager locMan;
	private Marker userMarker;
	private Set<MarkerOptions> results; 
	private double lat, lng;
	private HashMap urls;
	Location lastUpdate;
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
			theMap.setOnCameraChangeListener(this);
			theMap.setOnInfoWindowClickListener(this);
			theMap.setMyLocationEnabled(true);
			System.out.println("MAP DONT WORK");
			urls = new HashMap();
			lastUpdate = new Location("lastupdate");
		}
		
		if(theMap != null){
			theMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			updatePlaces();
		}
	}

	@Override
	  public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.map_menu, menu);
	        return true;
	  }

	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	     switch (item.getItemId()) {
	       case R.id.normal :
	    	   theMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	    	   break;
	       case R.id.hybrid :
	    	   theMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
	    	   break;
	       case R.id.satellite :
	    	   theMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	    	   break;
	       case R.id.terrain :
	    	   theMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
	    	   break;
	     }
	     return super.onOptionsItemSelected(item);
	  }
	
	// Display the user's location
	private  void updatePlaces(){
		
		locMan = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		
		// Retrieve the user's last recorded location
		Location lastLoc = locMan.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		lat = lastLoc.getLatitude();
		lng = lastLoc.getLongitude();
		lastUpdate.setLatitude(lat);
		lastUpdate.setLongitude(lng);
		
		LatLng lastLatLng = new LatLng(lat, lng);
		
		// After the first time the marker is added to the map, when the user's
		// location is updated, the previous marker will be removed and replaced
		if(userMarker != null)
			userMarker.remove();
				
		// Adds marker for current location
//		userMarker = theMap.addMarker(new MarkerOptions()
//			.position(lastLatLng)
//			.title("You are here")
//			.icon(BitmapDescriptorFactory.fromResource(userIcon))
//			.snippet("Your last recorded location"));
//		
		// Camera centers at your location
		theMap.moveCamera(CameraUpdateFactory.newLatLng(lastLatLng));
		
		// fetch results
		results = new HashSet<MarkerOptions>();
//		Toast.makeText(getApplicationContext(), "Loading data..", Toast.LENGTH_SHORT).show();
		new GetPlaces().execute();
		
	}
	
	@Override
	 public void onCameraChange(CameraPosition position) {
	  Location newLocation = new Location("newLocation");
	  newLocation.setLatitude((float) position.target.latitude );
	  newLocation.setLongitude((float) position.target.longitude );
	  System.out.println((float) newLocation.distanceTo(lastUpdate));
	  if (newLocation.distanceTo(lastUpdate) > 30000) {
		  new GetPlaces().execute();
		  lastUpdate = newLocation;
	  }
	 }


	private class GetPlaces extends AsyncTask<Void,Void, HashSet<MarkerOptions>> {
		@Override
		protected void onCancelled() {
			super.onCancelled();
			Toast.makeText(getApplicationContext(), "Error loading data..", Toast.LENGTH_SHORT).show();
		}

		double cntr_long, cntr_lat;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			cntr_long = theMap.getCameraPosition().target.latitude;
			cntr_lat = theMap.getCameraPosition().target.longitude;
//			System.out.println("long is: " + cntr_long + "lat is: " +  cntr_lat);
		}

		@Override
		
		
		protected HashSet<MarkerOptions> doInBackground(Void... arg0) {
			String consumerKey = "ZWkxa7xlh2CoY9XEnP0JQg";
		    String consumerSecret = "L40KoPcPzNguyMSbKn_mEuV3PWw";
		    String token = "bP8bIc8mmMsyWAuxBD6queHqsrA94TXm";
		    String tokenSecret = "U6ne01kF0RHTTPFMy5WGWWJg7_0";
		    
		    HashSet<MarkerOptions> new_results = new HashSet<MarkerOptions>();
		    
		    Yelp yelp = new Yelp(consumerKey, consumerSecret, token, tokenSecret);
		    String response = yelp.search("winery", cntr_long, cntr_lat);
		    
		    try {
		      JSONObject json = new JSONObject(response);
		      JSONArray businesses = json.getJSONArray("businesses");

		      int count = businesses.length();
		      for (int i = 0; i < count; i++) {
		        JSONObject current = businesses.getJSONObject(i);

//		        System.out.println(current.getString("name"));
//		        System.out.println(current.getString("phone"));

		        JSONObject location = current.getJSONObject("location");
		        JSONObject coors = location.getJSONObject("coordinate");
		        
//		        String formattedNumber = PhoneNumberUtils.formatNumber(current.getString("phone"));
		        
		        new_results.add(new MarkerOptions()
				.position(new LatLng(coors.getDouble("latitude"),coors.getDouble("longitude")))
				.title(current.getString("name"))
				.snippet("Rating: "+ current.getString("rating")));

		        urls.put(current.get("name"), current.get("url"));
		        
//		        System.out.println(coors.getDouble("latitude"));
//		        System.out.println(coors.getDouble("longitude"));

//		        System.out.println("");
		      }
		    }
		    catch (Exception e) {
		    	e.printStackTrace(); 
		    	cancel(true);
		    	return null;
		    }
		return new_results;
		}
		
		@Override
		protected void onPostExecute(HashSet<MarkerOptions> new_results) {
			if(new_results == null)
				return;
			System.out.println(results.size() + " wineries loaded.");
//			Toast.makeText(getApplicationContext(),(results.size() + " wineries loaded"), Toast.LENGTH_SHORT).show();
			for(MarkerOptions item : new_results) {
				boolean add = true;
				for(MarkerOptions old: results) {
					if (old.getTitle().equals(item.getTitle()))
						add = false;
				}
				if(add) {
					theMap.addMarker(item);
					results.add(item);
				}
			}
	    }
	}


	@Override
	public void onInfoWindowClick(Marker clicked) {
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse((String) urls.get(clicked.getTitle())));
		startActivity(browserIntent);
	}


	
}
	
	


















