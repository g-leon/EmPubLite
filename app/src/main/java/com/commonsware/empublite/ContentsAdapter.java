package com.commonsware.empublite;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ContentsAdapter extends FragmentStatePagerAdapter {

    public ContentsAdapter(FragmentActivity ctxt) {
        super(ctxt.getSupportFragmentManager());
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
