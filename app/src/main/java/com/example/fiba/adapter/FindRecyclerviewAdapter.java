package com.example.fiba.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fiba.R;

public class FindRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public FindRecyclerviewAdapter() {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       //view = LayoutInflater.from(parent.getContext()).inflate(R.layout.something, parent, false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }
}
