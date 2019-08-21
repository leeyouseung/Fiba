package com.example.fiba.widget.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fiba.R;
import com.example.fiba.model.FindChild;

public class FindChildAdapter extends ListAdapter<FindChild, FindChildAdapter.FindChildHolder> {

    private OnItemClickListener listener;

    public FindChildAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<FindChild> DIFF_CALLBACK = new DiffUtil.ItemCallback<FindChild>() {
        @Override
        public boolean areItemsTheSame(@NonNull FindChild oldItem, @NonNull FindChild newItem) {

            return oldItem.getChildId() == newItem.getChildId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull FindChild oldItem, @NonNull FindChild newItem) {

            return oldItem.getChildPhoto() == newItem.getChildPhoto() &&
                    oldItem.getChildName().equals(newItem.getChildName()) &&
                    oldItem.getChildSex().equals(newItem.getChildSex()) &&
                    oldItem.getChildAge().equals(newItem.getChildAge()) &&
                    oldItem.getChildPlace().equals(newItem.getChildPlace()) &&
                    oldItem.getChildHeight().equals(newItem.getChildHeight()) &&
                    oldItem.getChildWeight().equals(newItem.getChildWeight());
        }
    };

    @NonNull
    @Override
    public FindChildAdapter.FindChildHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.child_find_listview_item, parent, false);

        return new FindChildHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FindChildAdapter.FindChildHolder holder, int position) {

        FindChild currentNote = getItem(position);

        holder.childName.setText(currentNote.getChildName());
        holder.childSex.setText(currentNote.getChildSex());
        holder.childAge.setText(currentNote.getChildAge());
        holder.childPlace.setText(currentNote.getChildPlace());
        holder.childHeight.setText(currentNote.getChildHeight());
        holder.childWeight.setText(currentNote.getChildWeight());
    }

    public FindChild getFindChildAt(int position) {

        return getItem(position);
    }

    class FindChildHolder extends RecyclerView.ViewHolder {

        private TextView childName;
        private TextView childSex;
        private TextView childAge;
        private TextView childPlace;
        private TextView childHeight;
        private TextView childWeight;

        public FindChildHolder(@NonNull View itemView) {
            super(itemView);

            childName = itemView.findViewById(R.id.childName);
            childSex = itemView.findViewById(R.id.childSex);
            childAge = itemView.findViewById(R.id.childAge);
            childPlace = itemView.findViewById(R.id.childPlace);
            childHeight = itemView.findViewById(R.id.childHeight);
            childWeight = itemView.findViewById(R.id.childWeight);

            itemView.setOnClickListener(v -> {

                int position = getAdapterPosition();

                if(listener != null && position != RecyclerView.NO_POSITION) {

                    listener.onItemClick(getItem(position));
                }
            });
        }
    }

    public interface OnItemClickListener {

        void onItemClick(FindChild findChild);
    }

    public void setItemClickListener(OnItemClickListener onItemClickListener) {

        this.listener = onItemClickListener;
    }
}
