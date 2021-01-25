package com.vicero13.cs_v0.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private static final String BASE_URL = "http://92.53.124.167:8080";
    private static Service service;
    private static HttpLoggingInterceptor httpLoggingInterceptor;
    private static OkHttpClient okHttpClient;
    private static Retrofit retrofit;

    private Service() {

        httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(3, TimeUnit.MINUTES)
                .writeTimeout(3, TimeUnit.MINUTES)
                .readTimeout(3, TimeUnit.MINUTES)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static Service getInstance(){
        if (service == null){
            service = new Service();
        }
        return service;
    }

    public ServiceAPI getServiceAPI(){
        return retrofit.create(ServiceAPI.class);
    }
}
