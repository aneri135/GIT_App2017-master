package com.git.gitapp;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;

public class FolderImage extends AppCompatActivity {
    RecyclerView recyclerView;


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(
                R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_right);
    }

    String[] fileNames;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folder_image);

        path = getIntent().getStringExtra("name");
        try {
            fileNames = getAssets().list("images/" + path);
        } catch (IOException e) {
            e.printStackTrace();
        }


        initViews();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);
//        ab.setTitle("Faculty Members");


        android.support.v7.widget.Toolbar toolbar1 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

//        ArrayList<AndroidVersion> androidVersions = prepareData();
        FolderImageAdapter adapter = new FolderImageAdapter(getApplicationContext(), path, fileNames);
        recyclerView.setAdapter(adapter);

    }

//    private ArrayList<AndroidVersion> prepareData() {
//
//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        Log.e("name", name);
//
//        ArrayList<AndroidVersion> android_version = new ArrayList<>();
//        for (int i = 0; i < fileNames.length; i++) {
//            AndroidVersion androidVersion = new AndroidVersion();
//            androidVersion.setAndroid_version_name(android_version_names[i]);
//            androidVersion.setAndroid_image_url(android_image_urls[i]);
//            android_version.add(androidVersion);
//        }
//        return android_version;
//    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item != null && item.getItemId() == R.id.home) {
            finish();
            overridePendingTransition(
                    R.anim.anim_slide_in_right,
                    R.anim.anim_slide_out_right);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
