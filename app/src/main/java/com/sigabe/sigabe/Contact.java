package com.sigabe.sigabe;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.sigabe.sigabe.Content.SurvivalDashboardTab;
import com.sigabe.sigabe.Emergency.MapsActivity;
import com.sigabe.sigabe.R;

public class Contact extends Fragment {
    FloatingActionButton addFriend;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_contact,null);
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addFriend = (FloatingActionButton) view.findViewById(R.id.addFriend);

        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FormAddFriend.class);
                getActivity().startActivity(intent);
            }
        });

    }
}
