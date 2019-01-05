package com.sigabe.sigabe;

import com.sigabe.sigabe.Login.LoginResponse;
import com.sigabe.sigabe.SignUp.SignUpResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServiceI {

    @FormUrlEncoded
    @POST("rest-auth/registration/")
    Call<SignUpResponse> createUser(
            @Field("email") String email,
            @Field("username") String username,
            @Field("password1") String password1,
            @Field("password2") String password2
    );

    @FormUrlEncoded
    @POST("rest-auth/login/?format=json")
    Call<LoginResponse> loginUser(
            @Field("username") String username,
            @Field("email") String email,
            @Field("password") String password
    );


    @POST("tracks/")
    @FormUrlEncoded
    Call<ResponseBody> tracksFriend(
            @Field("longitude") String longitude,
            @Field("latitude") String latitude
    );

}
