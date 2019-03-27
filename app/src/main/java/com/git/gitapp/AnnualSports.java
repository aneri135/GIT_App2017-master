package com.git.gitapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;


public class AnnualSports extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(
                R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_right);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annual_sports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        android.support.v7.widget.Toolbar toolbar1 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);


        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Annual Sports");


        WebView webView = (WebView) findViewById(R.id.wv1);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + "<b>"
                + "Annual Sports"
                + "</b>"
                + "</p>"
                + "<p align=\"justify\">"
                + "Every year The Annual Sports Meet is organized at the College Campus. Students and Faculties are at their harmony to organize panoramic activities related to sports events. Gandhinagar Institute of Technology has formed a “Sports Committee” for bringing out talent in students and giving them a platform to perform in sports events organized by college, other colleges and GTU which is helpful for overall development of students physically and mentally.  It also used to increase levels of discipline and sportsman spirit. The whole event is organized not only inside the GIT Campus, but also at some prime Sports locations of Gujarat State. There are 8 sports activities conducted (4 outdoor & 4 indoor) where more then 600+ players in cricket, 400+ players in Volleyball, 250+ players in Kabbadi, 600+ players in badminton, 350+ players in Carom, 150+ players in Table-Tennis and 180+ players in Chess, participates in the competition every year."
                + "</p>"
                + "</body></html>";

        webView.loadData(text, "text/html", "utf-8");


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == android.R.id.home) {
            finish();

            overridePendingTransition(
                    R.anim.anim_slide_in_right,
                    R.anim.anim_slide_out_right);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
