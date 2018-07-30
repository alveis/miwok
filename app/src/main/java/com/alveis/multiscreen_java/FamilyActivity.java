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

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        /**
         * show message when playback is complete
         * @param mMediaPlayer
         */
        @Override
        public void onCompletion(MediaPlayer mMediaPlayer) {
            releaseMediaPlayer();
            Toast.makeText(FamilyActivity.this, "Playback complete", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);


        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "epe", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("mother", "ete", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("son", "angsi", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("duaghter", "tune", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("older brother", "taachi", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("younger brother", "chalitti", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("older sister", "tete", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("younger sister", "kolliti", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("grandmother", "ama", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));
        words.add(new Word("grandfather", "paapa", R.drawable.ic_launcher_background, R.raw.jason_derulo_stupid_love));


        Log.v("NumbersActivity", "words is an array of numbers one to ten in an array");
//        LinearLayout numbersRootView = (LinearLayout) findViewById(R.id.numbers_root_view);
//
//        int index = 0;
//        while (index<words.size()){
//            TextView number = new TextView(this);
//            number.setText(words.get(index));
//            index++;
//        }

        WordAdapter itemsAdapter = new WordAdapter(this,  words, R.color.category_family);

        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Word word = words.get(position);

                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this,  word.getAudioResourceId());
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                //Toast.makeText(NumbersActivity.this, "play", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        /* release memory when the app looses focus */
        releaseMediaPlayer();
    }
}
