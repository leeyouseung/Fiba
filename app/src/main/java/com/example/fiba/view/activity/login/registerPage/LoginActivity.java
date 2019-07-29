package com.example.fiba.view.activity.login.registerPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.fiba.R;
import com.example.fiba.databinding.ActivityLoginBinding;
import com.example.fiba.view.activity.MainPage.MainActivity;
import com.example.fiba.view.activity.findPage.FindIdActivity;
import com.example.fiba.view.activity.findPage.FindPwActivity;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        event();
    }

    private void initData() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickLoginButton();
        clickFindIdButton();
        clickFindPwButton();
    }

    private void clickLoginButton() {

        binding.loginButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    private void clickFindIdButton() {

        binding.findIdButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), FindIdActivity.class);
            startActivity(intent);
        });
    }

    private void clickFindPwButton() {

        binding.findPwButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), FindPwActivity.class);
            startActivity(intent);
        });
    }
}
