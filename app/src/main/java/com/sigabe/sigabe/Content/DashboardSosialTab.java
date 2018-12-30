package com.sigabe.sigabe.Content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sigabe.sigabe.R;

public class DashboardSosialTab extends android.support.v4.app.Fragment {
    RelativeLayout btnJatuh, btnTersesat, btnBegal;
    private static final String TAG = "DashboardSosialTab";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_dashboard_sosial, container, false);
        btnJatuh = (RelativeLayout) view.findViewById(R.id.btnJatuh);
        btnJatuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jatuh = new Intent(getActivity(), ContentJatuhTab.class);
                startActivity(jatuh);
            }
        });
        btnTersesat = view.findViewById(R.id.btnTersesat);
        btnTersesat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tersesat = new Intent(getActivity(), ContentTersesatTab.class);
                startActivity(tersesat);
            }
        });
        btnBegal = view.findViewById(R.id.btnBegal);
        btnBegal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent begal = new Intent(getActivity(), ContentBegalTab.class);
                startActivity(begal);
            }
        });
        return view;
    }
}
