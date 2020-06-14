package com.example.goalalarm;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class NewsActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView imageView;
    private TextView descTextView;
    private TextView dateTextView;

    DatabaseReference ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        titleTextView = findViewById(R.id.newstitleactivity_id);
        descTextView = findViewById(R.id.newsdescactivity_id);
        imageView = findViewById(R.id.newsactivityimg_id);
        dateTextView = findViewById(R.id.newsdateactivity_id);

        String NewsKey = getIntent().getStringExtra("NewsKey");
        ref = FirebaseDatabase.getInstance().getReference().child("news");
        ref.child(NewsKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String newsTitle = dataSnapshot.child("newsTitle").getValue().toString();
                    String newsDescription = dataSnapshot.child("newsDescription").getValue().toString();
                    String newsPostedDate = dataSnapshot.child("newsPostedDate").getValue().toString();
                    String newsImage = dataSnapshot.child("newsImage").getValue().toString();

                    Picasso.get().load(newsImage).into(imageView);
                    titleTextView.setText(newsTitle);
                    descTextView.setText(newsDescription);
                    dateTextView.setText(newsPostedDate);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
