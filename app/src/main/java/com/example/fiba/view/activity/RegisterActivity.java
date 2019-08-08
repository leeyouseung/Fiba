package com.example.fiba.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fiba.R;
import com.example.fiba.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    ActivityRegisterBinding binding;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        event();
    }

    private void initData() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickRegisterButton();
    }

    private void clickRegisterButton() {

        binding.registerButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        });
    }
}
