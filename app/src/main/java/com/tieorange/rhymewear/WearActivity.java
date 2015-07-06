package com.tieorange.rhymewear;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;

import java.util.ArrayList;
import java.util.List;

public class WearActivity extends Activity implements WearableListView.ClickListener {

    private WearableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);



        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                listView = (WearableListView) stub.findViewById(R.id.sample_list_view);
                loadAdapter();

            }
        });


    }

    private void loadAdapter() {
        List<SettingsItems> items = new ArrayList<>();
        items.add(new SettingsItems(R.drawable.ic_full_cancel, getString(R.string.theme)));
        items.add(new SettingsItems(R.drawable.ic_full_sad, getString(R.string.more_on_phone)));


        SettingsAdapter mAdapter = new SettingsAdapter(this, items);


        listView.setAdapter(mAdapter);

        listView.setClickListener(this);
    }


    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {
        switch (viewHolder.getPosition()) {
            case 0:
                //Do something
                break;
            case 1:
               //Do something else
                break;
        }
    }

    @Override
    public void onTopEmptyRegionClick() {
        //Prevent NullPointerException
    }
}