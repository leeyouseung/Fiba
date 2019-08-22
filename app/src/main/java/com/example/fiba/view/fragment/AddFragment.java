package com.example.fiba.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.fiba.R;
import com.example.fiba.databinding.FragmentAddBinding;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {

    //--------------------------------------------------------------------

    public static final String EXTRA_ID = "id";
    public static final int EXTRA_FIND_CHILD_IMAGE = 1;
    public static final String EXTRA_FIND_CHILD_NAME = "name";
    public static final String EXTRA_FIND_CHILD_SEX = "sex";
    public static final String EXTRA_FIND_CHILD_AGE = "age";
    public static final String EXTRA_FIND_CHILD_PLACE = "place";
    public static final String EXTRA_FIND_CHILD_HEIGHT = "height";
    public static final String EXTRA_FIND_CHILD_WEIGHT = "weight";
    public static final String EXTRA_FIND_CHILD_PROTECTER = "protecter";
    public static final String EXTRA_FIND_CHILD_DETAILCONTENTS = "detail_contents";

    FragmentAddBinding binding;

    //--------------------------------------------------------------------

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
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

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false);

        return binding.getRoot();
    }

    //--------------------------------------------------------------------

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();

        event();
    }

    private void initData() {

    }

    private void event() {

        clickEvent();
    }

    private void clickEvent() {

        clickConfirmAdd();
    }

    private void clickConfirmAdd() {

//        ImageView findChildImage = binding.addChildImage.getImageAlpha();
        String findChildName = binding.addChildNameText.getText().toString();
        String findChildAge = binding.ageSpinner.getSelectedItem().toString();
        String findChildSex = binding.manButton.getText().toString();
        String findChildPlace = binding.placeText.getText().toString();
        String findChildProtecter = binding.protectPhoneNumber.getText().toString();
        String findChildHeight = binding.heightButton.getText().toString();
        String findChildWeight = binding.weightButton.getText().toString();
        String detailContents = binding.detailContents.getText().toString();

        if(findChildName.trim().isEmpty() || findChildAge.trim().isEmpty() ||
                findChildProtecter.trim().isEmpty() || findChildHeight.trim().isEmpty() ||
                findChildWeight.trim().isEmpty() || detailContents.trim().isEmpty()) {

            Toast.makeText(getContext(), "모든 항목 값을 입력해주세요", Toast.LENGTH_SHORT).show();

            return;
        }

        Intent intent = new Intent();

//        intent.putExtra(EXTRA_FIND_CHILD_IMAGE, findChildImage);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_NAME, findChildName);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_SEX, findChildSex);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_AGE, findChildAge);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_PLACE, findChildPlace);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_HEIGHT, findChildHeight);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_WEIGHT, findChildWeight);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_PROTECTER, findChildProtecter);
        intent.putExtra(AddFragment.EXTRA_FIND_CHILD_DETAILCONTENTS, detailContents);
    }

    //--------------------------------------------------------------------

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
