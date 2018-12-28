package com.sigabe.sigabe.Emergency;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class BackgroundService extends Service implements LocationListener {

    private final Context context;

    Location location;

    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;
    protected LocationManager locationManager;

    public BackgroundService(Context context){
        this.context = context;
        this.location = location;
        this.isGPSEnabled = isGPSEnabled;
        this.isNetworkEnabled = isNetworkEnabled;
        this.canGetLocation = canGetLocation;
        this.locationManager = locationManager;
    }

    public Location getLocation(){
        try{
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);
            isGPSEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER);

            if (ContextCompat.checkSelfPermission(context,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED){
                if(isGPSEnabled){
                    if(location==null){
                        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 10, this);
                        if(locationManager!=null){
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        }
                    }
                }
                if(isNetworkEnabled){
                    if(location==null){
                        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000, 10, this);
                        if(locationManager!=null){
                            location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        }
                    }
                }
            }
        }catch (Exception ex){

        }
        return  location;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
