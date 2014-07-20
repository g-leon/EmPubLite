package com.commonsware.empublite;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class EmPubLiteActivity extends FragmentActivity {

    private ViewPager pager = null;
    private ContentsAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        pager = (ViewPager)findViewById(R.id.pager);
        adapter = new ContentsAdapter(this);
        pager.setAdapter(adapter);
        findViewById(R.id.progressBar1).setVisibility(View.GONE);
        findViewById(R.id.pager).setVisibility(View.VISIBLE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                return(true);
            case R.id.about:
                Intent i = new Intent(this, SimpleContentActivity.class);
                startActivity(i);
                return(true);
            case R.id.help:
                i = new Intent(this, SimpleContentActivity.class);
                startActivity(i);
                return(true);
        }
        return super.onOptionsItemSelected(item);
    }
}
