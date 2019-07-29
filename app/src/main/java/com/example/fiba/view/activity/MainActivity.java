package com.example.fiba.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.fiba.R;
import com.example.fiba.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initData();

        event();
    }

    private void initData() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

    }
}
