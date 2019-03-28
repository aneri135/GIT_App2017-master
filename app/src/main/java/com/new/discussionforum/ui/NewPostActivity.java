package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.models.Thread;

import com.example.guest.discussionforum.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseReference mThreadsReference;

    @Bind(R.id.userNameEditText) EditText mUserNameEditText;
    @Bind(R.id.messageEditText) EditText mMessageEditText;
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.categorySpinner) Spinner mCategorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mThreadsReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_THREADS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        ButterKnife.bind(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCategorySpinner.setAdapter(adapter);

        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mSubmitButton) {

            String userName = mUserNameEditText.getText().toString();
            String message = mMessageEditText.getText().toString();
            Thread newThread = new Thread(userName, message);

            DatabaseReference pushRef = mThreadsReference.push();
            String pushId = pushRef.getKey();
            newThread.setPushId(pushId);
            pushRef.setValue(newThread);

            Intent intent = new Intent(NewPostActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
