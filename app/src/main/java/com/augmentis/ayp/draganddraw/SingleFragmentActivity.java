package com.augmentis.ayp.draganddraw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        //Create Fragment Container
        FragmentManager fm = getSupportFragmentManager();
        Fragment f = fm.findFragmentById(R.id.fragment_container);


        if( f == null){
            f = onCreateFragment(); // Create Fragment

            // Set Fragment to Fragment Container
            fm.beginTransaction()
                    .add(R.id.fragment_container,f)
                    .commit();
        }
    }
    protected abstract Fragment onCreateFragment();
}
