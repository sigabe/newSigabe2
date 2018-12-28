package com.sigabe.sigabe.Content;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sigabe.sigabe.R;

public class DashboardSosialTab extends Fragment {
    TextView textSos;
    LinearLayout btnJatuh;
    private static final String TAG = "DashboardSosialTab";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_dashboard_sosial, container, false);
        btnJatuh = view.findViewById(R.id.btnJatuh);
        btnJatuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jatuh = new Intent(getActivity(), ContentJatuh.class);
                startActivity(jatuh);
            }
        });
        return view;
    }
}
