package com.aliasapps.tabwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeasonScheduleFragment main = SeasonScheduleFragment.newInstance("some text", "more text");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, main)
                .commitNow();
    }
}
