package com.vicero13.cs_v0.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.vicero13.cs_v0.databinding.SignInActivityBinding;
import com.vicero13.cs_v0.presenters.SignInActivityPresenter;

public class SignInActivity extends AppCompatActivity {

    private SignInActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //View Binding
        binding = SignInActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Authorisation user and go on Desktop Activity or error
        binding.btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivityPresenter.email = binding.etEmail.getText().toString();
                SignInActivityPresenter.password = binding.etPassword.getText().toString();
                SignInActivityPresenter.validateUser(SignInActivityPresenter.email, SignInActivity.this);
            }
        });

        //Go on SignUpActivity
        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInActivityPresenter.onSignUpActivity(SignInActivity.this);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
