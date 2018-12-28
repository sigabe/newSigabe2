package com.sigabe.sigabe.Login;

import com.sigabe.sigabe.APIServiceI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginClient {
    private static final String BASE_URL = "https://sigabe.herokuapp.com/api/";
    private static LoginClient mInstance;
    private static Retrofit retrofit;

    private LoginClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized  LoginClient getInstance(){
        if(mInstance == null){
            mInstance = new LoginClient();
        }
        return mInstance;
    }

    public static APIServiceI getApi(){
        return retrofit.create(APIServiceI.class);
    }
}
