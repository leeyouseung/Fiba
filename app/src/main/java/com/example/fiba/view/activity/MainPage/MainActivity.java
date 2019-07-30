package com.example.fiba.view.activity.MainPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.fiba.R;
import com.example.fiba.databinding.ActivityMainBinding;
import com.example.fiba.view.fragment.AddFragment;
import com.example.fiba.view.fragment.MainFragment;
import com.example.fiba.view.fragment.MyPageFragment;
import com.example.fiba.view.fragment.SearchFragment;

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

        clickMainButton();
        clickAddButton();
        clickSearchButton();
        clickMyPageButton();
    }

    private void clickMainButton() {

        binding.mainButton.setOnClickListener(v -> {

            binding.mainButton.setImageDrawable(getResources().getDrawable(R.drawable.main_act));
            binding.addButton.setImageDrawable(getResources().getDrawable(R.drawable.add));
            binding.searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search));
            binding.myPageButton.setImageDrawable(getResources().getDrawable(R.drawable.mypage));

            binding.mainButtonText.setVisibility(View.VISIBLE);
            binding.addButtonText.setVisibility(View.INVISIBLE);
            binding.searchButtonText.setVisibility(View.INVISIBLE);
            binding.myPageButtonText.setVisibility(View.INVISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragment, new MainFragment());
            fragmentTransaction.commit();
        });
    }

    private void clickAddButton() {

        binding.addButton.setOnClickListener(v -> {

            binding.mainButton.setImageDrawable(getResources().getDrawable(R.drawable.main));
            binding.addButton.setImageDrawable(getResources().getDrawable(R.drawable.add_act));
            binding.searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search));
            binding.myPageButton.setImageDrawable(getResources().getDrawable(R.drawable.mypage));

            binding.mainButtonText.setVisibility(View.INVISIBLE);
            binding.addButtonText.setVisibility(View.VISIBLE);
            binding.searchButtonText.setVisibility(View.INVISIBLE);
            binding.myPageButtonText.setVisibility(View.INVISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragment, new AddFragment());
            fragmentTransaction.commit();
        });
    }

    private void clickSearchButton() {

        binding.searchButton.setOnClickListener(v -> {

            binding.mainButton.setImageDrawable(getResources().getDrawable(R.drawable.main));
            binding.addButton.setImageDrawable(getResources().getDrawable(R.drawable.add));
            binding.searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_act));
            binding.myPageButton.setImageDrawable(getResources().getDrawable(R.drawable.mypage));

            binding.mainButtonText.setVisibility(View.INVISIBLE);
            binding.addButtonText.setVisibility(View.INVISIBLE);
            binding.searchButtonText.setVisibility(View.VISIBLE);
            binding.myPageButtonText.setVisibility(View.INVISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragment, new SearchFragment());
            fragmentTransaction.commit();
        });
    }

    private void clickMyPageButton() {

        binding.myPageButton.setOnClickListener(v -> {

            binding.mainButton.setImageDrawable(getResources().getDrawable(R.drawable.main));
            binding.addButton.setImageDrawable(getResources().getDrawable(R.drawable.add));
            binding.searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search));
            binding.myPageButton.setImageDrawable(getResources().getDrawable(R.drawable.mypage_act));

            binding.mainButtonText.setVisibility(View.INVISIBLE);
            binding.addButtonText.setVisibility(View.INVISIBLE);
            binding.searchButtonText.setVisibility(View.INVISIBLE);
            binding.myPageButtonText.setVisibility(View.VISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragment, new MyPageFragment());
            fragmentTransaction.commit();
        });
    }
}
