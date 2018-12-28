package com.sigabe.sigabe;

import android.content.Intent;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.sigabe.sigabe.Content.SurvivalDashboardTab;
import com.sigabe.sigabe.Emergency.MapsActivity;

public class Dashboard extends Fragment {

        RelativeLayout btnTracking,  btnSurvive;
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstance){
            return inflater.inflate(R.layout.activity_dashboard,null );
        }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnTracking = (RelativeLayout) view.findViewById(R.id.rela1);
        btnSurvive = (RelativeLayout) view.findViewById(R.id.rela2);
        btnTracking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                getActivity().startActivity(intent);
            }
        });
        btnSurvive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SurvivalDashboardTab.class);
                getActivity().startActivity(intent);
            }
        });

    }
}

