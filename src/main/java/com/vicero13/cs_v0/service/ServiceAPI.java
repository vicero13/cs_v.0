package com.vicero13.cs_v0.service;

import com.vicero13.cs_v0.pojo.User;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceAPI {
    @POST("/user")
    Call<ResponseBody> addUser(@Body User user);

    @GET("users/{email}")
    Call<User> getUser(@Path("email") String email);

    @PUT("users/{email}")
    Call<Response> update(@Path("email") @Body User user);

}
