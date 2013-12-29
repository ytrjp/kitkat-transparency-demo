package com.afollestad.kitkattransprencydemo.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.afollestad.kitkattransprencydemo.MainActivity;
import com.afollestad.kitkattransprencydemo.R;

/**
 * @author Aidan Follestad (afollestad)
 */
public class FragmentDemoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentdemo);
        setFragment(new DemoFragment(), getIntent().getIntExtra("start_at", 1));

        MainActivity.setupTint(this);
    }

    public void setFragment(Fragment frag, int value) {
        Bundle args = new Bundle();
        args.putInt("value", value);
        frag.setArguments(args);
        getFragmentManager().beginTransaction().replace(R.id.content, frag).commit();
    }
}
