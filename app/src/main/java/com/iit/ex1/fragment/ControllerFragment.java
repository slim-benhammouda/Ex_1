package com.iit.ex1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.iit.ex1.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class ControllerFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRadioGroup;

    private  OnControlListener mListener;

    public ControllerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_control, container, false);

        initViews(view);

        // Inflate the layout for this fragment
        return view;

    }

    private void initViews(View view) {
        mRadioGroup = (RadioGroup) view.findViewById(R.id.hat_choice);
        mRadioGroup.setOnCheckedChangeListener(this);

    }


    public void setOnControlListener(OnControlListener listener){

        mListener = listener;
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(mListener!= null) {
            mListener.onControlPerformed(checkedId);
        }

    }


    public interface OnControlListener  {

        public void onControlPerformed(int controlId);

    }
}
