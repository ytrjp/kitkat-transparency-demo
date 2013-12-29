package com.afollestad.kitkattransprencydemo.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;
import com.afollestad.kitkattransprencydemo.MainActivity;
import com.afollestad.kitkattransprencydemo.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

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

    public static void setInsets(Activity context, View view) {
        SystemBarTintManager tintManager = new SystemBarTintManager(context);
        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
        view.setPadding(0, config.getPixelInsetTop(true), config.getPixelInsetRight(), config.getPixelInsetBottom());
    }
}
