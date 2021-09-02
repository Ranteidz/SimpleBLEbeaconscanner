package com.example.simple_ble_beacon_scanner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.simple_ble_beacon_scanner.adapter.BeaconAdapter;
import com.example.simple_ble_beacon_scanner.models.BeaconRvItem;
import com.example.simple_ble_beacon_scanner.viewmodels.MainActivityViewModel;
import com.kontakt.sdk.android.common.KontaktSDK;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView beaconRV;
    BeaconAdapter beaconAdapter;
    MainActivityViewModel mainActivityViewModel;

    public static final int REQUEST_CODE_PERMISSIONS = 100;

    private static final String API_KEY = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beaconRV = findViewById(R.id.beaconRV);
        beaconRV.hasFixedSize();
        beaconRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        ArrayList<BeaconRvItem> beaconRvItems = new ArrayList<>();
        beaconAdapter = new BeaconAdapter(beaconRvItems);
        beaconRV.setAdapter(beaconAdapter);

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        InitializeDependencies();

    }

    private void InitializeDependencies() {

        KontaktSDK.initialize(API_KEY);
    }

    public void StartScan(View view) {
        mainActivityViewModel.StartScan();
    }

    public void StopScan(View view) {
        mainActivityViewModel.StopScan();
    }

    //Since Android Marshmallow starting a Bluetooth Low Energy scan requires permission from location group.
    private void checkPermissions() {
        int checkSelfPermissionResult = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        if (PackageManager.PERMISSION_GRANTED != checkSelfPermissionResult) {
            //Permission not granted so we ask for it. Results are handled in onRequestPermissionsResult() callback.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_PERMISSIONS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (REQUEST_CODE_PERMISSIONS == requestCode) {
                Toast.makeText(this, "Permissions granted!", Toast.LENGTH_SHORT).show();
            }
        } else {

            Toast.makeText(this, "Location permissions are mandatory to use BLE features on Android 6.0 or higher", Toast.LENGTH_LONG).show();
        }
    }


}