package com.example.chango.googlemapsapi;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;

public class MainActivity extends android.support.v4.app.FragmentActivity implements OnMapReadyCallback{

    private GoogleMap gMap;
    private CameraUpdate mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    private void setUpMap() {
        gMap.addMarker(new MarkerOptions().position(new LatLng(-12.017124,
                -77.050744)).title("Facultad de Ciencias").icon(BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_CYAN))
                .snippet("The beast School"));
        mCamera = CameraUpdateFactory.newLatLngZoom(new LatLng(
                -12.017124, -77.050744), 0);
        gMap.animateCamera(mCamera);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        setUpMap();
    }
}
