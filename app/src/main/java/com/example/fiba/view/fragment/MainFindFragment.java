package com.example.fiba.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fiba.R;
import com.example.fiba.databinding.FragmentMainFindBinding;
import com.example.fiba.model.FindChild;
import com.example.fiba.viewmodel.FindChildViewModel;
import com.example.fiba.widget.recyclerview.adapter.FindChildAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFindFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFindFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFindFragment extends Fragment {

    //-----------------------------------------------

    public static final int ADD_NOTE_REQUEST = 1000;
    public static final int EDIT_NOTE_REQUEST = 1001;

    FragmentMainFindBinding binding;

    private FindChildViewModel findChildViewModel;

    //-----------------------------------------------

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainFindFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFindFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFindFragment newInstance(String param1, String param2) {
        MainFindFragment fragment = new MainFindFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_find, container, false);

        return binding.getRoot();
    }

    //-----------------------------------------------

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

        event();
    }

    private void initData() {

        RecyclerView recyclerView = getView().findViewById(R.id.recyclerview_main_find);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final FindChildAdapter adapter = new FindChildAdapter();
        recyclerView.setAdapter(adapter);

        findChildViewModel = ViewModelProviders.of(this).get(FindChildViewModel.class);

        findChildViewModel.getAllFindChild().observe(this, notes -> {

            // update RecyclerView
            adapter.submitList(notes);
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                findChildViewModel.delete(adapter.getFindChildAt(viewHolder.getAdapterPosition()));

                Toast.makeText(getContext(), "삭제되었습니다.", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

        adapter.setItemClickListener(findChild -> {

            Intent intent = new Intent(getContext(), AddFragment.class);

            intent.putExtra(AddFragment.EXTRA_ID, findChild.getChildId());
            intent.putExtra(String.valueOf(AddFragment.EXTRA_FIND_CHILD_IMAGE), findChild.getChildPhoto());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_NAME, findChild.getChildName());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_SEX, findChild.getChildSex());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_AGE, findChild.getChildAge());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_PLACE, findChild.getChildPlace());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_HEIGHT, findChild.getChildHeight());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_WEIGHT, findChild.getChildWeight());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_PROTECTER, findChild.getFindChildProtecter());
            intent.putExtra(AddFragment.EXTRA_FIND_CHILD_DETAILCONTENTS, findChild.getDetailContents());

            startActivityForResult(intent, EDIT_NOTE_REQUEST);
        });
    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

    }

    //-----------------------------------------------

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
