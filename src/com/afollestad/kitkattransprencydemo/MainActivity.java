package com.afollestad.kitkattransprencydemo;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fill the content list view with 100 list items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_main);
        for (int i = 1; i <= 100; i++)
            adapter.add("List item " + i);
        ((ListView) findViewById(android.R.id.list)).setAdapter(adapter);

        // Only set the tint if the device is running KitKat or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.status_bar_tint);
        }
    }
}
