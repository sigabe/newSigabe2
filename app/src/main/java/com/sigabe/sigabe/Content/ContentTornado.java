package com.sigabe.sigabe.Content;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sigabe.sigabe.R;

public class ContentTornado extends android.support.v4.app.Fragment {
    private static final String TAG = "ContentTornado";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_content_tornado, container, false);
        return view;
    }
}
