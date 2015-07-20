package com.cypressworks.tablayoutbug;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();

        if (savedInstanceState == null) {
            fm.beginTransaction().replace(R.id.content, new Fragment1()).commit();
        }

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                fm.beginTransaction().replace(R.id.content, new Fragment2()).addToBackStack(
                        null).commit();
            }
        });
    }

}
