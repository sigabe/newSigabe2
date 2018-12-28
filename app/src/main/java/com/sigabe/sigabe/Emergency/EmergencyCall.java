package com.sigabe.sigabe.Emergency;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.sigabe.sigabe.R;

public class EmergencyCall extends Fragment {

    ImageButton btnBasarnas,btnAmbulan, btnBansos, btnPln, btnPmi, btnPosko, btnPemadam, btnPolisi, btnKomnas ;
    EditText textSearch;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstance){
        return inflater.inflate(R.layout.activity_emergency,null );
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String phoneNumberpmi = "0315313289";
        String phoneNumberbasarnas = "115";
        String phoneNumberposkobencana = "129";
        String phoneNumberambulan = "119";
        String phoneNumberPolisi= "110";
        String phoneNumberPln= "123";
        String phoneNumberKomnasHam= "0213925230";
        String phoneNumberPemadam = "113";
        String phoneNumberBansos = "1500299";
        btnBasarnas = (ImageButton) view.findViewById(R.id.btnBasarnas);
        btnBasarnas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberbasarnas));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnAmbulan = (ImageButton) view.findViewById(R.id.btnAmbulan);
        btnAmbulan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberambulan));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnBansos = (ImageButton) view.findViewById(R.id.btnBansos);
        btnBansos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberBansos));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnKomnas = (ImageButton) view.findViewById(R.id.btnKomnas);
        btnKomnas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberKomnasHam));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnPemadam = (ImageButton) view.findViewById(R.id.btnPemadam);
        btnPemadam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberPemadam));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnPmi = (ImageButton) view.findViewById(R.id.btnPMI);
        btnPmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberpmi));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnPln = (ImageButton) view.findViewById(R.id.btnPLN);
        btnPln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberPln));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnPolisi = (ImageButton) view.findViewById(R.id.btnPolisi);
        btnPolisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberPolisi));
                getActivity().startActivity(dialPhoneIntent);
            }
        });

        btnPosko = (ImageButton) view.findViewById(R.id.btnposkoben);
        btnPosko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dialPhoneIntent  = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumberposkobencana));
                getActivity().startActivity(dialPhoneIntent);
            }
        });
    }
}
