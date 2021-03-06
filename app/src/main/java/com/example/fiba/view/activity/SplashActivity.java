package com.example.fiba.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.fiba.R;
import com.example.fiba.databinding.SplashActivityBinding;

public class SplashActivity extends AppCompatActivity {

    SplashActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity);

        Animation hold = AnimationUtils.loadAnimation(this, R.anim.splash_hold);

        final Animation scale = AnimationUtils.loadAnimation(this, R.anim.splash_scale);

        hold.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                binding.logo.clearAnimation();
                binding.logo.startAnimation(scale);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        scale.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                binding.logo.clearAnimation();

                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);

                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        binding.logo.startAnimation(hold);
    }
}
