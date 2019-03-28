package com.git.gitapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;

public class WalkThrought1Activity extends Activity {

    private TextView tvSkip, tvNext;
    SharedPreferences preferances;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrought1);

        tvSkip = (TextView) findViewById(R.id.tvSkip);
        tvNext = (TextView) findViewById(R.id.tvNext);
        preferances = PreferenceManager
                .getDefaultSharedPreferences(WalkThrought1Activity.this);

        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WalkThrought1Activity.this, HomeActivity.class);
                startActivity(i);
                finish();

                overridePendingTransition(
                        R.anim.anim_slide_in_left,
                        R.anim.anim_slide_out_left);

                SharedPreferences.Editor editor = preferances.edit();
                editor.putString("walkthrought", "1");
                editor.commit();
            }
        });
        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WalkThrought1Activity.this, WalkThrought2Activity.class);
                startActivity(i);
                finish();

                overridePendingTransition(
                        R.anim.anim_slide_in_left,
                        R.anim.anim_slide_out_left);
            }
        });
    }
}

