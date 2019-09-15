package com.example.heyhelper;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    Handler handler= new Handler();
    EditText email;
    EditText password;
    String emails;
    String passwords;
    boolean loginAdmin=false,loginDoctor=false,loginHelper=false,loginPatient=false;


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
        email = (EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);

        btn = (Button)findViewById(R.id.login);

        handler.postDelayed(runnable,2000);

    }


    public void signUp(View view) {
        Intent intent=new Intent(this,SignUp.class);
        startActivity(intent);
    }




    public void logIn(View view) {
        emails=email.getText().toString();
        passwords=password.getText().toString();


        myRef = FirebaseDatabase.getInstance().getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                int sizeAdmin= (int) dataSnapshot.child("Admin").getChildrenCount();
                int sizeDoctor= (int) dataSnapshot.child("Doctor").getChildrenCount();
                int sizeHelper= (int) dataSnapshot.child("Helper").getChildrenCount();
                int sizePatient= (int) dataSnapshot.child("Patient").getChildrenCount();
                System.out.println("email "+emails);
                System.out.println("passwrod "+passwords);


           /*   if((loginDoctor==false && (loginAdmin == false) && loginHelper == false && (loginPatient == false))) {
                  for (int i = 1; i <= sizeAdmin; i++) {
                      String demail = dataSnapshot.child("Admin/" + i + "/Email").getValue().toString();
                      String dpassword = dataSnapshot.child("Admin/" + i + "/Password").getValue().toString();
                      System.out.println("ddemail " + demail);
                      System.out.println("ddpasswrod " + dpassword);

                      if (emails.equals(demail) && passwords.equals(dpassword)) {
                          loginAdmin = true;
                          break;
                       }

                  }
              }*/


                    for (int i = 1; i <= sizeHelper; i++) {
                        String demail = dataSnapshot.child("Helper/" + i + "/Email").getValue().toString();
                        String dpassword = dataSnapshot.child("Helper/" + i + "/Password").getValue().toString();
                        System.out.println("ddemail " + demail);
                        System.out.println("ddpasswrod " + dpassword);

                        if (emails.equals(demail) && passwords.equals(dpassword)) {
                            loginHelper = true;
                            break;
                        }

                    }


                for(int i=1;i<=sizeDoctor;i++){
                    String demail = dataSnapshot.child("Doctor/"+i+"/Email").getValue().toString();
                    String dpassword = dataSnapshot.child("Doctor/"+i+"/Password").getValue().toString();
                    System.out.println("ddemail "+demail);
                    System.out.println("ddpasswrod "+dpassword);

                    if(emails.equals(demail) && passwords.equals(dpassword)){
                        loginDoctor=true;
                        break;
                    }

                }



                    for (int i = 1; i <= sizePatient; i++) {
                        String demail = dataSnapshot.child("Patient/" + i + "/Email").getValue().toString();
                        String dpassword = dataSnapshot.child("Patient/" + i + "/Password").getValue().toString();
                        System.out.println("ddemail " + demail);
                        System.out.println("ddpasswrod " + dpassword);

                        if (emails.equals(demail) && passwords.equals(dpassword)) {
                            loginPatient = true;
                            break;
                        }

                    }

                }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



       /* if(loginAdmin==true){
            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("type","Doctor");
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show();
        }*/

        if(loginPatient==true){
            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity.class);
             intent.putExtra("type","Patient");
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show(); }

        if(loginHelper==true){
            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("type","Helper");
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show();
        }


        if(loginDoctor==true){
            Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,MainActivity.class);
            intent.putExtra("type","Doctor");
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Logging in", Toast.LENGTH_SHORT).show();
        }

    }
}
