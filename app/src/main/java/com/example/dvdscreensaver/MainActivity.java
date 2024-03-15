package com.example.dvdscreensaver;

import static java.security.AccessController.getContext;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class MainActivity extends Activity {
    ObjectAnimator animatorX;
    ObjectAnimator animatorY;
    ImageView androidLogoView;
    int logoWidth;
    int logoHeight;
    private final int[] basicColors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_image);
        androidLogoView = findViewById(R.id.android_icon);
        androidLogoView.setImageTintList(ColorStateList.valueOf(Color.GREEN));

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        logoWidth = androidLogoView.getDrawable().getIntrinsicWidth();
        logoHeight = androidLogoView.getDrawable().getIntrinsicHeight();

        animatorX = ObjectAnimator.ofFloat(androidLogoView, "translationX", 0f, screenWidth - logoWidth);
        animatorX.setDuration(5000);
        animatorX.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorX.setRepeatMode(ObjectAnimator.REVERSE);
        animatorX.setRepeatCount(ObjectAnimator.INFINITE);
        animatorX.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                changeColor();
            }
        });

        animatorY = ObjectAnimator.ofFloat(androidLogoView, "translationY", 0f, screenHeight - logoHeight);
        animatorY.setDuration(4000);
        animatorY.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorY.setRepeatMode(ObjectAnimator.REVERSE);
        animatorY.setRepeatCount(ObjectAnimator.INFINITE);
        animatorY.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                changeColor();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, animatorY);
        animatorSet.start();
    }

    private void changeColor() {
        Random random = new Random();
        int randomIndex = random.nextInt(basicColors.length);
        int randomColor = basicColors[randomIndex];
        androidLogoView.setColorFilter(randomColor);
    }
}

