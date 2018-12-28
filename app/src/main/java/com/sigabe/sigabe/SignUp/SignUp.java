package com.sigabe.sigabe.SignUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.sigabe.sigabe.Login.LoginActivity;
import com.sigabe.sigabe.R;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    private EditText etEmail, etPassword1, etUsername, etPassword2;
    private CheckBox ShowPass1, ShowPass2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etEmail = findViewById(R.id.textEmail);
        etPassword1 = findViewById(R.id.textPassword1);
        etPassword2 = findViewById(R.id.textPassword2);
        etUsername = findViewById(R.id.textUser);
        ShowPass1 = findViewById(R.id.showPass1);
        ShowPass2 = findViewById(R.id.showPass2);
        findViewById(R.id.signUp).setOnClickListener(this);
        findViewById(R.id.txt).setOnClickListener(this);
        ShowPass1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    etPassword1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    etPassword1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        ShowPass2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // show password
                    etPassword2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // hide password
                    etPassword2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

    private void userSignUp(){
        String email = etEmail.getText().toString().trim();
        String password1 = etPassword1.getText().toString().trim();
        String password2 = etPassword2.getText().toString().trim();
        String username = etUsername.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError("Email required");
            etEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmail.setError("Masukkan Email yang benar");
            etEmail.requestFocus();
            return;
        }

        if(password1.isEmpty()){
            etPassword1.setError("Password required");
            etPassword1.requestFocus();
            return;
        }

        if(password1.length() < 8){
            etPassword1.setError("Password harus 8 karakter");
            etPassword1.requestFocus();
        }

        if(password2.isEmpty()){
            etPassword2.setError("Password required");
            etPassword2.requestFocus();
            return;
        }

        if(password2.length() < 8){
            etPassword2.setError("Password harus 8 karakter");
            etPassword2.requestFocus();
        }

        if(username.isEmpty()){
            etUsername.setError("Username required");
            etUsername.requestFocus();
            return;
        }


        Call<ResponseBody> call = SignUpClient
                .getInstance()
                .getApi()
                .createUser(email, username, password1, password2);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    String s = response.body().string();
                    Toast.makeText(SignUp.this, "Register Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(SignUp.this, LoginActivity.class);
                    startActivity(intent);
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(SignUp.this,"Register Failed" , Toast.LENGTH_LONG).show();
                    //t.getMessage()
            }

        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signUp:
                userSignUp();
                break;
            case R.id.txt:
                Intent intent = new Intent(SignUp.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
