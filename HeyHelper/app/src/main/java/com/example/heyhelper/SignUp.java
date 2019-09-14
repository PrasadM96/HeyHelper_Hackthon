package com.example.heyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {

    EditText semail=(EditText) findViewById(R.id.signupEmail);
    EditText spassword = (EditText) findViewById(R.id.signupPassword);
    EditText sName = (EditText) findViewById(R.id.signName);
    String email,password,name;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mDatabase = FirebaseDatabase.getInstance().getReference();


    }

    public void logIn2(View view) {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }

    public void signUP(View view) {
        email=semail.getText().toString();
        name=sName.getText().toString();
        password=semail.getText().toString();



    }
}
