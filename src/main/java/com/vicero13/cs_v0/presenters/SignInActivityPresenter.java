package com.vicero13.cs_v0.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.vicero13.cs_v0.activities.DesktopActivity;
import com.vicero13.cs_v0.activities.SignUpActivity;
import com.vicero13.cs_v0.pojo.User;
import com.vicero13.cs_v0.service.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivityPresenter {

    public static String email;
    public static String password;

    public static void validateUser(String email, Context context) {

        //Check on: 1.Response is successful;
        //          2.Exists user;
        //          3.Compare input data and data from server

        Service.getInstance()
                .getServiceAPI()
                .getUser(email)
                .enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        if (response.isSuccessful()){
                            if (response.body() == null) {
                                Toast.makeText(context, "Connected! Data retrieval error!", Toast.LENGTH_LONG).show();
                            } else if (compareUser(response.body().getEmail(), response.body().getPassword())){
                                Toast.makeText(context, "Successful!", Toast.LENGTH_SHORT).show();
                                context.startActivity(new Intent(context, DesktopActivity.class));
                            } else{
                                Toast.makeText(context, "Invalid login or password", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            if (response.code() == 404) {
                                Toast.makeText(context, "User not found! Sign up!", Toast.LENGTH_LONG).show();
                            }

                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        Toast.makeText(context, "Server connection error!", Toast.LENGTH_LONG).show();
                    }
                });

    }

    private static boolean compareUser(String email, String password) {
        return SignInActivityPresenter.email.equals(email) && SignInActivityPresenter.password.equals(password);
    }

    public static void onSignUpActivity(Context context){
        Intent intent = new Intent(context, SignUpActivity.class);
        context.startActivity(intent);

    }

}
