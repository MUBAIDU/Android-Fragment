package com.example.asus.todofragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ///// On Create() the system calls this when creating the fragment you are implementing
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //////  The Activity class uses a Fragment manager and a Fragment manager transactions to keep track
        // of the Back Stack and the Fragments.
        // The code below uses Fragment Manager to add the TodoFragment to the TodoActivity
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            /// calling new fragment
            TodoFragment todoFragment = new TodoFragment();
            fm.beginTransaction()
                    /**
                     * . method is adding the todoFragment to the calling Activity's view.
                     * a fragment is inserted into FrameLayout view object of the MainActivity.
                     */
                    .add(R.id.fragment_container, todoFragment)
                    .commit();
        }
    }
}
