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

public class Fragment_Bai1 extends Fragment {
    private ImageView ivBai1;
    private Button btnRotation, btnMoving, btnZoom;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__bai1, container, false);
        this.initViewById(view);
        this.initButton();
        return view;
    }

    private void initButton() {
        this.btnRotation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAnimation(R.anim.animation_rotation);
            }
        });
        this.btnMoving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAnimation(R.anim.animation_alpha);
            }
        });
        this.btnZoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadAnimation(R.anim.anmation_zoom);
            }
        });
    }

    private void loadAnimation(int anim) {
        Animation animation = AnimationUtils.loadAnimation(getActivity().getApplicationContext(), anim);
        this.ivBai1.startAnimation(animation);
    }

    private void initViewById(View view) {
        this.ivBai1 = view.findViewById(R.id.iv_bai1);
        this.btnMoving = view.findViewById(R.id.btn_moving);
        this.btnRotation = view.findViewById(R.id.btn_rotaion);
        this.btnZoom = view.findViewById(R.id.btn_zoom);
    }
}