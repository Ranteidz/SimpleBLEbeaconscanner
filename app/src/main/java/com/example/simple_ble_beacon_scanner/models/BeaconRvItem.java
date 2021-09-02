package com.example.simple_ble_beacon_scanner.models;

public class BeaconRvItem {
    private String UID;
    private String RSSI;
    private int major;
    private int minor;

    public BeaconRvItem(String UID, String RSSI, int major, int minor) {
        this.UID = UID;
        this.RSSI = RSSI;
        this.major = major;
        this.minor = minor;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getRSSI() {
        return RSSI;
    }

    public void setRSSI(String RSSI) {
        this.RSSI = RSSI;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }
}
