package com.sigabe.sigabe;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.sigabe.sigabe.SignUp.SignUp;

public class SplashScreen extends AppCompatActivity implements OnClickListener{

    TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        tvSplash = (TextView) findViewById(R.id.tvSplash);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, SignUp.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }

    @Override
    public void onClick(View view) {

    }
}
