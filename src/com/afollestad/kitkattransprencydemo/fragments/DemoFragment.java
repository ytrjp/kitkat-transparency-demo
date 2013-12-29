package com.afollestad.kitkattransprencydemo.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.afollestad.kitkattransprencydemo.R;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * @author Aidan Follestad (afollestad)
 */
public class DemoFragment extends Fragment {

    private int mStartAt;
    private ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStartAt = getArguments().getInt("value");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Fill the content list view with 100 list items
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_main);
        for (int i = mStartAt; i <= 100; i++)
            adapter.add("Trim to #" + i);

        ListView list = (ListView) view.findViewById(android.R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((FragmentDemoActivity) getActivity()).setFragment(new DemoFragment(), mStartAt + position);
            }
        });

        setInsets(list);
    }

    private void setInsets(View view) {
        SystemBarTintManager tintManager = new SystemBarTintManager(getActivity());
        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
        view.setPadding(0, config.getPixelInsetTop(true), config.getPixelInsetRight(), config.getPixelInsetBottom());
    }
}