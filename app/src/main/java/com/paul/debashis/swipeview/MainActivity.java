package com.paul.debashis.swipeview;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        MyAdapter mMyAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMyAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class MyAdapter extends FragmentStatePagerAdapter {
    private static final int FRAGMENT_COUINT = 3;
    CharSequence[] mCharSequence = {"Tab1","Tab2","Tab3"};
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Log.d("DEB","getItem is called with value i="+i);
        Fragment mFragment=null;
        if (i==0){
            mFragment = new FragmentA();
        }
        if (i==1){
            mFragment = new FragmentB();
        }
        if (i==2){
            mFragment = new FragmentC();
        }
        return mFragment;
    }

    @Override
    public int getCount() {
        Log.d("DEB","getCount is called");
        return FRAGMENT_COUINT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCharSequence[position];
    }
}