package com.example.simple_ble_beacon_scanner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simple_ble_beacon_scanner.R;
import com.example.simple_ble_beacon_scanner.models.BeaconRvItem;

import java.util.ArrayList;

public class BeaconAdapter extends RecyclerView.Adapter<BeaconAdapter.ViewHolder> {

    private ArrayList<BeaconRvItem> beaconRvItems;


    public BeaconAdapter(ArrayList<BeaconRvItem> beaconRvItems){
        this.beaconRvItems = beaconRvItems;
    }

    @NonNull
    @Override
    public BeaconAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.beacon_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeaconAdapter.ViewHolder holder, int position) {
        holder.UID.setText(beaconRvItems.get(position).getUID());
        holder.RSSI.setText(beaconRvItems.get(position).getRSSI());
        holder.major.setText(beaconRvItems.get(position).getMajor());
        holder.minor.setText(beaconRvItems.get(position).getMinor());
    }

    @Override
    public int getItemCount() {
        return beaconRvItems.size();
    }

    public void setBeaconRvItems(ArrayList<BeaconRvItem> beaconRvItems) {
        this.beaconRvItems = beaconRvItems;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView UID;
        TextView RSSI;
        TextView major;
        TextView minor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UID = itemView.findViewById(R.id.beaconUID);
            RSSI = itemView.findViewById(R.id.beaconRSSI);
            major = itemView.findViewById(R.id.beaconMajor);
            minor = itemView.findViewById(R.id.beaconMinor);
        }
    }
}
