package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.FragmentActivity ;
import com.google.android.gms.maps.CameraUpdateFactory ;
import com.google.android.gms.maps.GoogleMap ;
import com.google.android.gms.maps.OnMapReadyCallback ;
import com.google.android.gms.maps.SupportMapFragment ;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap ;
    private float DEFAULT_ZOOM=15f; // 기본 줌 레벨

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map) ;
        mapFragment.getMapAsync(this);

        Button btnZoomUp = findViewById(R.id.btnZoomUp) ;
        btnZoomUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomIn());
            }
        });

        Button btnZoomDown = findViewById(R.id.btnZoomDown) ;
        btnZoomDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.animateCamera(CameraUpdateFactory.zoomOut());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        mMap = googleMap ;

        // 지도의 초기 위치와 줌 레벨 설정 (예: 서울 시청)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.5665,126.9780),DEFAULT_ZOOM));
    }
}