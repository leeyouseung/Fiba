package com.example.fiba.widget.recyclerview.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fiba.R;
import com.example.fiba.model.FindChild;
import com.example.fiba.widget.recyclerview.viewholder.FindViewHolder;

import java.util.ArrayList;

public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<FindChild> listData = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

    public FindAdapter(OnItemClickListener listener) {

        onItemClickListener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new FindViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child_find_listview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Log.d("LogPosition", "position = " + position);

        populateItemRows((FindViewHolder) holder, position);
    }

    @Override
    public int getItemCount() {

        return 0;
    }

    private void populateItemRows(FindViewHolder viewHolder, int position) {

    }
}
