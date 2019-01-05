package com.sigabe.sigabe.Emergency;

import com.sigabe.sigabe.APIServiceI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class TracksClient {

    private static final String BASE_URL = "https://sigabe.herokuapp.com/api/";
    private static TracksClient mInstance;
    private Retrofit retrofit;

    private TracksClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized TracksClient getInstance(){
        if(mInstance == null){
            mInstance = new TracksClient();
        }
        return mInstance;
    }

    public APIServiceI getApi(){

        return retrofit.create(APIServiceI.class);
    }
}
