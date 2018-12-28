package com.sigabe.sigabe.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.sigabe.sigabe.APIServiceI;
import com.sigabe.sigabe.MainActivity;
import com.sigabe.sigabe.R;
import com.sigabe.sigabe.SignUp.SignUp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etPassword, etUsername;
    private CheckBox ShowPass;
    APIServiceI mApiService;
    //    ProgressDialog loading;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword = findViewById(R.id.textPassword);
        etUsername = findViewById(R.id.textUser);
        ShowPass = findViewById(R.id.showPass);
        findViewById(R.id.signIn).setOnClickListener(this);
        mContext = this;
        mApiService = LoginClient.getInstance().getApi(); // meng-init yang ada di package apihelper

//        Login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Login.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
        ShowPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void userLogin(){
        String password = etPassword.getText().toString().trim();
        String username = etUsername.getText().toString().trim();

        if(password.isEmpty()){
            etPassword.setError("Password required");
            etPassword.requestFocus();
            return;
        }

        if(password.length() < 8){
            etPassword.setError("Password harus 8 karakter");
            etPassword.requestFocus();
        }

        if(username.isEmpty()){
            etUsername.setError("Username required");
            etUsername.requestFocus();
            return;
        }

        Call<LoginResponse> call = LoginClient
                .getInstance()
                .getApi()
                .loginUser(username, password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String token = response.body().getAuth();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_LONG).show();
                i.putExtra("TOKEN_STRING", token);
                startActivity(i);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signIn:
                userLogin();
                break;
            case R.id.txtBelum:
                Intent intent = new Intent(LoginActivity.this, SignUp.class);
                startActivity(intent);
                break;
        }
    }
}
