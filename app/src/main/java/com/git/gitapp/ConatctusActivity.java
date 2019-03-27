package com.git.gitapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.comman.CustomTypefaceSpan;
import com.google.firebase.auth.FirebaseAuth;

public class ConatctusActivity extends AppCompatActivity {

    private String responseString, userName, emailId, phoneNo;
    SharedPreferences myPrefs;
    EditText edtName, edtDisc;
    ImageView ivPlus;
    private DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    private View headerLayout;
    private TextView UserName;
    private Menu menu;

    Button gmail, call, fb, twit, fax;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactus);

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Contact us");

        gmail = (Button) findViewById(R.id.gmail);

        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:director@git.org.in");
                intent.setData(data);
                startActivity(intent);
            }
        });
        call = (Button) findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent1 = new Intent(Intent.ACTION_CALL);
                callIntent1.setData(Uri.parse("tel:9904405900"));
                startActivity(callIntent1);
            }
        });
        fb = (Button) findViewById(R.id.fb);

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.facebook.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        twit = (Button) findViewById(R.id.twit);

        twit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.twitter.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);


            }
        });
        fax = (Button) findViewById(R.id.fax);

        fax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:02764-281862"));
                startActivity(callIntent);
            }
        });

//        Button dev;
//        dev=(Button) findViewById(R.id.dev);
//        dev.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(ConatctusActivity.this,Developer.class);
//                startActivity(intent);
//            }
//        });


        Spannable text2 = new SpannableString(ab.getTitle());
        text2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, text2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        ab.setTitle(text2);


        ivPlus = (ImageView) findViewById(R.id.ivPlus);
        ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ConatctusActivity.this, HomeActivity.class);
                startActivity(i1);
                finish();
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        menu = navigationView.getMenu();

        headerLayout =
                navigationView.inflateHeaderView(R.layout.nav_header);


        Menu m = navigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        Intent i1 = new Intent(ConatctusActivity.this, HomeActivity.class);
                        startActivity(i1);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_aboutGit:
                        Intent i2 = new Intent(ConatctusActivity.this, AboutGit.class);
                        startActivity(i2);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_department:
                        Intent i3 = new Intent(ConatctusActivity.this, Department.class);
                        startActivity(i3);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_circular:
                        Intent i4 = new Intent(ConatctusActivity.this, Circular.class);
                        startActivity(i4);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_newsFeed:
                        Intent i5 = new Intent(ConatctusActivity.this, NewsFeed.class);
                        startActivity(i5);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_event:
                        Intent i6 = new Intent(ConatctusActivity.this, Events.class);
                        startActivity(i6);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_gallery:
                        Intent i7 = new Intent(ConatctusActivity.this, Gallery.class);
                        startActivity(i7);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_contactus:
                        Intent i8 = new Intent(ConatctusActivity.this, ConatctusActivity.class);
                        startActivity(i8);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_Share:
                        FirebaseAuth.getInstance().signOut();
                        Intent I=new Intent(ConatctusActivity.this,LoginActivity.class);
                        startActivity(I);
                        break;


                }
                mDrawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/proximanova-semibold-webfont.ttf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("", font), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == android.R.id.home) {
            if (mDrawerLayout.isDrawerOpen(navigationView)) {
                mDrawerLayout.closeDrawer(navigationView);
                mDrawerLayout.closeDrawer(navigationView);
            } else {
                mDrawerLayout.openDrawer(navigationView);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}


