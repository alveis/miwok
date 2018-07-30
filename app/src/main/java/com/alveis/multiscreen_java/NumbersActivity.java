package com.alveis.multiscreen_java;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        /**
         * show message when playback is complete
         * @param mMediaPlayer
         */
        @Override
        public void onCompletion(MediaPlayer mMediaPlayer) {
            releaseMediaPlayer();
            Toast.makeText(NumbersActivity.this, "Playback complete", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("one", "lutti", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("two", "otiiko", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("three", "tolookosu", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("four", "oyyisa", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("five", "massokka", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("six", "temmoka", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("seven", "kenekaku", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("nine", "wo'e", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("ten", "na'aacha", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));


        Log.v("NumbersActivity", "words is an array of numbers one to ten in an array");
//        LinearLayout numbersRootView = (LinearLayout) findViewById(R.id.numbers_root_view);
//
//        int index = 0;
//        while (index<words.size()){
//            TextView number = new TextView(this);
//            number.setText(words.get(index));
//            index++;.
//        }

        WordAdapter itemsAdapter = new WordAdapter(this,  words, R.color.category_numbers);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);

                /* release memory before starting to play a new song, this is in case the user taps on many  items, one sound file will not be finished
                * before the next one is clicked, so it is important to clear the memory before starting to play a new song*/
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,  word.getAudioResourceId());
                mMediaPlayer.start();

                //clear the memory once playback is complete
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                //Toast.makeText(NumbersActivity.this, "play", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void releaseMediaPlayer(){
        if (mMediaPlayer != null){
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
}
