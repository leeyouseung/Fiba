package com.example.fiba.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fiba.R;
import com.example.fiba.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    Intent intent;

    private boolean checkBlind = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

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
        clickPasswordClearButton();
        clickPasswordBlindButton();
    }

    private void clickLoginButton() {

        binding.loginButton.setOnClickListener(v -> {

            if (binding.idText.getText().toString().isEmpty()) {

                Toast.makeText(this,"아이디를 입력해 주세요",Toast.LENGTH_SHORT).show();

                return;
            }
            if (binding.pwText.getText().toString().isEmpty()) {

                Toast.makeText(this,"비밀번호를 입력해 주세요",Toast.LENGTH_SHORT).show();

                return;
            }

            intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
//            loginViewModel.login(new LoginRequest(binding.idText.getText().toString(), binding.pwText.getText().toString()));
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

    private void clickPasswordClearButton() {

        binding.clear.setOnClickListener(v -> binding.pwText.setText(""));
    }

    private void clickPasswordBlindButton() {

        binding.blind.setOnClickListener(v -> {

            if (checkBlind) {

                binding.blind.setImageResource(R.drawable.ic_blind);
                binding.pwText.setTransformationMethod(PasswordTransformationMethod.getInstance());

                checkBlind = false;
            }
            else {

                binding.blind.setImageResource(R.drawable.ic_blind_check);
                binding.pwText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                checkBlind = true;
            }
        });
    }
}
