package com.example.fiba.widget.recyclerview.viewholder;

import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fiba.databinding.ChildFindListviewItemBinding;

public class FindViewHolder extends RecyclerView.ViewHolder {

    public ChildFindListviewItemBinding childFindListviewItemBinding;

    public FindViewHolder(@NonNull View itemView) {
        super(itemView);

        childFindListviewItemBinding = DataBindingUtil.bind(itemView);

        itemView.setOnClickListener(v -> {

            int pos = getAdapterPosition() ;
            if (pos != RecyclerView.NO_POSITION) {

                Toast.makeText(itemView.getContext().getApplicationContext(), "item clicked. pos = " + pos, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
