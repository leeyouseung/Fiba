package com.example.fiba.widget.recyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fiba.R;
import com.example.fiba.databinding.ChildFindListviewItemBinding;
import com.example.fiba.model.FindChild;
import com.example.fiba.view.activity.MainActivity;
import com.example.fiba.widget.recyclerview.viewholder.FindViewHolder;

import java.util.List;

public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ChildFindListviewItemBinding binding;

    private List<FindChild> listData;

    Context context;

    MainActivity view;

    public FindAdapter(List<FindChild> listData, Context context, MainActivity view) {

        this.listData = listData;
        this.context = context;
        this.view = view;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        return new FindViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.child_find_listview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder itemViewHolder, int position) {

        Log.d("LogPosition", "position = " + position);

        FindChild findChild = listData.get(position);

        populateItemRows((FindViewHolder) itemViewHolder, findChild);
    }

    @Override
    public int getItemCount() {

        return listData.size();
    }

    private void populateItemRows(FindViewHolder viewHolder, FindChild findChild) {

//        viewHolder.binding.studyTitle.setText(findChild.getTitle());
//        viewHolder.binding.currentPerson.setText(findChild.getCurrentPerson().toString() + " / ");
//        viewHolder.binding.personnel.setText(findChild.getPersonnel().toString());
//        viewHolder.binding.studyPlace.setText(findChild.getLocation());
//        viewHolder.binding.studyTime.setText(findChild.getStartTerm().split(" ")[0] + " ~ " + study.getEndTerm().split(" ")[0]);
//
//        if (!findChild.getImgs().isEmpty()) {
//
//            Glide.with(view).load(findChild.getImgs().get(0)).into(viewHolder.binding.studyImageview);
//        }
//
//        viewHolder.binding.studyCardView.setOnClickListener(v -> {
//
//            Intent intent = new Intent(context, StudyActivity.class);
//
//            intent.putExtra("study", findChild);
//
//            context.startActivity(intent);
//        });
    }
}
