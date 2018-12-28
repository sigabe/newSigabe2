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

public class ConBanjir1 extends android.support.v4.app.Fragment {
    TextView textSos;
    LinearLayout btnBanjir, btnGempa, btnKebakaran;
    private static final String TAG = "ConBanjir1";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_content_banjir, container, false);
        return view;
    }
}
