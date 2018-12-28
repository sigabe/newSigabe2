package com.sigabe.sigabe.Content;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sigabe.sigabe.R;

public class DashboardContent extends AppCompatActivity {
    TextView textSos;
    LinearLayout btnBanjir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_content);
        textSos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sosial = new Intent(DashboardContent.this, DashboardSosialTab.class);
                startActivity(sosial);
            }
        });
        btnBanjir = findViewById(R.id.btnBanjir);
        btnBanjir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent banjir = new Intent(DashboardContent.this, ContentBanjirTab.class);
                startActivity(banjir);
            }
        });
    }
}
