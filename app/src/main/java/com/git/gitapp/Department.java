package com.git.gitapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.comman.CustomTypefaceSpan;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department extends AppCompatActivity {

    private String responseString, userName, emailId, phoneNo;
    SharedPreferences myPrefs;
    EditText edtName, edtDisc;
    ImageView ivPlus;
    private DrawerLayout mDrawerLayout;
    NavigationView navigationView;
    private View headerLayout;
    private TextView UserName;
    private Menu menu;


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);

        ivPlus = (ImageView) findViewById(R.id.ivPlus);
        ivPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Department.this, HomeActivity.class);
                startActivity(i1);
                finish();
            }
        });

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (childPosition) {
                    case 0:
                        Intent i1 = new Intent(Department.this, AboutDept.class);
                        startActivity(i1);
                        break;

                    case 1:
                        Intent i2 = new Intent(Department.this, ChatActivity.class);
                        startActivity(i2);
                        break;

                    case 2:

                        Intent i3 = new Intent(Department.this, VideoListActivity.class);
                        startActivity(i3);
                        break;
                }

                return false;
            }
        });


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Department");


        Spannable text2 = new SpannableString(ab.getTitle());
        text2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.white)), 0, text2.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        ab.setTitle(text2);

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
                        Intent i1 = new Intent(Department.this, HomeActivity.class);
                        startActivity(i1);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_aboutGit:
                        Intent i2 = new Intent(Department.this, AboutGit.class);
                        startActivity(i2);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_department:
                        Intent i3 = new Intent(Department.this, Department.class);
                        startActivity(i3);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_circular:
                        Intent i4 = new Intent(Department.this, Circular.class);
                        startActivity(i4);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_newsFeed:
                        Intent i5 = new Intent(Department.this, NewsFeed.class);
                        startActivity(i5);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_event:
                        Intent i6 = new Intent(Department.this, Events.class);
                        startActivity(i6);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;

                    case R.id.nav_gallery:
                        Intent i7 = new Intent(Department.this, Gallery.class);
                        startActivity(i7);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_contactus:
                        Intent i8 = new Intent(Department.this, ConatctusActivity.class);
                        startActivity(i8);
                        finish();

                        overridePendingTransition(
                                R.anim.anim_slide_in_left,
                                R.anim.anim_slide_out_left);
                        break;


                    case R.id.nav_Share:
                        FirebaseAuth.getInstance().signOut();
                        Intent I=new Intent(Department.this,LoginActivity.class);
                        startActivity(I);
                        break;


                }
                mDrawerLayout.closeDrawer(navigationView);
                return true;
            }
        });
    }

    public void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Civil Engineering");
        listDataHeader.add("Computer Engineering");
        listDataHeader.add("Electronics & Comm.");
        listDataHeader.add("Mechanical Engineering");
        listDataHeader.add("Information Technology");
        listDataHeader.add("Electrical Engineering");
        listDataHeader.add("Mathimatics Department");
        listDataHeader.add("MBA");


        // Adding child data
        List<String> CivilEngineering = new ArrayList<String>();
        CivilEngineering.add("About");
       // CivilEngineering.add("Faculty Members");
//        CivilEngineering.add("Lab Facilities");
        CivilEngineering.add("Discussion Forum");
        CivilEngineering.add("Videos");


        List<String> ComputerEngineering = new ArrayList<String>();
        ComputerEngineering.add("About");
      //  ComputerEngineering.add("Faculty Members");
//        ComputerEngineering.add("Lab Facilities");
        ComputerEngineering.add("Discussion Forum");
        ComputerEngineering.add("Videos");


        List<String> ElectronicsComm = new ArrayList<String>();
        ElectronicsComm.add("About");
       // ElectronicsComm.add("Faculty Members");
//        ElectronicsComm.add("Lab Facilities");
        ElectronicsComm.add("Discussion Forum");
        ElectronicsComm.add("Video");



        List<String> MechanicalEngineering = new ArrayList<String>();
        MechanicalEngineering.add("About");
      //  MechanicalEngineering.add("Faculty Members");
//        MechanicalEngineering.add("Lab Facilities");
        MechanicalEngineering.add("Discussion Forum");
        MechanicalEngineering.add("Video");



        List<String> InformationTechnology = new ArrayList<String>();
        InformationTechnology.add("About");
        InformationTechnology.add("Faculty Members");
//        InformationTechnology.add("Lab Facilities");
        InformationTechnology.add("Discussion Forum");
        InformationTechnology.add("Video");


        List<String> MathimaticsDepartment = new ArrayList<String>();
        MathimaticsDepartment.add("About");
       // MathimaticsDepartment.add("Faculty Members");
        // MathimaticsDepartment.add("Lab Facilities");
        MathimaticsDepartment.add("Discussion Forum");
        MathimaticsDepartment.add("Video");



        List<String> ElectricalEngineering = new ArrayList<String>();
        ElectricalEngineering.add("About");
        //ElectricalEngineering.add("Faculty Members");
        //ElectricalDepartment.add("Lab Facilities");
        ElectricalEngineering.add("Discussion Forum");
        ElectricalEngineering.add("Video");


        List<String> Mba = new ArrayList<String>();
        Mba.add("About");
      //  Mba.add("Faculty Members");
//        Mba.add("Lab Facilities");
        Mba.add("Discussion Forum");
        Mba.add("Video");



        listDataChild.put(listDataHeader.get(0), CivilEngineering);
        listDataChild.put(listDataHeader.get(1), ComputerEngineering);
        listDataChild.put(listDataHeader.get(2), ElectronicsComm);
        listDataChild.put(listDataHeader.get(3), MechanicalEngineering);
        listDataChild.put(listDataHeader.get(4), InformationTechnology);
        listDataChild.put(listDataHeader.get(5), MathimaticsDepartment);
        listDataChild.put(listDataHeader.get(6), ElectricalEngineering);
        listDataChild.put(listDataHeader.get(7), Mba);

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
