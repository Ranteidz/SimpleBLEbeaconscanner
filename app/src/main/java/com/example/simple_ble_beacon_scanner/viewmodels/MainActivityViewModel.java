package com.example.simple_ble_beacon_scanner.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.simple_ble_beacon_scanner.models.BeaconRvItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<BeaconRvItem>> beaconsMutable;
    private List<BeaconRvItem> beaconList = new ArrayList<>();

    public MainActivityViewModel() {
        beaconsMutable = new MutableLiveData<>();


    }

    public MutableLiveData<List<BeaconRvItem>> getBeaconsMutable() {
        return beaconsMutable;
    }

    public void setBeaconsMutable(List<BeaconRvItem> beaconRvItems) {
        beaconsMutable.setValue(beaconRvItems);
    }

    public void StartScan() {

    }

    public void StopScan() {

    }
}
