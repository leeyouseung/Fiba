package com.example.fiba.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fiba.R;
import com.example.fiba.data.FindChild;

import java.util.ArrayList;

public class FindRecyclerviewAdapter extends RecyclerView.Adapter<FindRecyclerviewAdapter.ViewHolder> {

    interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

    OnItemClickListener onItemClickListener;

    public FindRecyclerviewAdapter(OnItemClickListener listener) {

        onItemClickListener = listener;
    }

    private ArrayList<FindChild> listData = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_find_listview_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
