package com.sigabe.sigabe.SignUp;

import com.sigabe.sigabe.APIServiceI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class SignUpClient{

    private static final String BASE_URL = "https://sigabe.herokuapp.com/api/";
    private static SignUpClient mInstance;
    private Retrofit retrofit;

    private SignUpClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized  SignUpClient getInstance(){
        if(mInstance == null){
            mInstance = new SignUpClient();
        }
        return mInstance;
    }

    public APIServiceI getApi(){

        return retrofit.create(APIServiceI.class);
    }
}
