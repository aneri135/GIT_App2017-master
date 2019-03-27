package com.git.gitapp;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends Activity {

    CTimer refresh_timer;
    String walkthrought;
    boolean login_flag, skip;
    SharedPreferences preferances;
    TextView tvSplash, tvSplash1, tvSplash2;
    Animation animZoomOut;
    ImageView ivSplash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        tvSplash = (TextView) findViewById(R.id.tvSplash);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(tvSplash, "rotation", 360f, 0f);
        objectAnimator.setDuration(1000);
        ObjectAnimator scaleDownX = ObjectAnimator.ofFloat(tvSplash, "scaleX", 2.5f);
        ObjectAnimator scaleDownY = ObjectAnimator.ofFloat(tvSplash, "scaleY", 2.5f);
        scaleDownY.setDuration(3000);
        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(objectAnimator).with(scaleDownY).with(scaleDownX);
        scaleDown.start();

        tvSplash1 = (TextView) findViewById(R.id.tvSplash1);

        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(tvSplash1, "rotation", 360f, 0f);
        objectAnimator2.setDuration(3000);
        ObjectAnimator scaleDownX2 = ObjectAnimator.ofFloat(tvSplash1, "scaleX", 2.5f);
        ObjectAnimator scaleDownY2 = ObjectAnimator.ofFloat(tvSplash1, "scaleY", 2.5f);
        scaleDownY.setDuration(3000);
        AnimatorSet scaleDown2 = new AnimatorSet();
        scaleDown2.play(objectAnimator2).with(scaleDownY2).with(scaleDownX2);
        scaleDown2.start();

        tvSplash2 = (TextView) findViewById(R.id.tvSplash2);

        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(tvSplash2, "rotation", 360f, 0f);
        objectAnimator3.setDuration(3000);
        ObjectAnimator scaleDownX3 = ObjectAnimator.ofFloat(tvSplash2, "scaleX", 2.5f);
        ObjectAnimator scaleDownY3 = ObjectAnimator.ofFloat(tvSplash2, "scaleY", 2.5f);
        scaleDownY.setDuration(3000);
        AnimatorSet scaleDown3 = new AnimatorSet();
        scaleDown3.play(objectAnimator3).with(scaleDownY3).with(scaleDownX3);
        scaleDown3.start();

        ivSplash = (ImageView) findViewById(R.id.ivSplash);

//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(ivSplash, "rotation", 360f,0f);
//        objectAnimator1.setDuration(3000);
//        objectAnimator1.start();

//        ObjectAnimator moveAnim = ObjectAnimator.ofFloat(ivSplash, "Y", 400);
//        moveAnim.setDuration(2000);
//        moveAnim.setInterpolator(new LinearInterpolator());
//        moveAnim.start();

        refresh_timer = new CTimer(3000, 3000);
        refresh_timer.start();

        preferances = PreferenceManager
                .getDefaultSharedPreferences(SplashActivity.this);
        walkthrought = preferances.getString("walkthrought", "0");
        login_flag = preferances.getBoolean("login_flag", false);
        skip = preferances.getBoolean("skip", false);
    }

    public class CTimer extends CountDownTimer {
        // Note: Your consumer key and secret should be obfuscated in your
        // source code before shipping.


        public CTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            // TODO Auto-generated constructor stub
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            if (login_flag) {
                startActivity(new Intent(SplashActivity.this,
                        HomeActivity.class));

                overridePendingTransition(
                        R.anim.anim_slide_in_left,
                        R.anim.anim_slide_out_left);
            } else {
                startActivity(new Intent(SplashActivity.this,
                        LoginActivity.class));

                overridePendingTransition(
                        R.anim.anim_slide_in_left,
                        R.anim.anim_slide_out_left);
            }
        }

        @Override
        public void onTick(long millisUntilFinished) {
            // TODO Auto-generated method stub

        }
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();

        try {
            refresh_timer.cancel();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        try {
            refresh_timer.cancel();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
