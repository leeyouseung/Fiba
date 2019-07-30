package com.example.fiba.view.activity.MainPage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
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

            binding.mainButton.setImageDrawable(getResources().getDrawable(R.drawable.list_act));
            binding.addButton.setImageDrawable(getResources().getDrawable(R.drawable.plus));
            binding.searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search));
            binding.myPageButton.setImageDrawable(getResources().getDrawable(R.drawable.people));

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

        plusButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus_act));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people));

            listButtonText.setVisibility(View.INVISIBLE);
            plusButtonText.setVisibility(View.VISIBLE);
            searchButtonText.setVisibility(View.INVISIBLE);
            peopleButtonText.setVisibility(View.INVISIBLE);

            Intent intent = new Intent(getApplicationContext(), AddFragment.class);
            startActivity(intent);
        });
    }

    private void clickSearchButton() {

        searchButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search_act));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people));

            listButtonText.setVisibility(View.INVISIBLE);
            plusButtonText.setVisibility(View.INVISIBLE);
            searchButtonText.setVisibility(View.VISIBLE);
            peopleButtonText.setVisibility(View.INVISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentMain, new SearchFragment());
            fragmentTransaction.commit();
        });
    }

    private void clickMyPageButton() {

        peopleButton.setOnClickListener(v -> {

            listButton.setImageDrawable(getResources().getDrawable(R.drawable.list));
            plusButton.setImageDrawable(getResources().getDrawable(R.drawable.plus));
            searchButton.setImageDrawable(getResources().getDrawable(R.drawable.search));
            peopleButton.setImageDrawable(getResources().getDrawable(R.drawable.people_act));

            listButtonText.setVisibility(View.INVISIBLE);
            plusButtonText.setVisibility(View.INVISIBLE);
            searchButtonText.setVisibility(View.INVISIBLE);
            peopleButtonText.setVisibility(View.VISIBLE);

            FragmentManager fragmentManager = getSupportFragmentManager();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentMain, new MyPageFragment());
            fragmentTransaction.commit();
        });
    }
}
