package com.example.lab7_mob201.Fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.lab7_mob201.R;

public class Fragment_Bai2 extends Fragment {
    private ImageView ivBai2;
    private Button btnAll, btnDoremon, btnNobita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__bai2, container, false);
        this.initViewById(view);
        this.initButton();
        return view;
    }

    private void initButton() {
        this.btnAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowImage("All");
            }
        });
        this.btnDoremon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowImage("Doremon");
            }
        });
        this.btnNobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowImage("Nobita");
            }
        });
    }

    private void ShowImage(String nameImage) {
        //ẩn ảnh
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.ivBai2, "translationX", 0f, 500f);
        animator.setDuration(2000);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(this.ivBai2, "alpha", 1f, 0f);
        animator1.setDuration(2000);
        //hiện ảnh
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(this.ivBai2, "translationX", -500f, 0f);
        animator.setDuration(2000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(this.ivBai2, "alpha", 0f, 1f);
        animator1.setDuration(2000);
        // cấu hình xử lý slideshow đến khi có ảnh tiếp theo
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator2).with(animator3).after(animator).after(animator1);
        animatorSet.start();

        final String imgName = nameImage;
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (imgName.equals("Nobita")) {
                    ivBai2.setImageResource(R.drawable.nobita);
                }
                if (imgName.equals("Doremon")) {
                    ivBai2.setImageResource(R.drawable.doraemon);
                }
                if (imgName.equals("All")) {
                    ivBai2.setImageResource(R.drawable.all);
                }

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });

    }

    private void initViewById(View view) {
        this.ivBai2 = view.findViewById(R.id.iv_bai2);
        this.btnAll = view.findViewById(R.id.btn_all);
        this.btnDoremon = view.findViewById(R.id.btn_doremon);
        this.btnNobita = view.findViewById(R.id.btn_nobita);
    }
}