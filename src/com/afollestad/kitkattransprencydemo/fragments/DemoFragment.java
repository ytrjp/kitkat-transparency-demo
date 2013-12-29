package com.afollestad.kitkattransprencydemo.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.afollestad.kitkattransprencydemo.R;

/**
 * @author Aidan Follestad (afollestad)
 */
public class DemoFragment extends ListFragment {

    private int mStartAt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStartAt = getArguments().getInt("value");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fill the content list view with 100 list items
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_main);
        for (int i = mStartAt; i <= 100; i++)
            adapter.add("Display #" + i);
        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((FragmentDemoActivity) getActivity()).setFragment(new DemoSubFragment(), position);
            }
        });

        setListShown(true);
    }
}
