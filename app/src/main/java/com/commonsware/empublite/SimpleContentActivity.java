package com.commonsware.empublite;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public class SimpleContentActivity extends FragmentActivity {

    public static final String EXTRA_FILE = "file";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            String file = getIntent().getStringExtra(EXTRA_FILE);
            Fragment f = SimpleContentFragment.newInstance(file);
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, f).commit();
        }
    }
}
