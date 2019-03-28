package com.git.gitapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;


public class Tx extends AppCompatActivity {

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
        setContentView(R.layout.activity_tx);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.widget.Toolbar toolbar1 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);


        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Tech-Xtreme");


        WebView webView = (WebView) findViewById(R.id.wv1);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + "<b>"
                + "Tech-Xtreme(Technical Festival)"
                + "</b>"
                + "</p>"
                + "<p align=\"justify\">"
                + "Every year Gandhinagar Institute of Technology organizes Tech-Xtreme: A National level technical festival. It comprise Various competitions motivate the students to bring out their inner skills. The motive behind the TechFest is to demonstrate how technology can be imparted in society via various interesting ways. Since beginning this festival becomes proud moments for GIT  Various competitions related to the Robotics, Dirt Rush GT (Robo- race Event) and Robo-puzzle are also major attractions in which robots perform tedious tasks. Search Spider (event based on Google hunt), Walk on Fire (event based on Laser light), Bomb Diffuser (based on Circuit Design Concepts), event based on theme of re-use of waste water, Pharma Recipe (Stereo Pharma Model competition), Corpoquiz (Business Quiz), Concourse De Design (Cad Competition) Computer Programming, Electronic Circuit designing, Design of suspension bridge, Pharma model making, Patent track, Open source software event, event based on design of Earthquake resistant structure and business plan competition are among a few of its  major attractions. Cash prizes of more than Rs 1 lakh and Certificates are distributed to the winners in the grand valedictory. Workshops on different subjects and emerging topics have also been organized during these two days with a  great support from the Industries for the participants to have latest know how in today’s industrial economy. It also helps them to expand their knowledge to industry level and standards and beyond that to make one’s life easier which is any engineer’s motto."
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
