package com.example.heyhelper;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class helpie extends Fragment {
    public void emer (View view){
        Log.i("info","emergency button pressed");

    }
    public void nemer (View view){
        Log.i("info","non emergency button pressed");
        Intent intent = new Intent(getContext(),help.class);
        startActivity(intent);
    }

    public helpie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_helpie, container, false);
    }

}
