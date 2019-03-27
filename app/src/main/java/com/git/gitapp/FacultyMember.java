package com.git.gitapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.model.FacultyModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FacultyMember extends AppCompatActivity {


    public static final int CONNECTION_TIMEOUT = 20000;
    public static final int READ_TIMEOUT = 25000;
    private static final String TAG = "MainActivity";
    public static String DEPT_VAL = "deptVal";

    private RecyclerView rFaculty;
    private RecyclerView.Adapter mAdapter;
    private TextView tvName;

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        overridePendingTransition(
                R.anim.anim_slide_in_right,
                R.anim.anim_slide_out_right);
    }

    RecyclerView recyclerView;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_member);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Intent intent=getIntent();
//        String dept=intent.getStringExtra("dept");
//
//        Log.e("Dept",""+dept);

        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_action_navigation_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Faculty Members");


        android.support.v7.widget.Toolbar toolbar1 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);


        recyclerView = (RecyclerView) findViewById(R.id.rFaculty);


//        RecyclerAdapter4 adapter = new RecyclerAdapter4(this);
//        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new AsyncLogin().execute();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
    }


    protected class AsyncLogin extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(FacultyMember.this);
        HttpURLConnection conn;
        URL url = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();


            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Intent intent = getIntent();
                String dept = intent.getStringExtra("dept");
                Log.e("dept", dept);

                // Enter URL address where your json file resides
                // Even you can make call to php file which returns json data
                url = new URL("http://gitapp.ravikoradiya.com/deptapi.php?dept=" + dept);

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return e.toString();
            }
            try {

                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection) url.openConnection();
//                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("GET");

                // setDoOutput to true as we recieve data from json file
                conn.setDoOutput(true);
                conn.setDoInput(true);

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return e1.toString();
            }

            try {
                int response_code = conn.getResponseCode();
                Log.d(TAG, "doInBackground: " + response_code);


                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return (result.toString());

                } else {

                    return ("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return e.toString();
            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {

            Log.e(TAG, "onPostExecute: " + result);

            //this method will be running on UI thread
            pdLoading.dismiss();
            List<FacultyModel> data = new ArrayList<>();

//            data = new Gson().fromJson(result, data.getClass());
            FacultyModel facultyModel[] = new Gson().fromJson(result, FacultyModel[].class);
            data = Arrays.asList(facultyModel);
            pdLoading.dismiss();
            try {

                JSONArray jArray = new JSONArray(result);

                // Extract data from json and store into ArrayList as class objects
//                for (int i = 0; i < jArray.length(); i++) {
////                    JSONObject json_data=new JSONObject(result);
//                    JSONObject json_data = jArray.getJSONObject(i);
//                    Data fishData = new Data();
//                    fishData.fName = json_data.getString("full_name");
//                    fishData.fExp = json_data.getString("work_exp");
//                    fishData.fQualification = json_data.getString("edu_qualification");
//                    fishData.fMail = json_data.getString("email");
//                    fishData.fDesignation = json_data.getString("designation");
//
//
//                    data.add(fishData);
//                }

                // Setup and Handover data to recyclerview
                rFaculty = (RecyclerView) findViewById(R.id.rFaculty);
                mAdapter = new RecyclerAdapter4(FacultyMember.this, data);
                rFaculty.setAdapter(mAdapter);
                rFaculty.setLayoutManager(new LinearLayoutManager(FacultyMember.this));

            } catch (JSONException e) {


                // TODO Auto-generated catch block
                Log.d("HTTP", "Error parsing data " + e.toString());
                Log.d("HTTP", "Failed data was:\n" + result);
                e.printStackTrace();
            }

        }

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
