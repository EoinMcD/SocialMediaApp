package com.example.socialmedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class Reading extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_reading);
    }

    private void onClickPost(){
        CollectionReference Posts = db.collection("Posts");
        EditText editText = (EditText) findViewById(R.id.PostMessage);
        String message = editText.getText().toString();
        Posts.document(message);
    }
}