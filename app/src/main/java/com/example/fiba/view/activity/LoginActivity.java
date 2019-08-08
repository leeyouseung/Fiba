package com.example.fiba.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.fiba.R;
import com.example.fiba.base.BaseActivity;
import com.example.fiba.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    Intent intent;

    @Override
    protected int layoutId() {

        return R.layout.activity_login;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fadeOutAnimation();

        event();
    }

    private void fadeOutAnimation() {

        overridePendingTransition(0,0);
        Animation animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        binding.loginContainer.startAnimation(animation);
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickLoginButton();
        clickFindIdButton();
        clickFindPwButton();
        clickRegisterButton();
    }

    private void clickLoginButton() {

        binding.loginButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }

    private void clickFindIdButton() {

        binding.findIdButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            intent = new Intent(getApplicationContext(), FindIdActivity.class);
            startActivity(intent);
        });
    }

    private void clickFindPwButton() {

        binding.findPwButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            intent = new Intent(getApplicationContext(), FindPwActivity.class);
            startActivity(intent);
        });
    }

    private void clickRegisterButton() {

        binding.registerButton.setOnClickListener(v -> {

            Toast.makeText(getApplicationContext(), "잠시만 기다려주세요", Toast.LENGTH_SHORT).show();

            intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
    }
}
