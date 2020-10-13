package com.example.socialmedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Post extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
    }

    public void post(View view){
        CollectionReference Posts = db.collection("Posts");

        db.collection("Posts");
         EditText editText = (EditText) findViewById(R.id.Message);
        String PostMessage = editText.getText().toString();
        Map<String,Object> Posts1 = new HashMap<>();
        Posts1.put("Post",PostMessage);

        Posts.document(PostMessage).set(Posts1);

        Intent intent = new Intent(this,Reading.class);

        startActivity(intent);



        /*EditText editText = (EditText) findViewById(R.id.Message);
        String message = editText.getText().toString();
        Intent intent = new Intent(this,Reading.class);
        intent.putExtra(Message,message);
        startActivity(intent); */
    }
}