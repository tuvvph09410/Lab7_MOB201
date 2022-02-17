package com.example.lab7_mob201.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.lab7_mob201.R;

public class Fragment_Bai3 extends Fragment {
    private ImageView ivHour, ivMinute, ivSecond;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__bai3, container, false);
        this.initViewById(view);
        this.initRunTime();

        return view;
    }

    private void initRunTime() {
        Animation animationSecond = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.animation_second);
        ivSecond.setAnimation(animationSecond);
        Animation animationMinute = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.animation_minute);
        ivMinute.setAnimation(animationMinute);
        Animation animationHour = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), R.anim.animation_hour);
        ivHour.setAnimation(animationHour);
    }

    private void initViewById(View view) {
        this.ivHour = view.findViewById(R.id.iv_hour);
        this.ivMinute = view.findViewById(R.id.iv_minute);
        this.ivSecond = view.findViewById(R.id.iv_second);
    }
}