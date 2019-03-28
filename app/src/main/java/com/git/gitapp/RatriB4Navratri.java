package com.git.gitapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;


public class RatriB4Navratri extends AppCompatActivity {

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
        setContentView(R.layout.activity_ratri_b4_navratri);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        android.support.v7.widget.Toolbar toolbar1 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);


        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Ratri B4 Navratri");


        WebView webView = (WebView) findViewById(R.id.wv1);

        String text = "<html><body>"
                + "<p align=\"justify\">"
                + "<b>"
                + "Ratri B4 Navratri"
                + "</b>"
                + "</p>"
                + "<p align=\"justify\">"
                + "Teaching a sense of culture and unity is the spirit of any Indian festival and Navratri is a portrayal of color, action, music and devotedness. The Navratri celebration is devoted to the worship of the Eternal mother which has its origins in the Vedas. Durga is also considered to be a combination of the Trinity of goddesses- Saraswati, Parvati, and Lakshmi. During Navratri, these three main goddesses are worshipped as well. Students along with staff dressed in colorful traditional Gujarati costume performed Raas and Garba. Youthful students and faculty members of the Institute perform in this grand gala Annual Garba Event. Mr. Arvind Vegda, the singer of BHAI BHAI was the star attraction of last Navratri night. Every year, Prizes are given to the winners of various categories including best costume, best solo dance, best group dance etc. Huge Media coverage is attained during the Garba Night."
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
