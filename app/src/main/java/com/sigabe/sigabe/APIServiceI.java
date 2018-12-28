package com.sigabe.sigabe;

import com.sigabe.sigabe.Login.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIServiceI {

    @FormUrlEncoded
    @POST("rest-auth/registration/")
    Call<ResponseBody> createUser(
            @Field("email") String email,
            @Field("username") String username,
            @Field("password1") String password1,
            @Field("password2") String password2
    );

    @FormUrlEncoded
    @POST("rest-auth/login/")
    Call<LoginResponse> loginUser(
            @Field("username") String username,
            @Field("password") String password
    );

}
