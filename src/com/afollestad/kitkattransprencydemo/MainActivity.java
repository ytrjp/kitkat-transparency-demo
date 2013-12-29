package com.afollestad.kitkattransprencydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.afollestad.kitkattransprencydemo.fragments.FragmentDemoActivity;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fill the content list view with 100 list items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_main);
        for (int i = 1; i <= 100; i++)
            adapter.add("Start at #" + i);

        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, FragmentDemoActivity.class)
                        .putExtra("start_at", position + 1));
            }
        });

        setupTint(this);
    }

    public static void setupTint(Activity context) {
        // Only set the tint if the device is running KitKat or above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager tintManager = new SystemBarTintManager(context);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.status_bar_tint);
        }
    }
}
