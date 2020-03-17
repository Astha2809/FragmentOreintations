package com.example.fragmentoreintations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    FragmentColorsName fragmentColorsName = new FragmentColorsName();
    FragmentColorDescription fragmentColorDescription = new FragmentColorDescription();
    int value;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.framecontainer,fragmentColorsName);
        //fragmentTransaction.commit();
        activity = MainActivity.this;

        value = activity.getResources().getConfiguration().orientation;
        if (value == Configuration.ORIENTATION_LANDSCAPE) {

            Bundle bundle = new Bundle();
            bundle.putInt("oritentation", value);
            FragmentColorsName fragmentColorsName = new FragmentColorsName();
            fragmentColorsName.setArguments(bundle);

            fragmentTransaction.replace(R.id.frame1, fragmentColorsName);


            fragmentTransaction.replace(R.id.frame2, fragmentColorDescription);
            fragmentTransaction.commit();

        } else {

            Bundle bundle = new Bundle();
            bundle.putInt("oritentation", value);
            FragmentColorsName fragmentColorsName = new FragmentColorsName();
            fragmentColorsName.setArguments(bundle);

            fragmentTransaction.replace(R.id.framecontainer, fragmentColorsName);
            fragmentTransaction.commit();
        }
    }

}
