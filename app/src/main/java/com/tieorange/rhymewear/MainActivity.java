package com.tieorange.rhymewear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

public class MainActivity extends Activity
        implements WearableListView.ClickListener {

    // Sample dataset for the list
    String[] elements = {"List Item 1", "List Item 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    // WearableListView click listener
    @Override
    public void onClick(WearableListView.ViewHolder v) {
        Integer tag = (Integer) v.itemView.getTag();
        // use this data to complete some action ...
    }

    @Override
    public void onTopEmptyRegionClick() {
    }
}