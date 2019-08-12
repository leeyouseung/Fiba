package com.example.fiba.view.fragment;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fiba.R;
import com.example.fiba.databinding.FragmentMainFindBinding;
import com.example.fiba.model.FindChild;
import com.example.fiba.widget.recyclerview.adapter.FindAdapter;

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

    FragmentMainFindBinding binding;

    private List<FindChild> findChildList = new ArrayList<>();

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

        getData();

        event();
    }

    private void initData() {

        RecyclerView recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.recyclerview_main_find);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Objects.requireNonNull(getContext()).getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        FindAdapter findAdapter = new FindAdapter();

//        findAdapter.setOnItemClickListener();    error

        recyclerView.setAdapter(findAdapter);
    }

    private void getData() {

//        List<String> listTitle = new ArrayList<>();
//
//        listTitle.add(title);
//
//        for(int i=0;i<listTitle.size();i++) {
//
//            FindChild findChild = new FindChild();
//
//            data.setTitle(listTitle.get(i));
//
//            recyclerviewAdapter.addItem(data);
//        }
//
//        recyclerviewAdapter.notifyDataSetChanged();
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
