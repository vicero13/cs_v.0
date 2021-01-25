package com.vicero13.cs_v0.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.vicero13.cs_v0.databinding.SignUpActivityBinding;
import com.vicero13.cs_v0.pojo.User;
import com.vicero13.cs_v0.presenters.SignUpActivityPresenter;


public class SignUpActivity extends AppCompatActivity {

    private SignUpActivityBinding binding;
    public User user;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //ViewBinding
        binding = SignUpActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Add new User(entered email and password) to database
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = new User(binding.etEmailSignUp.getText().toString(), binding.etPasswordSignUp.getText().toString());
                SignUpActivityPresenter.addUser(user, SignUpActivity.this);
            }
        });

        //Go on SignInActivity
        binding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUpActivityPresenter.onSignInActivity(SignUpActivity.this);
            }
        });

    }

}
