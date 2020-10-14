package com.example.socialmedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
//import com.google.firebase.firestore.getId;
import com.google.firebase.firestore.QuerySnapshot;


public class Reading extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db.collection("Posts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                System.out.println(document.getId());
                                //System.out.println(document.getData());
                                String PostToShow = (document.getId()).toString();
                                TextView textView = findViewById(R.id.textView2);
                                textView.setText(PostToShow);




                                //CollectionReference Posts = db.collection("Posts");
                                    // [START fs_order_by_name_limit_query]
                                // Query query = Posts.orderBy("date").limitToLast(5);
                                    // [END fs_order_by_name_limit_query]

                                //textView.setText(query.toString());

                            }
                        }
                        else{
                            Log.w("tag", "Error getting Posts.",task.getException()) ;
                        }
                    }
                });



        setContentView(R.layout.activity_reading);
    }

    public void onClickPost(View view){


        Intent intent = new Intent(this,Post.class);

        startActivity(intent);
    }
}