package com.vicero13.cs_v0.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.vicero13.cs_v0.databinding.DesktopActivityBinding;
import com.vicero13.cs_v0.databinding.SignUpActivityBinding;
import com.vicero13.cs_v0.pojo.User;
import com.vicero13.cs_v0.presenters.SignUpActivityPresenter;

public class DesktopActivity extends AppCompatActivity {

    private DesktopActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = DesktopActivityBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
}
