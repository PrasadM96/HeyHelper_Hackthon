package com.example.heyhelper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class help extends AppCompatActivity {
    String value="";

    private Spinner spinner;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        spinner = findViewById(R.id.spinner);
        editText=(EditText)findViewById(R.id.editText);
        /// spinner.requestFocus();

        List<String>categories = new ArrayList<>();

        categories.add(0,"CUSTOM");
        categories.add("PLEASE CALL ME");
        categories.add("PAYMENT");
        categories.add("BUY");
        categories.add("LIFT");

        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        editText.setText(spinner.getSelectedItem().toString());
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                value =  ((TextView)view).getText().toString();
                ((TextView)view).setText(null);
                if (value.equals("CUSTOM")) {
                    //editText.requestFocus();
                    //@@@@editText.setText(null);
                    editText.setText(null);

                }

//                if(parent.getItemAtPosition(position).equals("choose help")){
//                       //DO NOTHING
//                }

                else{
//                    String item = parent.getItemAtPosition(position).toString();
                    editText.setText(value);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void send(View view){
        //String msg=;
        EditText value = (EditText)findViewById(R.id.editText);
        String value1 =  value.getText().toString();
        //editText.setText(value);
        Toast.makeText(this,value1,Toast.LENGTH_SHORT).show();
    }
}
