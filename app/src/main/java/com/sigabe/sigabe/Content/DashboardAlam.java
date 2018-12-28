package com.sigabe.sigabe.Content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sigabe.sigabe.R;

public class DashboardAlam extends android.support.v4.app.Fragment {
    TextView textSos;
    LinearLayout btnBanjir, btnGempa, btnKebakaran;
    private static final String TAG = "DashboardAlam";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_dashboard_content, container, false);
        btnBanjir = (LinearLayout) view.findViewById(R.id.btnBanjir);
        btnBanjir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button Clicked...", Toast.LENGTH_SHORT).show(); //getActivity() is context in fragment
                Intent banjir = new Intent(getActivity(), ContentBanjirTab.class);
                startActivity(banjir);
            }
        });
        btnGempa = view.findViewById(R.id.btnGempaBumi);
        btnGempa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gempa = new Intent(getActivity(), ContentGempaTab.class);
                startActivity(gempa);
            }
        });
        btnKebakaran = view.findViewById(R.id.btnKebakaran);
        btnKebakaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kebakaran = new Intent(getActivity(), ContentBakarTab.class);
                startActivity(kebakaran);
            }
        });
        return view;
    }
}