package ca.cmdann.thesights.thesights;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.PushService;

import java.util.List;

public class MainMapsActivity extends FragmentActivity {

    private final String KEY1 = "";
    private final String KEY2 = "";

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_maps);
        setUpParse();
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    public void setUpParse(){
        Parse.initialize(this, KEY1, KEY2);
        PushService.setDefaultPushCallback(this, MainMapsActivity.class);
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
//        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));

        create_map_pins();
    }

    // Get the pins from parse
    public void create_map_pins(){

        // Say we are querying for markers
        ParseQuery<ParseObject> query = ParseQuery.getQuery("markers");

        // Set the query to look for some constraint
        query.whereEqualTo("username", "student");

        // Had to manually import
        // import com.parse.ParseException;
        // This is weird because auto import should work.

        // Async get the results from Parse
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> pins, ParseException e) {

                // No error present!
                if (e == null) {
                    Log.d("score", "Retrieved " + pins.size() + " scores");
//                    mMap.addMarker(new MarkerOptions().position(new LatLng(pin, 0pin).title("Marker"));

                    for (int i = 0; i < pins.size(); i++) {
                        ParseObject current_pin = pins.get(i);

                        float current_lat = current_pin.getNumber("lat").floatValue();
                        float current_lng = current_pin.getNumber("lng").floatValue();

                        mMap.addMarker(new MarkerOptions().position(new LatLng(current_lat, current_lng)));

                        if (i == 0){
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(current_lat, current_lng), 18));
                        }
                    }
                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });
    }
}
