package com.example.asus.todofragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            TodoFragment todoFragment = new TodoFragment();
            fm.beginTransaction()
                    /**
                     * .add method is adding the todoFragment to the calling Activity's view.
                     * a fragment is inserted into FrameLayout view object of the MainActivity.
                     */
                    .add(R.id.fragment_container, todoFragment)
                    .commit();
        }
    }
}
