package com.vicero13.cs_v0.presenters;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.vicero13.cs_v0.activities.DesktopActivity;
import com.vicero13.cs_v0.activities.SignInActivity;
import com.vicero13.cs_v0.pojo.User;
import com.vicero13.cs_v0.service.Service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

public class SignUpActivityPresenter {

    public static void addUser(User user, Context context){

        //POST request to server, insert new User(email,password) to database and go on DesktopActivity or error.
        Service.getInstance()
                .getServiceAPI()
                .addUser(user)
                .enqueue(new Callback<ResponseBody>() {

                    @Override
                    public void onResponse(@NonNull Call<ResponseBody> call, @NonNull retrofit2.Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(context, "Successful!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, DesktopActivity.class);
                            context.startActivity(intent);

                            //TODO maybe use response.code

                        } else {
                            Toast.makeText(context, "Connected! Data entry error!", Toast.LENGTH_LONG).show();

                            //TODO maybe use response.code
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                        Toast.makeText(context, "Server connection error!", Toast.LENGTH_LONG).show();

                        //TODO maybe use response.code, catch HTTP codes to log file
                    }
                });

    }

    public static void onSignInActivity(Context context){
        Intent intent = new Intent(context, SignInActivity.class);
        context.startActivity(intent);

    }
}
