package com.commonsware.empublite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;


public class NoteActivity extends FragmentActivity {

    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportFragmentManager().findFragmentById(android.R.id.content) == null) {
            int position = getIntent().getIntExtra(EXTRA_POSITION, -1);
            if (position >= 0) {
                Fragment f = NoteFragment.newInstance(position);
                getSupportFragmentManager().beginTransaction()
                        .add(android.R.id.content, f).commit();
            }
        }
    }

    void closeNotes() {
        finish();
    }

    void sendNotes(String prose) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, prose);
        startActivity(Intent.createChooser(i, getString(R.string.share_title)));
    }
}
