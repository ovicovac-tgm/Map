package com.example.vicovaol.map;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {
    Button button1;
    private static final String TAG = MainActivity.class.getSimpleName();
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {
        final FloatingActionButton fab = findViewById(R.id.button1);
        final FloatingActionButton fab2 = findViewById(R.id.button2);
        final MarkerOptions markerOptions = new MarkerOptions();
        final CircleOptions circleOptions= new CircleOptions();
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(48.210033, 16.363449)));

        LatLng latLng = new LatLng(48.210033, 16.363449);

        markerOptions.position(latLng);
        googleMap.addMarker(markerOptions);

//        circleOptions.center(latLng);
//        circleOptions.radius(20000);
//        circleOptions.fillColor(1);
//        googleMap.addCircle(circleOptions);




        fab.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                            final boolean success = googleMap.setMapStyle(
                                    MapStyleOptions.loadRawResourceStyle(
                                            context, R.raw.style_json));

                            googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(48.210033, 16.363449)));

                    }
                });

        fab2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                        final boolean success = googleMap.setMapStyle(
                                MapStyleOptions.loadRawResourceStyle(
                                        context, R.raw.style_json_default));

                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(48.210033, 16.363449)));
                    }
                });
    }
}