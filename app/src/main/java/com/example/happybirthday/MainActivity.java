package com.example.happybirthday;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView image;
    private AnimationDrawable frameAnimation;
    AnimationDrawable mBackgroundAnimation;
    private  TransitionDrawable transitionDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    protected void onStart() {
        super.onStart();
        mBackgroundAnimation = new AnimationDrawable();
        mBackgroundAnimation.addFrame(getResources().getDrawable(R.drawable.birthday), 1000);
        mBackgroundAnimation.addFrame(getResources().getDrawable(R.drawable.birthday2), 1000);
        mBackgroundAnimation.setEnterFadeDuration(1000);
        mBackgroundAnimation.setOneShot(false);
        image.setBackground(mBackgroundAnimation);
        image.post(new AnimationStarterThread());
    }
    private class AnimationStarterThread implements Runnable {
        public void run() {
            if(mBackgroundAnimation != null)
                mBackgroundAnimation.start();
        }
    }


}