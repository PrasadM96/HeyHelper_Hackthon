package com.example.heyhelper;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    Handler handler = new Handler();
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    Button btn;



    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        rellay1 = (RelativeLayout) findViewById(R.id.relay1);
        rellay2 = (RelativeLayout) findViewById(R.id.relay2);

        btn = (Button)findViewById(R.id.login);

        handler.postDelayed(runnable,2000);
    }

    public void logIn(View view) {

        myRef = FirebaseDatabase.getInstance().getReference().child("Patient");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String email = dataSnapshot.child("Email").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
