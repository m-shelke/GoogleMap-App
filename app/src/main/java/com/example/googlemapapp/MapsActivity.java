package com.example.googlemapapp;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.googlemapapp.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.Objects;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMapsBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng pachod = new LatLng(19.57735019370233, 75.61142968743317);
        mMap.addMarker(new MarkerOptions().position(pachod).title("Marker in Pachod Bk"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pachod));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pachod,17f));

        mMap.addCircle(new CircleOptions()
                .center(pachod)
                .radius(500)
                .fillColor(Color.BLUE)
                .strokeColor(Color.DKGRAY));

        mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(19.57735019370233, 75.61142968743317))
                .add(new LatLng(12.57735085370233, 76.61142568743317))
                .add(new LatLng(18.51235019370233, 74.61142974143317))
                .add(new LatLng(21.57735012580233, 77.61142996343317))
                .add(new LatLng(16.57735011590233, 73.61135168743317))
                .fillColor(Color.GREEN)
                .strokeColor(Color.DKGRAY));

        Objects.requireNonNull(mMap.addGroundOverlay(new GroundOverlayOptions()
                        .position(pachod, 50f, 50f)
                        .image(BitmapDescriptorFactory.fromResource(R.drawable.bitmap))))
                .isClickable();
    }
}