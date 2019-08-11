package com.example.fiba.widget.recyclerview.adapter;

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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FindAdapter extends RecyclerView.Adapter<FindAdapter.ItemViewHolder> {

    ChildFindListviewItemBinding binding;

    private ArrayList<FindChild> listData = new ArrayList<>();

    interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {

        onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_find_listview_item, viewGroup, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {

        itemViewHolder.onBind(listData.get(position));

        itemViewHolder.itemView.setOnClickListener(v -> {

            if(onItemClickListener != null) {

                onItemClickListener.onItemClick(itemViewHolder.itemView, position);
            }
        });
    }

    @Override
    public int getItemCount() {

        return listData.size();
    }

    void addItem(FindChild findChild) {

        listData.add(findChild);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView childPhoto;
        private TextView childName;
        private TextView childAge;
        private TextView childSex;
        private TextView childHeight;
        private TextView childWeight;
        private TextView place;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            childName = binding.childName;
            childAge = binding.childAge;
            childSex = binding.childSex;
            place = binding.childPlace;
            childHeight = binding.childHeight;
            childWeight = binding.childWeight;
            childPhoto = binding.childPhoto;
        }

        void onBind(FindChild findChild) {

            childName.setText(findChild.getChildName());
            childAge.setText(findChild.getChildAge());
            childSex.setText(findChild.getChildSex());
            place.setText(findChild.getChildPlace());
            childHeight.setText(findChild.getChildHeight());
            childWeight.setText(findChild.getChildWeight());
            childPhoto.setImageResource(R.drawable.child_image_find);
        }
    }
}
