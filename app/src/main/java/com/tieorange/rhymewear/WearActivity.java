package com.tieorange.rhymewear;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.wearable.view.WatchViewStub;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WearActivity extends Activity implements WearableListView.ClickListener {

    private static final int REQ_CODE_SPEECH_INPUT = 777;
    private WearableListView listView;
    private List<Rhyme> items;
    private SettingsAdapter mAdapter;
    private ArrayList<Rhyme> mRhymesList = new ArrayList<>();
    String url = "http://rhymebrain.com/talk?function=getRhymes&word=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);

        mRhymesList.add(new Rhyme("about"));
        mRhymesList.add(new Rhyme("act out"));
        mRhymesList.add(new Rhyme("skaut"));


        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                listView = (WearableListView) stub.findViewById(R.id.sample_list_view);

                promptSpeechInput();


            }
        });


    }

    public void getJson(final Context context, String word) {
        Ion.with(context)
                .load(url + word)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error

                        Gson gson = new Gson();

                        Rhymee response = gson.fromJson(result, Rhymee.class);



                    }
                });
    }

    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //txtSpeechInput.setText(result.get(0));
                    String speachResult = result.get(0);
                    getJson(getApplicationContext(), speachResult);
                    mRhymesList.add(new Rhyme(speachResult));
                    loadAdapter(mRhymesList);
                }
                break;
            }

        }
    }

    private void loadAdapter(ArrayList<Rhyme> rhymes) {
//        items = new ArrayList<>();
//        items.add(new Rhyme(R.drawable.ic_full_cancel, getString(R.string.theme)));
//        items.add(new Rhyme(R.drawable.ic_full_sad, getString(R.string.more_on_phone)));


        mAdapter = new SettingsAdapter(this, rhymes);


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